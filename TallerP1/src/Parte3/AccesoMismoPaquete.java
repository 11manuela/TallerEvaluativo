package Parte3;

import Parte3.Mascota;

public class AccesoMismoPaquete {

    public static void main(String[] args) {
        Mascota m = new Mascota();
        // System.out.println(m.nombrePrivado); // Error
        System.out.println(m.nombreDefault);     // OK
        System.out.println(m.nombreProtegido);   // OK
        System.out.println(m.nombrePublico);     // OK

        // m.metodoPrivado(); // Error
        m.metodoDefault();     // OK
        m.metodoProtegido();   // OK
        m.metodoPublico();     // OK

        //¿Qué modificadores son accesibles desde una subclase en otro paquete?
        //Protected y public son accesibles
        //¿Que modificadores permite acceder desde cualquier clase del mismo paquete?
        //Default, public y protected
        //¿Que pasaría si todos los atributos fueran public?
        //Se podría acceder de forma más fácil a los atributos, modificarlos y alterar su estado en una clase
        // permitiendo así posibles errores.
    }
}
