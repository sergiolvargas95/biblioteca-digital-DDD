package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class ValidarTextoLongitudMinima extends RuntimeException {
    public ValidarTextoLongitudMinima(String value, String detalle) {
        super("el campo " + value + "no es válido: " + detalle);
    }
}
