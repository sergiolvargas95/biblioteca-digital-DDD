package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.NumeroPaginasInvalidoException;

public class NumeroPaginas {
    private final int paginas;

    public NumeroPaginas(int paginas) {
        if(paginas <= 0) {
            throw new NumeroPaginasInvalidoException(paginas);
        }

        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }
}
