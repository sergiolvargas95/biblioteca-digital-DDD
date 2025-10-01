package co.edu.udec.bibliotecaDigital.infrastructure.mappers;

import co.edu.udec.bibliotecaDigital.application.dtos.UsuarioDto;
import co.edu.udec.bibliotecaDigital.domain.exceptions.EmailInvalidoException;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.CreatedAt;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.UpdatedAt;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioJpaMapper {

    public static Usuario toDomain(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.id,
                usuarioDto.primerNombre,
                null,
                usuarioDto.primerApellido,
                null,
                new Email(usuarioDto.email),
                new Password(usuarioDto.password),
                new CreatedAt(LocalDateTime.now()),
                new UpdatedAt(LocalDateTime.now(), LocalDateTime.now())
        );
    }

    public static UsuarioDto toDTO(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto(
                usuario.getPassword().getPassword(),
                usuario.getPrimerNombre(),
                usuario.getSegundoNombre(),
                usuario.getPrimerApellido(),
                usuario.getSegundoNombre(),
                usuario.getEmail().getEmail(),
                usuario.getId()
        );
        dto.id = usuario.getId();
        dto.primerNombre = usuario.getPrimerNombre();
        dto.email = usuario.getEmail().getEmail();
        dto.password = usuario.getPassword().getPassword();
        return dto;
    }
}
