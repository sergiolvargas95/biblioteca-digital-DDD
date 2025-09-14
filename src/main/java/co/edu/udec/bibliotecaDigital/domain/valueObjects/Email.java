package co.edu.udec.bibliotecaDigital.domain.valueObjects;

public class Email {
    private final String email;

    public Email(String email) {
        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacio");
        }

        if(email.indexOf('@') <= 0) {
            throw new IllegalArgumentException("El email debe ser válido");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
