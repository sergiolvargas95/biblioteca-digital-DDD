package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.application.DTOs.requests.RegistrarLibroRequest;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Autor;

public interface RegistrarLibroUseCase {
    Long registrarLibro(String titulo,
                        String isbn,
                        int numeroPaginas,
                        Long autorId);
}
