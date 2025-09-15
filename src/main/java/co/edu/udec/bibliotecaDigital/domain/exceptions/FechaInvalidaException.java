package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class FechaInvalidaException extends RuntimeException {
    public FechaInvalidaException(String value, String detalle) {
        super("El campo " + value + " es inválido: " + detalle);
    }
}
