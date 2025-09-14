package co.edu.udec.bibliotecaDigital.domain.valueObjects;

public class Isbn {
    private final String value;

    //constructor
    public Isbn(String value) {
        if(value == null || value.isBlank()) {
            throw new IllegalArgumentException("El ISBN  no puede estar vacío.");
        }

        this.value = value;
    }

    //solo getters porque value es final
    public String getValue() {
        return value;
    }
}
