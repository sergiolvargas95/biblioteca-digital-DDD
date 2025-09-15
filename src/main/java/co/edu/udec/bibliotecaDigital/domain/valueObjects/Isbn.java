package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

public class Isbn {
    private final String value;

    //constructor
    public Isbn(String value) {
        if(value == null || value.isBlank()) {
            throw new TextoInvalidoException("ISBN");
        }

        this.value = value;
    }

    //solo getters porque value es final
    public String getValue() {
        return value;
    }
}
