package Practica;

    import java.util.Scanner;

public class Main {

        // Variables globales, se declaran estáticas para que otros métodos o clases puedan acceder a ellas.

        static String usuario, nombre_registrado, apellido_registrado, email_registrado,
                dni_registrado, fecha_registrada, contrasena_registrada1,
                contrasena_registrada2, respuesta_seguridad1, respuesta_seguridad2;

        static boolean bloqueado = false;

        public static boolean captcha_valido1 = false;

        public static void main(String[] args) {
            // TODO code application logic here
            menu();
        }

        public static void menu() {
            Scanner entrada = new Scanner(System.in);
            String seleccion;

            do {
                System.out.println("=====================================");
                System.out.println("=          MENÚ DE INICIO           =");
                System.out.println("=====================================");
                System.out.println("     1. Login");
                System.out.println("     2. Registro");
                System.out.println("     3. Recuperación de Contraseña");
                System.out.println("     4. Salir");
                System.out.println("=====================================");
                System.out.print("\n\tSelecciona una opción: ");

                seleccion = entrada.nextLine().trim();

                switch (seleccion) {
                    case "1":
                        login();
                        break;
                    case "2":
                        registro();
                        break;
                    case "3":
                        recuperacion();
                        break;
                    case "4":
                        System.out.println("=====================================");
                        System.out.println("=            ADIOSITO               =");
                        System.out.println("=====================================");

                        break;
                    default:
                        System.out.println("Opcion no valida. Selecciona del 1 al 4.");
                }

            } while (!seleccion.equals("4")) ;
        }

        public static void login () {

            int captcha_generado = generar_captcha();
            System.out.println(captcha_generado);
            Scanner scanner_captcha = new Scanner(System.in);
            String captcha_usuario = scanner_captcha.nextLine();
            validar_captcha(captcha_generado, captcha_usuario);
            comprobar_bloqueo();

            if (nombre_registrado == null || contrasena_registrada1 == null) {
                System.out.println("\f No hay usuario registrado. Regístrate primero." + "\n\f Escoge la Opción 2");
                return;
            }

            int intentos_login = 0;
            boolean logincorrecto = false;

            while (intentos_login < 3 && !logincorrecto) {
                System.out.println("=====================================");
                System.out.println("=               LOGIN               =");
                System.out.println("=====================================");
                System.out.println("Ingresa tu nombre de usuario:");
                Scanner nombre = new Scanner(System.in);
                String usuario = nombre.nextLine();
                System.out.println("Ingresa tu contraseña:");
                Scanner contrasena = new Scanner(System.in);
                String contrasena_usuario = contrasena.nextLine();

                if (usuario.equals(Main.usuario) && contrasena_usuario.equals(contrasena_registrada1)) {
                    System.out.println("Login Correcto." + "\n ¡Bienvenido " + usuario + "!");
                    System.out.println("\t   **     **  ");
                    System.out.println("\t *****   *****");
                    System.out.println("\t *************");
                    System.out.println("\t  *********** ");
                    System.out.println("\t   *********  ");
                    System.out.println("\t    *******   ");
                    System.out.println("\t     *****    ");
                    System.out.println("\t      ***     ");
                    System.out.println("\t       *      ");
                    logincorrecto = true;
                } else {
                    intentos_login++;
                    System.out.println("ERROR. Usuario o contraseña incorrectos.\n" +
                            "(Asegurate que los datos sean correctos antes de introducilos).\n" +
                            "¡Intento " + intentos_login + " de 3!");
                }
            }
            if (!logincorrecto) {
                System.out.println("\n\t HAS FALLADO 3 VECES, ¿DE VERDAD?...." + "\n\t A LA PUTA CALLE BOT.");
                bloqueado = true;
                recuperacion();
            }
        }

