package co.edu.udec.bibliotecaDigital.domain.valueObjects;

public class NumeroPaginas {
    private final int paginas;

    public NumeroPaginas(int paginas) {
        if(paginas <= 0) {
            throw new IllegalArgumentException("Número de las páginas debe ser mayor a 0");
        }

        this.paginas = paginas;
    }
}
