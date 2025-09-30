package co.edu.udec.bibliotecaDigital.application.ports.out;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;

import java.util.List;
import java.util.Optional;

public interface RepositorioUsuario {
    Usuario guardar(Usuario usuario);
    Usuario buscarPorEmail(Email email);
    Usuario buscarPorId(Long id);
}
