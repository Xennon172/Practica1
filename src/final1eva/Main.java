package final1eva;
import java.util.Scanner;

public class Main {

    // Variables globales, se declaran estáticas para que otros métodos o clases puedan acceder a ellas.

    static String usuario_registrado, nombre_registrado, apellido_registrado, email_registrado,
            dni_registrado, fecha_registrada, contrasena_registrada1,
            contrasena_registrada2, respuesta_seguridad1, respuesta_seguridad2;

    static boolean bloqueado = false;

    public static boolean captcha_valido = false;

    public static void main(String[] args) {
        menu();
        fecha_valida();
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
            System.out.println("     3. Recuperación de Contraseña"   );
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

        } while (!seleccion.equals("4"));
    }

    public static void login() {
        Scanner datos = new Scanner(System.in);


        if (nombre_registrado == null || contrasena_registrada1 == null) {
            System.out.println("\f No hay usuario registrado. Regístrate primero." + "\n\f Escoge la Opción 2");
            return;
        }

        int intentos_login = 0;
        boolean logincorrecto = false;
        // Utilizar Do-While en los menus

        do {
            System.out.println("=====================================");
            System.out.println("=               LOGIN               =");
            System.out.println("=====================================");

            System.out.println("Ingresa tu nombre de usuario:");
            String usuario = datos.nextLine();

            System.out.println("Ingresa tu contraseña:");
            String contrasena_usuario = datos.nextLine();

            captcha_valido = captcha();

            if (usuario.equals(usuario_registrado) && contrasena_usuario.equals(contrasena_registrada1) && captcha_valido) {
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
                // elimina los datos del captcha
                captcha_valido = false;
            } else {
                if (!captcha_valido) {
                    System.out.println("ERROR. El captcha no es correcto.");
                    intentos_login = 3;
                } else {
                    intentos_login++;
                    System.out.println("ERROR. Usuario o contraseña incorrectos.\n" +
                            "(Asegurate que los datos sean correctos antes de introducilos).\n" +
                            "¡Intento " + intentos_login + " de 3!");
                }

            }
        } while (intentos_login < 3 && !logincorrecto);

        if (!logincorrecto) {
            System.out.println("\t HAS FALLADO 3 VECES, ¿DE VERDAD?...." + "\n\t A LA PUTA CALLE BOT.");
            bloqueado = true;
            recuperacion();
        }
    }

    public static void registro() {

        comprobar_bloqueo();
        boolean registro_correcto = false;
        do {
            System.out.println("=====================================");
            System.out.println("=             REGISTRO              =");
            System.out.println("=====================================");
            System.out.println("Introduce tu USUARIO:");
            Scanner escaner_usuario = new Scanner(System.in);
            usuario_registrado = escaner_usuario.nextLine();
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
            do {
                System.out.println("Introduce una Contraseña:");
                Scanner escaner_contrasena1 = new Scanner(System.in);
                contrasena_registrada1 = escaner_contrasena1.nextLine();
                System.out.println("Repite la Contraseña:");
                Scanner escaner_contrasena2 = new Scanner(System.in);
                contrasena_registrada2 = escaner_contrasena2.nextLine();

                if (!contrasena_registrada1.equals(contrasena_registrada2)) {
                    System.out.println("Las contraseñas no coinciden.");
                }

            } while (!contrasena_registrada1.equals(contrasena_registrada2));

            System.out.println("\t=== Para tu seguridad se te va a hacer una pregunta a modo de recuperacion de contraseña ===\n" +
                    "\t                               ¿CUAL ES TU COLOR FAVORITO?\n");
            Scanner escaner_respuesta_seguridad = new Scanner(System.in);
            respuesta_seguridad1 = escaner_respuesta_seguridad.nextLine();

            captcha_valido = captcha();

            if (captcha_valido) {
                registro_correcto = true;
            }

        } while (!registro_correcto);

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

    public static boolean captcha() {
        int intentos_captcha = 0;
        do {
            int captcha_generado = 1000 + (int) (Math.random() * 9000);
            System.out.println("Introduce el número generado:\n" + captcha_generado);
            Scanner scanner_captcha = new Scanner(System.in);
            String captcha_usuario = scanner_captcha.nextLine();
            if (captcha_usuario.equals(String.valueOf(captcha_generado))) {
                captcha_valido = true;
            } else {
                System.out.println("Captcha incorrecto");
                intentos_captcha++;
            }

        } while (!captcha_valido || intentos_captcha > 3);

        if (captcha_valido) {
            return true;
        }
        return false;
    }


    public static boolean validar_usuario(String usuario) {
        if (usuario.length() < 8) {
            return false;
        }

        boolean char_valido = true;
        for (int i = 0; i < usuario.length(); i++) {
            char c = usuario.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') &&
                    !(c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                            c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                            c == 'ñ' || c == 'Ñ' || c == 'ü' || c == 'ç')) {
                char_valido = false;
            }
        }
        if (char_valido) {
            return true;
        }
        return false;
    }


    public static boolean validar_email(String email) {
        return true;
    }

    public static boolean validar_dni(String dni) {
        return true;
    }

    public static boolean validar_conntrasena(String contrasena) {
        if (contrasena.length() < 8) {
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                tieneMayuscula = true;
            } else if (c >= 'a' && c <= 'z') {
                tieneMinuscula = true;
            } else if (c >= '0' && c <= '9') {
                tieneNumero = true;
            } else {
                tieneEspecial = true;
            }

            if (tieneMayuscula && tieneMinuscula && tieneNumero && tieneEspecial) {
                return true;
            }

        }
        return false;
    }

    public static void fecha_valida() {
        Scanner entrada_fecha = new Scanner(System.in);
        int dia, mes, ano;
        String diaStr, mesStr, anoStr;
        boolean validar_fecha = false;
        boolean validador;
        boolean menor_edad = false;

        do {
            System.out.println("Introduce tu fecha de nacimiento:");
            validador = false;
            do {
                System.out.print("Introduce el dia : ");
                diaStr = entrada_fecha.nextLine();
                for (int i = 0; i < diaStr.length(); i++) {
                    char c = diaStr.charAt(i);
                    if (c >= '0' && c <= '9') {
                        validador = true;
                    } else {
                        System.out.println("Error, introduce un valor correcto");
                        validador = false;
                    }
                }
            } while (!validador);
            dia = Integer.parseInt(diaStr);
            validador = false;

            do {
                System.out.print("Introduce el mes: ");
                mesStr = entrada_fecha.nextLine();
                for (int i = 0; i < mesStr.length(); i++) {
                    char c = mesStr.charAt(i);

                    if (c >= '0' && c <= '9') {
                        validador = true;
                    } else {
                        System.out.println("Error, introduce un valor correcto");
                        validador = false;
                    }
                }
            } while (!validador);
            mes = Integer.parseInt(mesStr);
            validador = false;
            do {
                System.out.print("Introduce el año: ");
                anoStr = entrada_fecha.nextLine();
                for (int i = 0; i < mesStr.length(); i++) {
                    char c = mesStr.charAt(i);

                    if (c >= '0' && c <= '9') {
                        validador = true;
                    } else {
                        System.out.println("Error, introduce un valor correcto");
                        validador = false;
                    }
                }
            } while (!validador);
            ano = Integer.parseInt(anoStr);
            validador = mes >= 1 && mes <= 12;
            int dias_mes = 0;
            if (validador) {
                switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12 :
                        dias_mes = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        dias_mes = 30;
                        break;
                    case 2:
                        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                            dias_mes = 29;
                        } else {
                            dias_mes = 28;
                        }
                        break;
                    default:
                        System.out.println("Error");
                        break;

                }

                if (dia < 1 || dia > dias_mes) {
                    validador = false;
                }
            }
            if (ano > 2006 || (ano == 2006 && mes > 11) || (ano == 2006 && mes == 11 && dia > 0)) {
                System.out.println("Eres menor de edad. No puedes registrarte");
                menor_edad = true;
                validador = false;
            }
            if (validador && !menor_edad) {
                validar_fecha = true;
                System.out.println("Fecha valida");
            } else {
                System.out.println("La fecha no es válida.");
            }
        } while (!validar_fecha);
    }
}