package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.application.DTOs.requests.RegistrarLibroRequest;

public interface RegistrarLibroUseCase {
    Long registrarLibro(RegistrarLibroRequest request);
}
