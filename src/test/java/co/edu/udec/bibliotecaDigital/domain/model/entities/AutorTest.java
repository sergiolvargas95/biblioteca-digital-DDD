package co.edu.udec.bibliotecaDigital.domain.model.entities;

import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AutorTest {

    @Test
    void deberiaCrearAutorValido() {
        Autor autor = new Autor(1L, "Gabriel", "José", "García", "Márquez", "Colombiana");
        assertThat(autor.getPrimerNombre()).isEqualTo("Gabriel");
        assertThat(autor.getNacionalidad()).isEqualTo("Colombiana");
    }

    @Test
    void deberiaFallarSiPrimerNombreEsVacio() {
        assertThatThrownBy(() -> new Autor(1L, "", "José", "García", "Márquez", "Colombiana"))
                .isInstanceOf(TextoInvalidoException.class)
                .hasMessage("El campo primer nombre no puede estar vacío");
    }

    @Test
    void deberiaFallarSiNacionalidadEsNula() {
        assertThatThrownBy(() -> new Autor(1L, "Gabriel", "José", "García", "Márquez", null))
                .isInstanceOf(TextoInvalidoException.class)
                .hasMessage("El campo nacionalidad no puede estar vacío");
    }
}