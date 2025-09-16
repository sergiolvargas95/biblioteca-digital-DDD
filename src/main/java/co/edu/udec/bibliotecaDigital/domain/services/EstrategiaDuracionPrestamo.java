package co.edu.udec.bibliotecaDigital.domain.services;

import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaDevolucion;
import co.edu.udec.bibliotecaDigital.domain.valueObjects.FechaPrestamo;

public interface EstrategiaDuracionPrestamo {
    FechaDevolucion calcularFechaDevolucion(FechaPrestamo fechaPrestamo);
}
