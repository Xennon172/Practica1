import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner entrada = new Scanner(System.in);
        String nombre_registrado= "", apellido_registrado ="", email_registrado = "",
                dni_registrado= "", fecha_registrada= "", contraseña_registrada1="",
                contraseña_registrada2= "", respuesta_seguridad =" ";
        int opcion;
        do {
            System.out.println("========== Menu de inicio ========== \n" +
                    "\t 1. Login\n" +
                    "\t 2. Registro\n" +
                    "\t 3. Recuperacion de Contraseña \n" +
                    "\t 4. Salir \n");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Login");
                    System.out.println("Ingresa tu nombre de usuario:");
                    Scanner nombre = new Scanner(System.in);
                    String nombre_usuario = nombre.nextLine();
                    System.out.println("Ingresa tu contraseña:");
                    Scanner contraseña = new Scanner(System.in);
                    String contraseña_usuario = contraseña.nextLine();

                    if (nombre_usuario.equals(nombre_registrado) && contraseña_usuario.equals(contraseña_registrada1)) {
                        System.out.println("Login Correcto." + "\n ¡Bienvenido " + nombre_usuario + "!\n");
                    } else {
                        System.out.println("Nombre de usuario o contraseña incorrectos.");
                    }

                    break;


                case 2:
                    System.out.println("========== Has seleccionado Registro ========== ");
                    System.out.println("Introduce tu nombre:");
                    Scanner escaner_nombre = new Scanner(System.in);
                    nombre_registrado = escaner_nombre.nextLine();
                    System.out.println("Introduce tu Apellido:");
                    Scanner escaner_apellido = new Scanner(System.in);
                    apellido_registrado = escaner_apellido.nextLine();
                    System.out.println("Introduce tu email:");
                    Scanner escaner_email = new Scanner(System.in);
                    email_registrado = escaner_email.nextLine();
                    System.out.println("Introduce tu DNI:");
                    Scanner escaner_dni = new Scanner(System.in);
                    dni_registrado = escaner_dni.nextLine();
                    System.out.println("Introduce tu Fecha de Nacimiento:");
                    Scanner escaner_fecha_nacimiento = new Scanner(System.in);
                    fecha_registrada = escaner_fecha_nacimiento.nextLine();
                    System.out.println("Introduce una Contraseña:");
                    Scanner escaner_contraseña1 = new Scanner(System.in);
                    contraseña_registrada1 = escaner_contraseña1.nextLine();
                    System.out.println("Repite la Contraseña:");
                    Scanner escaner_contraseña2 = new Scanner(System.in);
                    contraseña_registrada2 = escaner_contraseña2.nextLine();
                    System.out.println("Para tu seguridad se te va a hacer una pregunta a modo de recuperacion de contraseña:" +
                            " ¿Cual es tu color favorito?");
                    Scanner escaner_respuesta_seguridad = new Scanner(System.in);
                    respuesta_seguridad = escaner_respuesta_seguridad.nextLine();



                    break;
                case 3:
                    System.out.println("Has seleccionado Recuperacion de Contraseña");
                    break;
                case 4:
                    System.out.println("Has seleccionado Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 4);


    }
}
