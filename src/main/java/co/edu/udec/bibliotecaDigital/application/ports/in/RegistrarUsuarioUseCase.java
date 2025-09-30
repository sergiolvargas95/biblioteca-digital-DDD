package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;

public interface RegistrarUsuarioUseCase {
    void registrarUsuario(Usuario usuario);
}
