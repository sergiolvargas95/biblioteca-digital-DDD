package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class PasswordInvalidoException extends RuntimeException {
    public PasswordInvalidoException(String detalle) {
        super("El password no es válido: " + detalle);
    }
}
