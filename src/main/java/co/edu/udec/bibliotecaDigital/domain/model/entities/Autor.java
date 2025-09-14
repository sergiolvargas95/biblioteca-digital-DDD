package co.edu.udec.bibliotecaDigital.domain.model.entities;

public class Autor {
    private final Long id;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String nacionalidad;

    public Autor(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String nacionalidad) {
        if(primerNombre == null || primerNombre.isBlank()) {
            throw new IllegalArgumentException("El primer nombre no puede estar vacío");
        }

        if(primerApellido == null || primerApellido.isBlank()) {
            throw new IllegalArgumentException("El primer apellido no puede estar vacío");
        }

        if(nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException("La nacionalidad no puede estar vacía");
        }

        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {
        return id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getNombreCompleto() {
        return (primerNombre + " " +
                (segundoNombre != null ? segundoNombre + " " : "") +
                primerApellido + " " +
                (segundoApellido != null ? segundoApellido : "")).trim();
    }

}
