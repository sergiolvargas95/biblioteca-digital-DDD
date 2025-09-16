package co.edu.udec.bibliotecaDigital.domain.model.entities;

import co.edu.udec.bibliotecaDigital.domain.valueObjects.Isbn;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.NumeroPaginas;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.TituloLibro;

public class Libro {
    private final Long id;
    private final TituloLibro titulo;
    private final NumeroPaginas paginas;
    private final Isbn isbn;
    private Autor autor;

    public Libro(Long id, TituloLibro titulo, NumeroPaginas paginas, Isbn isbn, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.paginas = paginas;
        this.isbn = isbn;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public NumeroPaginas getPaginas() {
        return paginas;
    }

    public TituloLibro getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }
}
