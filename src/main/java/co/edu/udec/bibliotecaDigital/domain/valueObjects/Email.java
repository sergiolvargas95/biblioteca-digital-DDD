package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.EmailInvalidoException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

import java.util.Objects;

public class Email {
    private final String email;

    public Email(String email) {
        if(email == null || email.isBlank()) {
            throw new TextoInvalidoException("email");
        }

        if(email.indexOf('@') <= 0) {
            throw new EmailInvalidoException(email);
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
