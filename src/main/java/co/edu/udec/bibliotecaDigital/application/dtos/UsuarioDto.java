package co.edu.udec.bibliotecaDigital.application.dtos;

import co.edu.udec.bibliotecaDigital.domain.valueObjects.Email;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.Password;

public class UsuarioDto {
    public Long id;
    public String primerNombre;
    public String primerApellido;
    public String email;
    public String password;
}
