package co.edu.udec.bibliotecaDigital.infrastructure.adapters.in.rest;

import co.edu.udec.bibliotecaDigital.application.ports.in.RegistrarLibroUseCase;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Autor;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Libro;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Isbn;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.NumeroPaginas;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.TituloLibro;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

//Ejemplo y simulación con entrada vía HTTP
public class RegistrarLibroController implements HttpHandler {
    private final RegistrarLibroUseCase useCase;

    public RegistrarLibroController(RegistrarLibroUseCase registrarLibroUseCase) {
        this.useCase = registrarLibroUseCase;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if("POST".equals(exchange.getRequestMethod())) {
            Libro libro = new Libro(
                    1L,
                    new TituloLibro("Cien años de soledad"),
                    new NumeroPaginas(500),
                    new Isbn("asdfasdfasdff"),
                    new Autor(1L, "Gabriel", "", "Garcia", "Marquez", "Colombiano")
            );

            useCase.registrarLibro(libro);

            System.out.println("Libro registrado correctamente.");
        }
    }
}
