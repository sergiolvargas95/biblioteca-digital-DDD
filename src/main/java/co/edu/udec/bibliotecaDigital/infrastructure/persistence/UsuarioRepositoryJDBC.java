package co.edu.udec.bibliotecaDigital.infrastructure.persistence;

import co.edu.udec.bibliotecaDigital.application.ports.out.RepositorioUsuario;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.*;

import java.sql.*;

public class UsuarioRepositoryJDBC implements RepositorioUsuario {
    private final String url = "jdbc:h2:men:biblioteca";
    private final String user = "root";
    private final String password = "";

    @Override
    public Usuario guardar(Usuario usuario) {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO usuarios(id, primero_nombre, segundo_nombre, primer_apellido, segundo_apellido, email, password, created_at, updated_at" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setLong(1, usuario.getId());
            ps.setString(2, usuario.getPrimerNombre());
            ps.setString(3, usuario.getSegundoNombre());
            ps.setString(4,usuario.getPrimerApellido());
            ps.setString(5, usuario.getSegundoApellido());
            ps.setString(6, usuario.getEmail().getEmail());
            ps.setString(7, usuario.getPassword().getPassword());
            ps.setTimestamp(8, java.sql.Timestamp.valueOf(usuario.getCreatedAt().getDate()));
            ps.setTimestamp(9, java.sql.Timestamp.valueOf(usuario.getUpdatedAt().getDate()));

            ps.executeUpdate();

            return usuario;
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el usuario en la base de datos", e);
        }
    }

    @Override
    public Usuario buscarPorEmail(Email email) {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT id, primero_nombre, segundo_nombre, primer_apellido, segundo_apellido, password, created_at, updated_at FROM usuarios WHERE email = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(email));

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Usuario(
                        rs.getLong("id"),
                        rs.getString("primero_nombre"),
                        rs.getString("segundo_nombre"),
                        rs.getString("primero_apellido"),
                        rs.getString("segundo_apellido"),
                        email,
                        new Password(rs.getString("password")),
                        new CreatedAt(rs.getTimestamp("created_at").toLocalDateTime()),
                        new UpdatedAt(rs.getTimestamp("created_at").toLocalDateTime(),rs.getTimestamp("updated_at").toLocalDateTime())
                );
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario en la base de datos", e);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT primero_nombre, segundo_nombre, primer_apellido, segundo_apellido, email, password, created_at, updated_at FROM usuarios WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Usuario(
                        id,
                        rs.getString("primero_nombre"),
                        rs.getString("segundo_nombre"),
                        rs.getString("primero_apellido"),
                        rs.getString("segundo_apellido"),
                        new Email(rs.getString("email")),
                        new Password(rs.getString("password")),
                        new CreatedAt(rs.getTimestamp("created_at").toLocalDateTime()),
                        new UpdatedAt(rs.getTimestamp("created_at").toLocalDateTime(),rs.getTimestamp("updated_at").toLocalDateTime())
                );
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar usuario en la base de datos", e);
        }
    }
}
