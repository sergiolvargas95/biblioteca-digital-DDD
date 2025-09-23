# Biblioteca Digital — Capa de Dominio (DDD + Hexagonal)

## Estructura de paquetes
co.edu.udec.bibliotecaDigital.domain
├─ model
│  ├─ entities        (Usuario, Libro, Autor)
│  ├─ aggregates      (Prestamo)
│  └─ valueObjects    (Email, ISBN, FechaPrestamo, FechaDevolucion, NumeroPaginas, TituloLibro)
├─ events             (DomainEvent, PrestamoVencidoEvent)
├─ exceptions         (DomainException, EmailInvalidoException, PrestamoNoPermitidoException, ...)
├─ services           (EstrategiaDuracionPrestamo, implementaciones)
├─ factories          (LibroFactory, PrestamoFactory)
├─ specifications     (Specification, UsuarioPuedePedirPrestamoSpecification)
└─ ports              (in/out si aplica)

## Patrones aplicados
- Factory: para creación consistente de entidades con VOs.
- Specification: para reglas de negocio compuestas (ej: límites de préstamos).
- Strategy: para políticas de duración del préstamo.
- Domain Events: para comunicar sucesos (PrestamoVencido).

## Invariantes en el dominio
- FechaDevolucion >= FechaPrestamo.
- Un libro no puede ser prestado si no está disponible.
- Usuario no puede tener más de N préstamos activos (especificación).

## Cómo ejecutar tests
- `mvn test` (asegúrate de tener dependencias JUnit 5 y AssertJ en `pom.xml`).

## Cómo integrar con infraestructura
1. Implementar `ports.out.RepositorioPrestamo` en `infrastructure.persistence` (JPA, JDBC, Mongo).
2. Implementar `ports.in.GestionPrestamoUseCase` con un Service de aplicación que use repositorios.
3. Publicar `DomainEvent`s desde la capa de aplicación después de persistir (usar Outbox para consistencia).

## Diseño para pruebas
- Dominio es totalmente testeable sin base de datos; usa implementaciones en memoria para repositorios en tests.

## Notas
- Mantener las clases del dominio libres de anotaciones de frameworks.
- Los mensajes de excepciones están en lenguaje ubicuo (ej. "Usuario no cumple especificaciones para prestar").

