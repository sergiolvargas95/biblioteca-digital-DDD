package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.EmailInvalidoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EmailTest {

    @Test
    void deberiaCrearEmailValido() {
        Email email = new Email("usuario@test.com");
        assertThat(email.getEmail()).isEqualTo("usuario@test.com");
    }

    @Test
    void deberiaFallarSiEmailNoTieneArroba() {
        assertThatThrownBy(() -> new Email("usuariotest.com"))
                .isInstanceOf(EmailInvalidoException.class)
                .hasMessage("El email proporcionado es inválido: usuariotest.com");
    }
}