package co.edu.udec.bibliotecaDigital.application.ports.out;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface RepositorioLibro {
    void guardar(Libro libro);
    Libro buscarPorIsbn(String isbn);
    Libro buscarPorId(Long id);
}
