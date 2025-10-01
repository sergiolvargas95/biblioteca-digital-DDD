package co.edu.udec.bibliotecaDigital.infrastructure.persistence;

import co.edu.udec.bibliotecaDigital.application.ports.out.RepositorioLibro;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Isbn;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.NumeroPaginas;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.TituloLibro;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LibroRepositoryJDBC implements RepositorioLibro {
    private final String url = "jdbc:h2:men:biblioteca";
    private final String user = "root";
    private final String password = "";

    @Override
    public void guardar(Libro libro) {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO libros (id, titulo, isbn, paginas) VALUES(?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, libro.getId());
            ps.setString(2, libro.getTitulo().getTitulo());
            ps.setString(3, libro.getIsbn().getValue());
            ps.setInt(4, libro.getPaginas().getPaginas());
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar libro en la base de datos", e);
        }
    }

    @Override
    public Libro buscarPorIsbn(String isbn) {
        return null;
    }

    @Override
    public Libro buscarPorId(Long id) {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT titulo, isbn, paginas FROM libros WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Libro(
                        id,
                        new TituloLibro(rs.getString("titulo")),
                        new NumeroPaginas(rs.getInt("paginas")),
                        new Isbn(rs.getString("isbn")),
                        null
                );
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar libro en la base de datos", e);
        }
    }
}
