package co.edu.udec.bibliotecaDigital.application.ports.out;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface RepositorioLibro {
    Optional<Libro> buscarPorId(Long id);
    void guardar(Libro libro);
    List<Libro> buscarTodosLosLibros();
}
