package co.edu.udec.bibliotecaDigital.domain.factories;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Autor;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Isbn;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.NumeroPaginas;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.TituloLibro;

public class LibroFactory {
    public static Libro crearLibro(Long id, String titulo, int paginas, String isbn, Autor autor) {
        return new Libro(
                id,
                new TituloLibro(titulo),
                new NumeroPaginas(paginas),
                new Isbn(isbn),
                autor
        );
    }
}
