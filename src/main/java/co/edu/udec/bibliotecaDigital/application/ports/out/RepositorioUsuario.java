package co.edu.udec.bibliotecaDigital.application.ports.out;

import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface RepositorioUsuario {
    void guardar(Usuario usuario);
    Usuario buscarPorEmail(String email);
    Usuario buscarPorId(Long id);
}
