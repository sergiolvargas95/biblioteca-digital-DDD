package co.edu.udec.bibliotecaDigital.domain.services;

import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaDevolucion;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaPrestamo;

import java.time.LocalDateTime;

public class PrestamoEstandar implements EstrategiaDuracionPrestamo{
    @Override
    public FechaDevolucion calcularFechaDevolucion(FechaPrestamo fechaPrestamo) {
        LocalDateTime fechaDev = fechaPrestamo.getDate().plusDays(15);
        return new FechaDevolucion(fechaDev, fechaPrestamo.getDate());
    }
}
