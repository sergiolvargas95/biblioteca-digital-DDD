package co.edu.udec.bibliotecaDigital.application.dtos.requests;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Autor;

public class RegistrarLibroRequest {
    public final String titulo;
    public final int paginas;
    public final String isbn;
    public final Autor autor;

    public RegistrarLibroRequest(String titulo, int paginas, String isbn, Autor autor) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.isbn = isbn;
        this.autor = autor;
    }
}
