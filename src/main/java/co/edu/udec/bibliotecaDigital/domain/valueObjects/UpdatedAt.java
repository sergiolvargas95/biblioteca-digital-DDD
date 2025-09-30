package co.edu.udec.bibliotecaDigital.domain.valueObjects;

import java.sql.Date;
import java.time.LocalDateTime;

public class UpdatedAt {
    private final LocalDateTime date;

    public UpdatedAt(LocalDateTime createdAt, LocalDateTime updatedAt) {
        if(updatedAt == null) {
            throw new IllegalArgumentException("La fecha de actualización no puede ser nula.");
        }

        if(updatedAt.isBefore(createdAt)) {
            throw new IllegalArgumentException("La fecha de actualización no puede ser anterior a la fecha de creación");
        }

        if(updatedAt.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de actualización no puede ser posterior a la fecha de hoy.");
        }

        this.date = updatedAt;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
