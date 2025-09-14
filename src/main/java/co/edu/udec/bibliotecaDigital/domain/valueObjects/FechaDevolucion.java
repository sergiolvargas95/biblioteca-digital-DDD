package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import java.time.LocalDateTime;

public class FechaDevolucion {
    private final LocalDateTime date;

    public FechaDevolucion(LocalDateTime date, LocalDateTime fechaPrestamo) {
        if(date == null) {
            throw new IllegalArgumentException("La fecha de devolución no puede estar vacía.");
        }

        if(date.isBefore(fechaPrestamo)) {
            throw new IllegalArgumentException("La fecha de devolución no puede ser anterior a la fecha de préstamo");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
