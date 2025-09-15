package co.edu.udec.bibliotecaDigital.domain.events;

import java.time.LocalDateTime;

public interface DomainEvent {
    LocalDateTime occurredOn();
    String eventName();
}
