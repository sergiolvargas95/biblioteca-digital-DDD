package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String email) {
        super("El email proporcionado es inválido: " + email);
    }
}
