package co.edu.udec.bibliotecaDigital.application.services;

import co.edu.udec.bibliotecaDigital.application.dtos.UsuarioDto;
import co.edu.udec.bibliotecaDigital.application.ports.in.RegistrarUsuarioUseCase;
import co.edu.udec.bibliotecaDigital.application.ports.out.RepositorioUsuario;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.CreatedAt;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.UpdatedAt;

import java.time.LocalDateTime;

public class RegistrarUsuarioService implements RegistrarUsuarioUseCase {
    private final RepositorioUsuario repositorioUsuario;

    public RegistrarUsuarioService(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public Usuario registrarUsuario(UsuarioDto usuarioDto) {
        if (repositorioUsuario.buscarPorEmail(new Email(usuarioDto.getEmail())) != null) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = new Usuario(
                usuarioDto.getId(),
                usuarioDto.primerNombre,
                usuarioDto.segundoNombre,
                usuarioDto.primerApellido,
                usuarioDto.segundoApellido,
                new Email(usuarioDto.getEmail()),
                new Password(usuarioDto.getPassword()),
                new CreatedAt(LocalDateTime.now()),
                new UpdatedAt(LocalDateTime.now(), LocalDateTime.now())
        );

        return repositorioUsuario.guardar(usuario);
    }
}
