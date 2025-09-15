package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.PasswordInvalidoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PasswordTest {

    @Test
    void deberiaCrearPasswordValido() {
        Password password = new Password("password123");
        assertThat(password.getPassword()).isEqualTo("password123");
    }

    @Test
    void deberiaFallarSiPassowrdEsMuyCorto() {
        assertThatThrownBy(() -> new Password("123"))
                .isInstanceOf(PasswordInvalidoException.class)
                .hasMessage("El password no es válido: Debe tener más de 5 caracteres");
    }
}
