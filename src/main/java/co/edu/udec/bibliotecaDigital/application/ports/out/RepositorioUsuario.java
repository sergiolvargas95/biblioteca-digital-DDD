package co.edu.udec.bibliotecaDigital.application.ports.out;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface RepositorioUsuario {
    Optional<Usuario> buscarPorId(Long id);
    void guardar(Usuario usuario);
    List<Usuario> buscarTodosLosUsuarios();
}
