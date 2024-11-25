package final1eva;

import java.util.Scanner;

public class Main {

    // Variables globales, se declaran estáticas para que otros métodos o clases puedan acceder a ellas.
    static String usuario_registrado, nombre_registrado, apellido_registrado, email_registrado,
            dni_registrado, fecha_registrada, contrasena_registrada1, respuesta_seguridad;

    static boolean bloqueado = false;
    static boolean registrado = false;

    public static void main(String[] args) {
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
            System.out.println("     4. Desbloqueo de usuario");
            System.out.println("     5. Salir");
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
                    recuperacion(true);
                    break;
                case "4":
                    recuperacion(false);
                    break;
                case "5":
                    System.out.println("=====================================");
                    System.out.println("=            ADIOSITO               =");
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("Opcion no valida. Selecciona del 1 al 5.");
            }

        } while (!seleccion.equals("5"));
        System.exit(0);
    }

    public static void login() {
        Scanner entrada = new Scanner(System.in);
        String seleccion;
        int captcha_generado;
        String captcha_usuario;
        int intentos_captcha = 0;
        int intentos_login = 0;
        boolean login_correcto = false;

        if (!registrado) {
            System.out.println("No hay usuarios registrados");

            do {
                System.out.println("=====================================");
                System.out.println("=       Selecciona una opción       =");
                System.out.println("=====================================");
                System.out.println("     1. ¿Ir a registro?");
                System.out.println("     2. Volver a menú");
                System.out.println("=====================================");
                System.out.print("\n\tSelecciona una opción: ");

                seleccion = entrada.nextLine().trim();

                switch (seleccion) {
                    case "1":
                        registro();
                        break;
                    case "2":
                        menu();
                        break;
                    default:
                        System.out.println("Opcion no valida. Selecciona del 1 al 2.");
                }

            } while (!registrado);
        }
        comprobar_bloqueo();
        do {
            System.out.println("=====================================");
            System.out.println("=               LOGIN               =");
            System.out.println("=====================================");
            System.out.println("Ingresa tu nombre de usuario:");
            Scanner nombre = new Scanner(System.in);
            String usuario = nombre.nextLine();
            System.out.println("Ingresa tu contraseña:");
            Scanner contrasena = new Scanner(System.in);
            String contrasena_usuario = contrasena.nextLine().trim();

            do {
                captcha_generado = generar_captcha();
                System.out.println("CAPTCHA: " + captcha_generado);
                System.out.println("Inserta el captcha:");
                Scanner escaner_captcha = new Scanner(System.in);
                captcha_usuario = escaner_captcha.nextLine().trim();

                if (!validar_captcha(captcha_generado, captcha_usuario)) {
                    System.out.println("Captcha incorrecto");
                    intentos_captcha++;
                } else {
                    registrado = true;
                }

                if (intentos_captcha == 3) {
                    System.out.println("\n\t Has fallado 3 veces completando el captcha, ¿eres un bot?.\n USUARIO BLOQUEADO");
                    bloqueado = true;
                    menu();
                }

            } while (!validar_captcha(captcha_generado, captcha_usuario));

            if (usuario.equalsIgnoreCase(usuario_registrado) && contrasena_usuario.equals(contrasena_registrada1)) {
                System.out.println("Login Correcto." + "\n ¡Bienvenido " + usuario + "!");
                System.out.println("\t    **     **  ");
                System.out.println("\t  *****   *****");
                System.out.println("\t  *************");
                System.out.println("\t   *********** ");
                System.out.println("\t    *********  ");
                System.out.println("\t     *******   ");
                System.out.println("\t      *****    ");
                System.out.println("\t       ***     ");
                System.out.println("\t        *      ");
                login_correcto = true;
            } else {
                intentos_login++;
                System.out.println("ERROR. Usuario o contraseña incorrectos.\n"
                        + "(Asegurate que los datos sean correctos antes de introducilos)");
            }

        } while (intentos_login < 3 && !login_correcto);

        if (!login_correcto) {
            System.out.println("\n\t HAS FALLADO 3 VECES, ¿DE VERDAD?...\n USUARIO BLOQUEADO");
            bloqueado = true;
            menu();
        }
    }

    public static void registro() {
        comprobar_bloqueo();
        int captcha_generado;
        String captcha_usuario;
        int intentos = 0;

        System.out.println("=====================================");
        System.out.println("=             REGISTRO              =");
        System.out.println("=====================================");

        do {
            System.out.println("Introduce tu USUARIO (mínimo 5 caracteres):");
            Scanner escaner_usuario = new Scanner(System.in);
            usuario_registrado = escaner_usuario.nextLine();
            if (!(usuario_registrado.length() >= 5)) {
                System.out.println("El nombre de usuario debe tener 5 de caracteres");
            }
        } while (!validar_nombre(usuario_registrado) || !(usuario_registrado.length() >= 5));

        do {
            System.out.println("Introduce tu NOMBRE:");
            Scanner escaner_nombre = new Scanner(System.in);
            nombre_registrado = escaner_nombre.nextLine();
        } while (!validar_nombre(nombre_registrado));

        do {
            System.out.println("Introduce tu APELLIDO:");
            Scanner escaner_apellido = new Scanner(System.in);
            apellido_registrado = escaner_apellido.nextLine();
        } while (!validar_nombre(apellido_registrado));

        do {
            System.out.println("Introduce tu EMAIL:");
            Scanner escaner_email = new Scanner(System.in);
            email_registrado = escaner_email.nextLine();
        } while (!validar_email(email_registrado));

        do {
            System.out.println("Introduce tu DNI:");
            Scanner escaner_dni = new Scanner(System.in);
            dni_registrado = escaner_dni.nextLine().toUpperCase();
        } while (!validar_dni(dni_registrado));

        boolean fecha_valida;
        do {
            fecha_valida = registrar_fecha();
        } while (!fecha_valida);

        registrar_contrasena();

        boolean color_validado = false;

        do {
            System.out.println("\t=== Para tu seguridad se te va a hacer una pregunta a modo de recuperacion de contraseña ===\n"
                    + "\t                               ¿CUAL ES TU COLOR FAVORITO?\n");
            Scanner escaner_respuesta_seguridad = new Scanner(System.in);
            respuesta_seguridad = escaner_respuesta_seguridad.nextLine();

            if (respuesta_seguridad.length() == 0) {
                System.out.println("Valor incorrecto,  el campo no debe estar vacío.");

            } else {
                for (int i = 0; i < respuesta_seguridad.length(); i++) {
                    if (!es_letra(respuesta_seguridad.charAt(i))) {
                        color_validado = false;
                        System.out.println("Valor incorrecto,  inserta solo letras.");
                        break;
                    }
                    color_validado = true;
                }
            }

        } while (!color_validado);

        do {
            captcha_generado = generar_captcha();
            System.out.println("CAPTCHA: " + captcha_generado);
            System.out.println("Inserta el captcha:");
            Scanner escaner_captcha = new Scanner(System.in);
            captcha_usuario = escaner_captcha.nextLine().trim();

            if (!validar_captcha(captcha_generado, captcha_usuario)) {
                System.out.println("Captcha incorrecto");
                intentos++;
            } else {
                System.out.println("USUARIO REGISTRADO!");
                registrado = true;
            }

            if (intentos == 3) {
                System.out.println("\n\t Has fallado 3 veces completando el captcha, eres un bot?.");
                break;
            }

        } while (!validar_captcha(captcha_generado, captcha_usuario));
    }

    public static void recuperacion(boolean recuperar_contrasena) {
        Scanner scanner = new Scanner(System.in);

        if (registrado && (bloqueado || recuperar_contrasena)) {

            System.out.println("=====================================");
            System.out.println("     COMPROBACIÓN DE SEGURIDAD       ");
            System.out.println("=====================================");

            System.out.print("Introduce nombre de usuario: ");
            String nombre_usuario = scanner.nextLine().trim();
            System.out.print("Pregunta de Seguridad: ¿Cuál es tu color favorito? ");
            String respuesta_usuario = scanner.nextLine().trim();


            if (respuesta_seguridad.equalsIgnoreCase(respuesta_usuario) && nombre_usuario.equalsIgnoreCase(usuario_registrado)) {
                System.out.println("\t******** RESPUESTA CORRECTA ********");

                if (bloqueado) {
                    bloqueado = false;
                }

                if (recuperar_contrasena) {
                    registrar_contrasena();
                }
            } else {
                System.out.println("\t******* RESPUESTA INCORRECTA ******.");
                menu();
            }
        } else {
            System.out.println("No hay usuarios registrados o bloqueados.");
        }
    }

    public static void registrar_contrasena() {
        String contrasena_registrada2;
        do {
            System.out.println("Introduce una Contraseña (con may, min, numero y caracter especial):");
            Scanner escaner_contrasena1 = new Scanner(System.in);
            contrasena_registrada1 = escaner_contrasena1.nextLine().trim();

            System.out.println("Repite la Contraseña:");
            Scanner escaner_contrasena2 = new Scanner(System.in);
            contrasena_registrada2 = escaner_contrasena2.nextLine().trim();

            if (!contrasena_registrada1.equals(contrasena_registrada2)) {
                System.out.println("Las contraseñas no coinciden. Intenta de nuevo.");
            }

            if (!validar_contrasena(contrasena_registrada1)) {
                System.out.println("Contraseña no válida.");
            }

        } while (!contrasena_registrada1.equals(contrasena_registrada2) || !validar_contrasena(contrasena_registrada1));
    }

    public static void comprobar_bloqueo() {
        if (bloqueado) {
            System.out.println("Usuario BLOQUEADO");
            recuperacion(false);
        }
    }

    // modificamos el valor a entero
    public static int generar_captcha() {
        return 1000 + (int) (Math.random() * 9000);
    }

    public static boolean validar_captcha(int captcha_generado, String captcha_usuario) {
        if (!captcha_usuario.equals(String.valueOf(captcha_generado))) {
            return false;
        }
        return true;
    }

    public static boolean validar_email(String email) {
        int arroba = email.indexOf('@');

        // si devuelve -1, no encuentra el caracter
        if (arroba == -1 || arroba == 0) {
            System.out.println("Email no válido");
            return false;
        }

        // Comprobamos que el punto este despues de la arroba
        int punto = email.indexOf('.', arroba);
        if (punto == -1) {
            System.out.println("Email no válido");
            return false;
        }

        int tamano = email.length();
        // comprobamos que el email termine en letra
        if (!es_letra(email.charAt(tamano - 1))) {
            System.out.println("Email no válido");
            return false;
        }
        return true;
    }

    public static boolean validar_contrasena(String contrasena) {
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
            } else if (es_numero(c)) {
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

    public static boolean validar_nombre(String nombre) {
        nombre = nombre.toLowerCase();

        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);

            // Si algún booleano es false
            if (!es_letra(letra) && !es_acento(letra) && letra != ' ') {
                System.out.println("Nombre no válido, debe contener solo letras");
                return false;
            }
        }
        return true;
    }

    public static boolean registrar_fecha() {
        Scanner entrada_fecha = new Scanner(System.in);
        int dia = 0, mes = 0, ano = 0;
        String dia_str, mes_str, ano_str;
        boolean validador = false;

        System.out.println("Introduce tu fecha de nacimiento:");

        do {
            System.out.print("Introduce el día: ");
            dia_str = entrada_fecha.nextLine();
            for (int i = 0; i < dia_str.length(); i++) {
                char letra = dia_str.charAt(i);
                if (!es_numero(letra)) {
                    validador = false;
                    System.out.println("Valor INCORRECTO,  inserta solo números.");
                    break;
                }
                validador = true;
            }
            if (validador) {
                dia = Integer.parseInt(dia_str);
            }
        } while (!validador);
        do {

            System.out.print("Introduce el mes: ");
            mes_str = entrada_fecha.nextLine();
            for (int i = 0; i < mes_str.length(); i++) {
                char letra = mes_str.charAt(i);
                if (!es_numero(letra)) {
                    validador = false;
                    System.out.println("Valor INCORRECTO,  inserta solo números.");
                    break;
                }
                validador = true;
            }
            if (validador) {
                mes = Integer.parseInt(mes_str);
            }
        } while (!validador);
        do {
            System.out.print("Introduce el año: ");
            ano_str = entrada_fecha.nextLine();
            for (int i = 0; i < ano_str.length(); i++) {
                char letra = ano_str.charAt(i);
                if (!es_numero(letra)) {
                    validador = false;
                    System.out.println("Valor INCORRECTO,  inserta solo números.");
                    break;
                }
                validador = true;
            }
            if (validador) {
                ano = Integer.parseInt(ano_str);
            }
        } while (!validador);

        // Validamos mes
        int dias_mes = 0;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
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
                System.out.println("La fecha NO es válida.");
                return false;
        }

        if (dia < 1 || dia > dias_mes) {
            System.out.println("La fecha NO es válida.");
            return false;
        }

        // Verificamos si es menor de edad
        if (ano > 2006 || (ano == 2006 && mes > 11)) {
            System.out.println("Eres MENOR de edad. No puedes registrarte");
            menu();
        }
        fecha_registrada = dia_str + "/" + mes_str + "/" + ano_str;
        System.out.println("Fecha " + fecha_registrada + " validada." );
        return true;
    }

    // recibe dni del usaurio
    public static boolean validar_dni(String dni) {

        if (dni.length() != 9) {
            System.out.println("Documento no válido");
            return false;
        }

        // Si es dni, empieza por numero
        if (es_numero(dni.charAt(0))) {
            return comprobar_dni(dni);
            // Si es nie, empieza por letra
        } else if (es_letra(dni.charAt(0))) {
            return comprobar_nie(dni);
        } else {
            System.out.println("Documento NO válido");
        }
        return false;
    }

    private static boolean comprobar_dni(String dni) {
        for (int i = 0; i < 8; i++) {
            if (!es_numero(dni.charAt(i))) {
                System.out.println("Documento NO válido");
                return false;
            }
        }
        return es_letra(dni.charAt(8));
    }

    private static boolean comprobar_nie(String nie) {
        for (int i = 1; i <= 7; i++) {
            if (!es_numero(nie.charAt(i))) {
                System.out.println("Documento NO válido");
                return false;
            }
        }
        return es_letra(nie.charAt(8));
    }

    private static boolean es_numero(char letra) {
        return letra >= '0' && letra <= '9';
    }

    // Cromprueba que el valor sea una letra
    private static boolean es_letra(char letra) {
        return (letra >= 'A' && letra <= 'Z') || (letra >= 'a' && letra <= 'z');
    }

    // Comprueba que el valor sea una letra acentuada
    private static boolean es_acento(char letra) {
        return letra == 'á' || letra == 'é' || letra == 'í' || letra == 'ó' || letra == 'ú' || letra == 'ç'
                || letra == 'Ç' || letra == 'Á' || letra == 'É' || letra == 'Í' || letra == 'Ó' || letra == 'Ú'
                || letra == 'ñ' || letra == 'Ñ' || letra == 'ü' || letra == 'Ü';
    }

}