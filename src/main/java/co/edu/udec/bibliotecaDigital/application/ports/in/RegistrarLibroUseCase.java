package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.application.DTOs.requests.RegistrarLibroRequest;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Autor;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;

public interface RegistrarLibroUseCase {
    Long registrarLibro(Libro libro);
}
