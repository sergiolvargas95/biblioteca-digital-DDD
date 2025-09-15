package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.PasswordInvalidoException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

public class Password {
    private final String password;

    public Password(String password) {
        if (password == null || password.isBlank()) {
            throw new TextoInvalidoException("password");
        }

        if(password.length() <= 5) {
            throw new PasswordInvalidoException("Debe tener más de 5 caracteres");
        }

        this.password = password;
    }

    //En una aplicación en producción este valor debe ir encriptado
    public String getPassword() {
        return password;
    }
}
