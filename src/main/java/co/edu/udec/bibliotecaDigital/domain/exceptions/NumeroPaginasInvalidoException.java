package co.edu.udec.bibliotecaDigital.domain.exceptions;

public class NumeroPaginasInvalidoException extends RuntimeException {
    public NumeroPaginasInvalidoException(int paginas) {
        super("El número de páginas debe ser mayor a 0. Valor recibido: " + paginas);
    }
}
