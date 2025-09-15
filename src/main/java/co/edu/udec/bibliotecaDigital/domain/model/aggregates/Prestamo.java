package co.edu.udec.bibliotecaDigital.domain.model.aggregates;

import co.edu.udec.bibliotecaDigital.domain.enums.EstadoPrestamo;
import co.edu.udec.bibliotecaDigital.domain.events.DomainEvent;
import co.edu.udec.bibliotecaDigital.domain.events.PrestamoVencidoEvent;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.EstadoPrestamoVO;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaDevolucion;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaPrestamo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private final Long id;
    private final Usuario usuario;
    private final Libro libro;
    private final FechaPrestamo fechaPrestamo;
    private FechaDevolucion fechaDevolucion;
    private EstadoPrestamoVO estado;
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public Prestamo(Long id, Usuario usuario, Libro libro, FechaPrestamo fechaPrestamo, FechaDevolucion fechaDevolucion, EstadoPrestamoVO estado) {
        if(usuario == null) {
            throw new IllegalArgumentException("El préstamo debe tener un usuario");
        }

        if(libro == null) {
            throw new IllegalArgumentException("El préstamo debe tener un libro.");
        }

        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public FechaPrestamo getFechaPrestamo() {
        return fechaPrestamo;
    }

    public FechaDevolucion getFechaDevolucion() {
        return fechaDevolucion;
    }

    public EstadoPrestamoVO getEstado() {
        return estado;
    }

    public void marcarComoDevuelto(FechaDevolucion fechaDevolucion) {
        if(!this.estado.puedeTransicionarA(EstadoPrestamo.DEVUELTO)) {
            throw new IllegalArgumentException("No se puede devolver un préstamo ya devuelto");
        }

        this.fechaDevolucion = fechaDevolucion;
        this.estado = new EstadoPrestamoVO(EstadoPrestamo.DEVUELTO);
    }

    public void marcarComoVencido(LocalDateTime fechaDeteccion, int diasRetraso) {
        if (!this.estado.puedeTransicionarA(EstadoPrestamo.RETRASADO)) {
            throw new IllegalArgumentException("No se puede marcar como vencido un préstamo en estado: " + this.estado.getEstado());
        }

        if (fechaDeteccion.isBefore(this.fechaDevolucion.getDate())) {
            throw new IllegalArgumentException("No se puede marcar como vencido un préstamo antes de su fecha de vencimiento");
        }

        this.estado = new EstadoPrestamoVO(EstadoPrestamo.RETRASADO);

        domainEvents.add(new PrestamoVencidoEvent(
                this.id,
                usuario.getId(),
                libro.getId(),
                this.fechaDevolucion.getDate(),
                fechaDeteccion,
                diasRetraso
        ));
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> copy = new ArrayList<>(domainEvents);
        domainEvents.clear();
        return copy;
    }
}
