package co.edu.udec.bibliotecaDigital.application.DTOs.requests;


public final class RegistrarUsuarioRequest {
    public final String primerNombre;
    public final String primerApellido;
    public final String email;
    public final String password;

    public RegistrarUsuarioRequest(String primerNombre, String primerApellido, String email, String password) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.email = email;
        this.password = password;
    }
}
