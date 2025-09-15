package co.edu.udec.bibliotecaDigital.domain.events;

import java.time.LocalDateTime;
import java.util.Objects;

public final class PrestamoVencidoEvent implements DomainEvent {
    private final Long prestamoId;
    private final Long usuarioId;
    private final Long libroId;
    private final LocalDateTime fechaVencimiento;
    private final LocalDateTime fechaDeteccion;
    private final int diasRetraso;
    private final LocalDateTime occurredOn;

    public PrestamoVencidoEvent(Long prestamoId, Long usuarioId, Long libroId,
                                LocalDateTime fechaVencimiento, LocalDateTime fechaDeteccion,
                                int diasRetraso) {
        this.prestamoId = Objects.requireNonNull(prestamoId, "PrestamoId no puede ser null");
        this.usuarioId = Objects.requireNonNull(usuarioId, "UsuarioId no puede ser null");
        this.libroId = Objects.requireNonNull(libroId, "LibroId no puede ser null");
        this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento, "Fecha vencimiento no puede ser null");
        this.fechaDeteccion = Objects.requireNonNull(fechaDeteccion, "Fecha detección no puede ser null");

        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos");
        }

        this.diasRetraso = diasRetraso;
        this.occurredOn = LocalDateTime.now(); // Se establece automáticamente al momento de creación
    }

    // Constructor alternativo si necesitas especificar el momento exacto (para tests, etc.)
    public PrestamoVencidoEvent(Long prestamoId, Long usuarioId, Long libroId,
                                LocalDateTime fechaVencimiento, LocalDateTime fechaDeteccion,
                                int diasRetraso, LocalDateTime occurredOn) {
        this.prestamoId = Objects.requireNonNull(prestamoId, "PrestamoId no puede ser null");
        this.usuarioId = Objects.requireNonNull(usuarioId, "UsuarioId no puede ser null");
        this.libroId = Objects.requireNonNull(libroId, "LibroId no puede ser null");
        this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento, "Fecha vencimiento no puede ser null");
        this.fechaDeteccion = Objects.requireNonNull(fechaDeteccion, "Fecha detección no puede ser null");

        if (diasRetraso < 0) {
            throw new IllegalArgumentException("Los días de retraso no pueden ser negativos");
        }

        this.diasRetraso = diasRetraso;
        this.occurredOn = Objects.requireNonNull(occurredOn, "OccurredOn no puede ser null");
    }

    // Getters
    public Long getPrestamoId() {
        return prestamoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDateTime getFechaDeteccion() {
        return fechaDeteccion;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    // Implementación correcta de la interfaz DomainEvent
    @Override
    public LocalDateTime occurredOn() {
        return this.occurredOn;
    }

    @Override
    public String eventName() {
        return "PrestamoVencido";
    }

    // Métodos equals, hashCode y toString para mejor manejo del evento
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PrestamoVencidoEvent that = (PrestamoVencidoEvent) obj;
        return Objects.equals(prestamoId, that.prestamoId) &&
                Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(libroId, that.libroId) &&
                Objects.equals(occurredOn, that.occurredOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prestamoId, usuarioId, libroId, occurredOn);
    }

    @Override
    public String toString() {
        return "PrestamoVencidoEvent{" +
                "prestamoId=" + prestamoId +
                ", usuarioId=" + usuarioId +
                ", libroId=" + libroId +
                ", fechaVencimiento=" + fechaVencimiento +
                ", fechaDeteccion=" + fechaDeteccion +
                ", diasRetraso=" + diasRetraso +
                ", occurredOn=" + occurredOn +
                '}';
    }
}