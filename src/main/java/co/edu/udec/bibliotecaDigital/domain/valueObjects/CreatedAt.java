package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import java.time.LocalDateTime;

public class CreatedAt {
    private final LocalDateTime date;

    public CreatedAt(LocalDateTime date) {
        if(date == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ser nula");
        }

        if(date.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de creación no puede ser posterior a la fecha de hoy");
        }

        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