        public static void registro(){
            comprobar_bloqueo();
            System.out.println("=====================================");
            System.out.println("=             REGISTRO              =");
            System.out.println("=====================================");
            System.out.println("Introduce tu USUARIO:");
            Scanner escaner_usuario = new Scanner(System.in);
            usuario = escaner_usuario.nextLine();
            System.out.println("Introduce tu NOMBRE:");
            Scanner escaner_nombre = new Scanner(System.in);
            nombre_registrado = escaner_nombre.nextLine();
            System.out.println("Introduce tu APELLIDO:");
            Scanner escaner_apellido = new Scanner(System.in);
            apellido_registrado = escaner_apellido.nextLine();
            System.out.println("Introduce tu EMAIL:");
            Scanner escaner_email = new Scanner(System.in);
            email_registrado = escaner_email.nextLine();
            System.out.println("Introduce tu DNI:");
            Scanner escaner_dni = new Scanner(System.in);
            dni_registrado = escaner_dni.nextLine();
            System.out.println("Introduce tu FECHA DE NACIMIENTO:");
            Scanner escaner_fecha_nacimiento = new Scanner(System.in);
            fecha_registrada = escaner_fecha_nacimiento.nextLine();
            //Vamos a proceder a comparar la contraseña un maximo de 3 veces.
            int intentos = 0;
            boolean registrado = false;

            while (intentos < 3 && !registrado) {
                System.out.println("Introduce una Contraseña:");
                Scanner escaner_contrasena1 = new Scanner(System.in);
                contrasena_registrada1 = escaner_contrasena1.nextLine();
                System.out.println("Repite la Contraseña:");
                Scanner escaner_contrasena2 = new Scanner(System.in);
                contrasena_registrada2 = escaner_contrasena2.nextLine();

                if (contrasena_registrada1.equals(contrasena_registrada2)) {
                    contrasena_registrada2 = contrasena_registrada1;
                    registrado = true;
                    System.out.println("Contraseña registrada con éxito.");
                } else {
                    intentos++;
                    System.out.println("Las contraseñas no coinciden. Intento " + intentos + " de 3.");
                }
            }

            if (!registrado) {
                System.out.println("\n\t HAS FALLADO 3 VECES, ¿DE VERDAD?...." + "\n\t A LA PUTA CALLE BOT.");
                return;
            }


            System.out.println("\t=== Para tu seguridad se te va a hacer una pregunta a modo de recuperacion de contraseña ===\n" +
                    "\t                               ¿CUAL ES TU COLOR FAVORITO?\n");
            Scanner escaner_respuesta_seguridad = new Scanner(System.in);
            respuesta_seguridad1 = escaner_respuesta_seguridad.nextLine();

        }

        public static void recuperacion() {
            if (nombre_registrado == null || contrasena_registrada1 == null) {
                System.out.println("\t ¡¡ME LO QUERIAS REVENTAR EEEHHH, LISTO!!.\n" + " \t Anda... Regístrate Primero.\n" + "\t Pulsa el numero 2 de tu teclado.");
                return;
            }
            System.out.println("=====================================");
            System.out.println("     RECUPERACIÓN DE CONTRASEÑA      ");
            System.out.println("=====================================");
            System.out.println("  Pregunta de Seguridad: " + "\t ¿Cual es tu color favorito?\n ");
            Scanner escaner_respuesta_seguridad2 = new Scanner(System.in);
            respuesta_seguridad2 = escaner_respuesta_seguridad2.nextLine();
            if (respuesta_seguridad1.equals(respuesta_seguridad2)) {
                System.out.println("Login Correcto." + "\t¡Bienvenido " + nombre_registrado + "!\n");
                bloqueado = false;
            } else {
                System.out.println("\t******* RESPUESTA INCORRECTA ******.");
            }
        }

        public static void comprobar_bloqueo() {
            if (bloqueado) {
                System.out.println("Usuario bloqueado");
                recuperacion();
            }
        }

        public static int generar_captcha() {
            return 1000 + (int) (Math.random() * 9000);
        }

        public static void validar_captcha (int captcha_generado, String captcha_usuario) {
            if (!captcha_usuario.equals(String.valueOf(captcha_generado))) {
                System.out.println("Captcha incorrecto");
            }
        }

        public static void captcha2(){
            Scanner sc = new Scanner(System.in);
            long num1 = (Math.round(Math.random() * 10));
            long num2 = (Math.round(Math.random() * 10));
            long resultado = num1 + num2;
            String resultado2 = resultado +"";
            String respuesta;
            do{
                System.out.printf("Dime la respuesta a la siguiente operacion: "+ num1 +" + " + num2);
                respuesta = sc.nextLine();
                if(respuesta.equalsIgnoreCase(resultado2)){
                    captcha_valido1 = true;
                }else{
                    System.out.printf("Error intentalo de nvo");
                    captcha_valido1 = false;
                }
            }while (!captcha_valido1);

        }

    }
