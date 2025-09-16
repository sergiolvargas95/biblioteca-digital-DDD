package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.FechaInvalidaException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

import java.time.LocalDateTime;

public class FechaPrestamo {
    public final LocalDateTime date;

    public FechaPrestamo(LocalDateTime date) {
        if(date == null) {
            throw new TextoInvalidoException("fecha de prestamo");
        }

        if(!date.toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
            throw new FechaInvalidaException("fecha de préstamo", "debe ser el día de hoy");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
