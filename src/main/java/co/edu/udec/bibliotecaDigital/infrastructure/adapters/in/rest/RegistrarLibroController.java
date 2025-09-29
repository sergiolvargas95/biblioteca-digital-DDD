package co.edu.udec.bibliotecaDigital.infrastructure.adapters.in.rest;


import co.edu.udec.bibliotecaDigital.application.ports.in.RegistrarLibroUseCase;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CrearLibroController implements HttpHandler {
    private final RegistrarLibroUseCase useCase;

    public RegistrarLibroController(RegistrarLibroUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if("POST".equals(exchange.getRequestMethod())) {
            String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);

            String[] params = body.split("&");
            String nombre = params[0].split("=")[1];
            String email = params[1].split("=")[1];

            Long idUsuario = useCase.registrarLibro(nombre, email);

            String response = "{ \"idUsuario\": " + idUsuario + " }";
            exchange.sendResponseHeaders(201, response.getBytes().length);

            try(OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        }


    }
}
