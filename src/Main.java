import java.util.Scanner;
 //sumar
public class Main {
     /*public static void main(String[] args) {

         int suma = 0;
         for (int i = 1; i <= 100; i++) {
             suma+= i;
         }
         System.out.println("La suma es: " + suma);
     }

 }
      *//*
    // tabla de Multiplicar
public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
        System.out.println("5 X " + i + " = " + (5 * i));
    }
}
}*/
/*
public static void main(String[] args) {
    calcular_area(5,10);
    calcular_area(3.5, 7.2);
}
public static void calcular_area(double base, double altura){

    System.out.println(base*altura );
}

}

 */
    /*
    public static void main(String[] args) {

        compararNumeros(5,7);
        compararNumeros(7,7);
        compararNumeros(8,2);

    }
    public static void compararNumeros (int num1, int num2){
        if ( num1 == num2) {
            System.out.println("Num1 es igual a num 2");
        } else if  ( num1 > num2 ) {
            System.out.println("numero 1 es mayor a numero 2");
        } else {
            System.out.println("numero 1 es menor que 2");
        }
    }
 }
 */
     /*
 public static void main (String[] arg) {
     calcularDescuento(150,20);
 }
    public static void  calcularDescuento (double precio_original, int descuento){
     double precioFinal = precio_original - (precio_original * descuento/100);
     System.out.println("precio final es:" + precioFinal);
    }
 }

      */

     public static void main(String[] args) {
         for (int i = 1; i <= 5; i++) {
             // Imprimir espacios para centrar la pirámide
             for (int j = 5; j > i; j--) {
                 System.out.print(" ");
             }
             // Imprimir números en cada nivel de la pirámide
             for (int k = 1; k <= i; k++) {
                 System.out.print(i + " ");
             }
             System.out.println();
         }
     }
 }

      


