/*
// clase coches
public class coche_malo {
    // atributos de coche_malo
    public String nombre;
    public String tipo;
    int fechaFabri;
    public String colorCoche;
    int kmTotales;
    Boolean necesitaInspeccion;


    /** Constructor
     *
     * @param nombre
     * @param tipo
     * @param fechaFabricacion
     * @param ColR
     * @param kmTotales

    coche_malo(String nombre, String tipo, int fechaFabricacion, String ColR, int kmTotales) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaFabri = fechaFabricacion;
        this.colorCoche = ColR;
        this.kmTotales = kmTotales;
        this.necesitaInspeccion = false;

        /**
         * @version 2.45.1
         * @author Daniel Pamies Teruel
         * @since 11/11/2024
         * @param fAB  Fecha del kilometraje
         * @throws necesitaInspeccion Es para ver si se necesita reparar
         * @see <a href = "http://www.elcampico.org/dam/ed" />elCampico</a>
         * @param nombre1
         * @param tipo1
         * @param fAB
         * @param ColR
         * @param KilometrosHechos

    }

    /**
     * Te indica si el coche necesita o no reparacion en funcion del Kilometraje
     */
/*
    public void inspeccion() {
        if (kmTotales > 9999) {
            reparar = true;
            System.out.println("EL COCHE ESTA ROTO");
        } else
            System.out.println("El coche esta bien");

        /**
         * @param kmTotales reparar
         * @return Si el coche esta bien o no.
         * @throws Si kmTotales es mayor que 9999 Km
         *
    }
    // Cambia del aceite
    public void cambioDeAceite() {
        // Los cambios de aceite se realizan cada 3000 km
        if (kmTotales > 3000) {
            System.out.println("ACEITE CAMBIADO");
            kmTotales = 0;
        } else
            System.out.println("NO TOCA CAMBIO DE ACEITE AUN");
        /**
         * @param kmTotales reparar
         * @return Si el coche esta bien o no.
         * @throws Si kmTotales es mayor que 9999 Km
        */
/*
    }

    //arreglar coche
    public void ARREGLARLO() {
        if (necesitaInspeccion) {
            System.out.println("ARREGLANDO EL COCHE");
            necesitaInspeccion = false;
        } else {
            System.out.println("NO HACE FALTA ARREGLAR NADA");
        }
    }
/*
    //mostrar info del coche
    public void InformacionCoche() {
        System.out.println("nombre: " + nombre);
        System.out.println("tipo de coche: " + tipo);
        System.out.println("año fabricacion: " + fechaFabri);
        System.out.println("Color coche: " + colorCoche);
        System.out.println("kilometraje hecho: " + kmTotales);
        System.out.println("¿NECESITA REP?: " + necesitaInspeccion);
    }
    // clase principal
    public static void main(String[] args) {
        coche_malo coche1 = new coche_malo("ford", "utilitario", 2022, "azul", 15000);
        coche1.InformacionCOCHE();
        coche1.inspeccion();
        coche1.cambioDeAceite();
        coche1.ARREGLARLO();
        coche1.InformacionCOCHE();
    }
}
*/