package co.edu.udec.bibliotecaDigital.domain.valueObjects;

public class Password {
    private final String password;

    public Password(String password) {
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("El password no puede estar vacío");
        }

        if(password.length() <= 5) {
            throw new IllegalArgumentException("El password debe tener más de 5 caracteres");
        }

        this.password = password;
    }

    //En una aplicación en producción este valor debe ir encriptado
    public String getPassword() {
        return password;
    }
}
