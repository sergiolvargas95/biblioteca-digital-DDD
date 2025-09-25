package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.application.DTOs.requests.RegistrarUsuarioRequest;

public interface RegistrarUsuarioUseCase {
    Long registrarUsuario(RegistrarUsuarioRequest request);
}
