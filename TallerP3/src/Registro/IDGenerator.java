package Registro;

import java.util.ArrayList;

public class IDGenerator {
    //Se crea automaticamente el codigo para mascotas y consultas
    private static int contadorConsulta = 0;
    private static int contadorMascota = 0;

    public static String generarCodigoConsulta() {
        return "Consulta" + (++contadorConsulta);
    }

    public static String generarCodigoMascota() {
        return "Mascota" + (++contadorMascota);
    }
}



