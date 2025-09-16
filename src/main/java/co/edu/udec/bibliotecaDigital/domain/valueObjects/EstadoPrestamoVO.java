package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.enums.EstadoPrestamo;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

public class EstadoPrestamoVO {
    private final EstadoPrestamo estado;

    public EstadoPrestamoVO(EstadoPrestamo estado) {
        if(estado == null) {
            throw new TextoInvalidoException("estado");
        }
        this.estado = estado;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public boolean puedeTransicionarA(EstadoPrestamo nuevoEstado) {
        return switch (this.estado) {
            case ACTIVO -> nuevoEstado == EstadoPrestamo.DEVUELTO
                    || nuevoEstado == EstadoPrestamo.RETRASADO;
            case RETRASADO -> nuevoEstado == EstadoPrestamo.DEVUELTO;
            case DEVUELTO -> false; // un préstamo devuelto ya no puede cambiar de estado
            default -> false;
        };
    }
}
