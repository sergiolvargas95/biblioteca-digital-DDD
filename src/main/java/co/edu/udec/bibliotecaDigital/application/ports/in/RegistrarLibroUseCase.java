package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;

public interface RegistrarLibroUseCase {
    Long registrarLibro(Libro libro);
}
