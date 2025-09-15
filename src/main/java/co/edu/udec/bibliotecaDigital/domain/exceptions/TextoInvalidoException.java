package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class TextoInvalidoException extends RuntimeException{
    public TextoInvalidoException(String value) {
        super("El campo" + value + " no puede estar vacío");
    }
}
