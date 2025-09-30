package co.edu.udec.bibliotecaDigital.domain.model.entities;

import co.edu.udec.bibliotecaDigital.domain.valueObjects.CreatedAt;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.UpdatedAt;

import java.time.LocalDateTime;

public class Usuario {
    private final Long id;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final Email email;
    private final Password password;
    private final CreatedAt createdAt;
    private final UpdatedAt updatedAt;

    public Usuario(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Email email, Password password, CreatedAt createdAt, UpdatedAt updatedAt) {
        if(primerNombre == null || primerNombre.isBlank()) {
            throw new IllegalArgumentException("El primer nombre no puede estar vacío");
        }

        if(primerApellido == null || primerApellido.isBlank()) {
            throw new IllegalArgumentException("El primer apellido no puede estar vacío");
        }

        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public CreatedAt getCreatedAt() {
        return createdAt;
    }

    public UpdatedAt getUpdatedAt() {
        return updatedAt;
    }

    public String getNombreCompleto() {
        return (primerNombre + " " +
                (segundoNombre != null ? segundoNombre + " " : "") +
                primerApellido + " " +
                (segundoApellido != null ? segundoApellido : "")).trim();
    }


}
