
/*package funciones;

import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        boolean es_Num;
//        es_Num = esNum ("11111",20);
//        if (es_Num){
//            System.out.println("LA CADENA ES NUMERICA");
//
//        }else {
//            System.out.println("NO ES NUMERICA");
//        }
//        int resultado= sumar( 7, 8);
//        System.out.println("La suma es: " +resultado);
//
//        double restar= restar(13.2, 15.4);
//        System.out.println("La resta es: " + +restar);
        String opcion = "";
        do {

            System.out.println("1. VER LISTA DE SERIES");
            System.out.println("2. vER LISTA DE PELICULAS");
            System.out.println("0. SALIR");
            opcion = sc.nextLine();

            if (esNum(opcion)) {
                int op = Integer.parseInt(opcion);
                switch (op) {

                    case 1:
                        System.out.println("SERIES");
                        break;
                    case 2:
                        System.out.println("PELIS");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                    default:
                        System.out.println("OPCION NO VALIDA");
                }
            } else {
                System.out.println("INTRODUCE UN VALOR NUMERICO");
            }

        } while (!opcion.equals("0"));


    }

    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }

    public static int restar(double num1, double num2) {

        int resultado = (int) Math.round(num1 - num2);
        return resultado;

    }

    public static boolean alta_series() {

        System.out.println("FORMULARIO ALTA SERIES");

        System.out.println("1. Introduce edad recomendada: ");
        String edad=sc.nextLine();
        if (!esNum(edad)){
            System.out.println("La edad tiene que ser un valor numerico");
        }

        return true;
    }

 */

