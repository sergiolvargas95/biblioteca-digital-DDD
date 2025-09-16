package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.FechaInvalidaException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

import java.time.LocalDateTime;

public class FechaDevolucion {
    private final LocalDateTime date;

    public FechaDevolucion(LocalDateTime date, LocalDateTime fechaPrestamo) {
        if(date == null) {
            throw new TextoInvalidoException("fecha de devolución");
        }

        if(date.isBefore(fechaPrestamo)) {
            throw new FechaInvalidaException("fecha de devolución","no puede ser anterior a la fecha de préstamo");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
