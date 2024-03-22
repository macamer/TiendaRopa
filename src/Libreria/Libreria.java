package Libreria;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libreria {

    public static int dameIntEntreMen(int min, int max, String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = min - 1;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mens);
                num = Integer.parseInt(reader.readLine());
                correcto = true;
                if (num < min || num > max) {
                    correcto = false;
                    throw new ExceptionPropia("Debe ser un número entre " + min + " y " + max);
                }
            } catch (IOException ioe) {
                System.err.println("Se ha producido un error IOException");
            } catch (NumberFormatException e) {
                System.err.println("Se debe introducir un número entero");
            } catch (ExceptionPropia ne) {
                System.err.println(ne.getMessage());
            }
        }
        return num;
    }

    public static int pidePositivoInt(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean correcto = false;
        do {
            try {
                System.out.print(mens);
                num = Integer.parseInt(reader.readLine());
                correcto = true;
                if (num < 0) {
                    correcto = false;
                    throw new ExceptionPropia("No puede ser un número negativo");
                }
            } catch (IOException ioe) {
                System.err.println("Se ha producido un error IOException");
            } catch (NumberFormatException e) {
                System.err.println("Se debe introducir un número entero");
            } catch (ExceptionPropia ne) {
                System.err.println(ne.getMessage());
            }
        } while (!correcto);
        return num;
    }

    public static float pidePositivoFloatSin0(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float num = 0;
        boolean correcto = false;
        do {
            try {
                System.out.print(mens);
                num = Float.parseFloat(reader.readLine());
                correcto = true;
                if (num <= 0) {
                    correcto = false;
                    throw new ExceptionPropia("No puede ser un número negativo o 0");
                }
            } catch (IOException ioe) {
                System.err.println("Se ha producido un error IOException");
            } catch (NumberFormatException e) {
                System.err.println("Se debe introducir un número entero");
            } catch (ExceptionPropia ne) {
                System.err.println(ne.getMessage());
            }
        } while (!correcto);
        return num;
    }

    public static int pidePositivoIntSin0(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean correcto = false;
        do {
            try {
                System.out.print(mens);
                num = Integer.parseInt(reader.readLine());
                correcto = true;
                if (num <= 0) {
                    correcto = false;
                    throw new ExceptionPropia("No puede ser un número negativo o 0");
                }
            } catch (IOException ioe) {
                System.err.println("Se ha producido un error IOException");
            } catch (NumberFormatException e) {
                System.err.println("Se debe introducir un número entero");
            } catch (ExceptionPropia ne) {
                System.err.println(ne.getMessage());
            }
        } while (!correcto);
        return num;
    }

    public static float pidePositivoFloat(String mens) throws IOException, ExceptionPropia {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float num = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                System.out.print(mens);
                num = Float.parseFloat(reader.readLine());
                correcto = true;
                if (num < 0) {
                    correcto = false;
                    throw new ExceptionPropia("No puede ser un número negativo");
                }
            } catch (IOException ioe) {
                System.err.println("Se ha producido un error IOException");
            } catch (NumberFormatException e) {
                System.err.println("Se han introducido carácteres no numéricos");
            } catch (ExceptionPropia ne) {
                System.err.println(ne.getMessage());
            }
        }
        return num;
    }

    public static String pedirNombre(String texto) throws IOException {
        String nombre;
        boolean nom;

        do {
            nombre = pideStringNoVacio("Introduce el nombre: ");
            nom = nombre.matches("[a-zA-Z\\s]+");
            if (!nom) {
                System.out.println("Nombre no aceptado, pruebe de nuevo.");
            }
        } while (!nom);

        return nombre;
    }

    public static String pideStringNoVacio(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nom = null;
        boolean correcto = false;
        do {
            try {
                System.out.print(mens);
                nom = reader.readLine().trim();
                if (!nom.equalsIgnoreCase("")) {
                    correcto = true;
                } else {
                    throw new ExceptionPropia("Se debe introducir texto");
                }
            } catch (IOException ex) {
                System.err.println("Ha habido un error IOException");
            } catch (ExceptionPropia ep) {
                System.err.println(ep.getMessage());
            }
        } while (!correcto);
        return nom;
    }

    // Validar un si o no incluyendo una pregunta.
    public static boolean preguntaTrueFalse(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char resp = 'n';
        String input;
        boolean correcto = false;
        boolean esNoEs = false;
        do {
            System.out.print(mens);
            input = reader.readLine();
            if (!(input.trim().equals(""))) {
                resp = Character.toUpperCase(input.charAt(0));
                if (!(resp == 'S' || resp == 'N')) {
                    System.err.println("No le he entendido, debe ser Si o No.");
                } else {
                    correcto = true;
                }
            } else {
                System.err.println("****Debes introducir un valor****");
            }
        } while (!correcto);
        if (resp == 'S') {
            esNoEs = true;
        }
        return esNoEs;
    }

    public static String validaDni() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pat = Pattern.compile("^[0-9]{8}[A-Za-z]{1}$");
        Matcher mat = null;
        String dni = null;
        try {
            do {
                System.out.print("Introduce número de DNI: ");
                dni = reader.readLine();
                dni.toUpperCase();
                mat = pat.matcher(dni);
                if (!mat.matches()) {
                    System.err.println("Error: formato de DNI incorrecto");
                } else if (!comprobarNif(dni)) {
                    System.err.println("Error: Letra no válida");
                }
            } while (!mat.matches() || !comprobarNif(dni));
        } catch (IOException ex) {
            System.err.println("Ha habido un error de tipo IOException");
        }
        return dni;
    }

    public static boolean comprobarNif(String valorNif) {
        boolean val = false;
        int indice;
        long num;
        char letra;
        String letras;
        letras = "TRWAGMYFPDXBNJZSQVHLCKET";
        valorNif = valorNif.trim();
        num = Long.parseLong(valorNif.substring(0, (valorNif.length() - 1)));
        valorNif = valorNif.toUpperCase();
        letra = valorNif.charAt(valorNif.length() - 1);
        indice = (int) (num % 23);
        if (letra == letras.charAt(indice)) {
            val = true;
        }
        return val;
    }

    public static String validaCorreo() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String email = null;
        boolean correcto = false;
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        try {
            do {
                System.out.print("Introduce email: ");
                email = reader.readLine();
                Matcher mat = pat.matcher(email);
                if (mat.find()) {
                    correcto = true;
                } else {
                    System.err.println("Formato de correo no válido");
                }
            } while (!correcto);
        } catch (IOException ex) {
            System.err.println("Ha habido un error de tipo IOException");
        }
        return email;
    }

    public static LocalDate validaFecha(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalDate fecha = null, actual = LocalDate.now();
        boolean fechaValida = false;
        do {
            System.out.print(mens);
            String input = reader.readLine();
            try {
                fecha = LocalDate.parse(input);
                if (fecha.isBefore(actual) || fecha.isEqual(actual)) { // también se puede usar isAfter()
                    fechaValida = true; // Si es fecha anterior o actual, es válido
                } else {
                    System.err.println("No puede poner una fecha posterior a la actual");
                }
            } catch (DateTimeParseException e) {
                System.err
                        .println("Formato de fecha no válido. Por favor, introduce la fecha en el formato yyyy-mm-dd.");
            }
        } while (!fechaValida);
        return fecha;
    }

    public static String pideTelefono(String mens) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String telefono;
        boolean telefonoValido = false;

        do {
            System.out.print("Introduce un número de teléfono: ");
            telefono = reader.readLine();
            Pattern pat = Pattern.compile("^[9|6|7]{1}[\\d]{8}$");
            Matcher mat = pat.matcher(telefono);
            if (mat.matches()) {
                telefonoValido = true;
            } else {
                System.err.println("Número de teléfono no válido (empieza por 9,7 o 6, y 8 dígitos)");
            }
        } while (!telefonoValido);

        return telefono;
    }

}
