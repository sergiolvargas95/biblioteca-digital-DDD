package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import java.time.LocalDateTime;

public class FechaPrestamo {
    public final LocalDateTime date;

    public FechaPrestamo(LocalDateTime date) {
        if(date == null) {
            throw new IllegalArgumentException("La fecha de prestamo no puede estar vacía.");
        }

        if(!date.toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
            throw new IllegalArgumentException("La fecha de préstamo debe ser el día de hoy");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
