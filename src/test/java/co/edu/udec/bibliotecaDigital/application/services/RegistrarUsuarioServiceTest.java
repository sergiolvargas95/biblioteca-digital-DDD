package co.edu.udec.bibliotecaDigital.application.services;

import co.edu.udec.bibliotecaDigital.application.dtos.UsuarioDto;
import co.edu.udec.bibliotecaDigital.application.ports.out.RepositorioUsuario;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.CreatedAt;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.UpdatedAt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RegistrarUsuarioServiceTest {
    private RepositorioUsuario repositorioUsuario;
    private RegistrarUsuarioService registrarUsuarioService;

    @BeforeEach
    void setUp() {
        repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        registrarUsuarioService = new RegistrarUsuarioService(repositorioUsuario);
    }

    @Test
    void deberiaRegistrarUsuarioNuevo() {
        UsuarioDto usuarioDto = new UsuarioDto(
                "1234235234",
                "svargasm@unicartagena.edu.co",
                "Melendez",
                "Vargas",
                "Luis",
                "Sergio",
                1L
        );


        Usuario usuario = new Usuario(
                usuarioDto.getId(),
                usuarioDto.getPrimerNombre(),
                usuarioDto.getSegundoNombre(),
                usuarioDto.getPrimerApellido(),
                usuarioDto.getSegundoApellido(),
                new Email(usuarioDto.getEmail()),
                new Password(usuarioDto.getPassword()),
                new CreatedAt(LocalDateTime.now()),
                new UpdatedAt(LocalDateTime.now(), LocalDateTime.now())
        );

        when(repositorioUsuario.guardar(any(Usuario.class)))
                .thenReturn(usuario);


        Usuario usuarioGuardado = registrarUsuarioService.registrarUsuario(usuarioDto);

        assert (usuarioGuardado.getEmail().getEmail())
                .equals("svargasm@unicartagena.edu.co");

        verify(repositorioUsuario,times(1))
                .guardar(any(Usuario.class));
    }
}
