package co.edu.udec.bibliotecaDigital.infrastructure.adapters.in.rest;

import co.edu.udec.bibliotecaDigital.application.ports.in.RegistrarUsuarioUseCase;
import co.edu.udec.bibliotecaDigital.domain.model.entities.Usuario;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

//Ejemplo y simulación con entrada vía HTTP
public class RegistrarUsuarioController implements HttpHandler {
    private final RegistrarUsuarioUseCase useCase;

    public RegistrarUsuarioController(RegistrarUsuarioUseCase registrarUsuarioUseCase) {
        this.useCase = registrarUsuarioUseCase;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if("POST".equals(exchange.getRequestMethod())) {
            Usuario usuario = new Usuario(
                    1L,
                    "Juan",
                    "Carlos",
                    "Pérez",
                    "López",
                    new Email("juan@test.com"),
                    new Password("secure123"),
                    null,
                    null
            );

            useCase.registrarUsuario(usuario);

            String response = "Usuario registrado correctamente.";

            exchange.sendResponseHeaders(200, response.getBytes().length);
            try(OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }
    }
}
