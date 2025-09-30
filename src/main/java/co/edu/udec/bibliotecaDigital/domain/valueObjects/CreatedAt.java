package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import co.edu.udec.bibliotecaDigital.domain.exceptions.FechaInvalidaException;
import co.edu.udec.bibliotecaDigital.domain.exceptions.TextoInvalidoException;

import java.sql.Date;
import java.time.LocalDateTime;

public class CreatedAt {
    private final LocalDateTime date;

    public CreatedAt(LocalDateTime date) {
        if(date == null) {
            throw new TextoInvalidoException("fecha de creación");
        }

        if(date.isAfter(LocalDateTime.now())) {
            throw new FechaInvalidaException("fecha de creación", "no puede ser posterior a la fecha de hoy");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
