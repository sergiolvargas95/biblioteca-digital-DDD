package co.edu.udec.bibliotecaDigital.application.ports.in;

import co.edu.udec.bibliotecaDigital.application.dtos.UsuarioDto;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;

public interface RegistrarUsuarioUseCase {
    Usuario registrarUsuario(UsuarioDto usuario);
}
