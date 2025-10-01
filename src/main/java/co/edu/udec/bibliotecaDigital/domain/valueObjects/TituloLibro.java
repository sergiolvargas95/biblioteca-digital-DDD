package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.ValidarTextoLongitudMinima;

public class TituloLibro {
    private final String titulo;

    public TituloLibro(String titulo) {
        if(titulo == null || titulo.isBlank()) {
            throw new TextoInvalidoException("titulo");
        }

        if(titulo.length() < 3) {
            throw new ValidarTextoLongitudMinima("titulo", "Debe tener más de tres caracteres.");
        }

        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
