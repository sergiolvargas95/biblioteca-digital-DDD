package co.edu.udec.bibliotecaDigital.domain.valueObjects;

public class TituloLibro {
    private final String titulo;

    public TituloLibro(String titulo) {
        if(titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo no puede estar vacío");
        }

        if(titulo.length() < 3) {
            throw new IllegalArgumentException("El titulo debe tener más de tres caracteres.");
        }

        this.titulo = titulo;
    }
}
