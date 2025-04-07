import java.util.Scanner;

public class Esteganografia {

    public String descifraNulo(String original, int n) {
        String resultado = "";
        Scanner sc = new Scanner(original);
        while (sc.hasNext()) {
            String palabra = sc.next();
            if (n <= palabra.length()) {
                resultado += palabra.charAt(n - 1); // n es 1-indexado
            }
        }
        return resultado;
    }

    public String descifraNulo(String original) {
        int espacios = 0;
        for (int i = original.length() - 1; i >= 0 && original.charAt(i) == ' '; i--) {
            espacios++;
        }
        return descifraNulo(original.trim(), espacios);
    }

    public boolean contieneNombre(String mensaje, String nombre) {
        String limpio = mensaje.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String buscado = nombre.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return limpio.contains(buscado);
    }

    public String descifraPalabrasMarcadas(String m, String e) {
        Scanner scM = new Scanner(m);
        Scanner scE = new Scanner(e);
        String resultado = "";
        while (scM.hasNext() && scE.hasNext()) {
            String palabraM = scM.next();
            String palabraE = scE.next();
            if (!palabraM.equals(palabraE)) {
                resultado += palabraM + " ";
            }
        }
        return resultado.trim();
    }

    public String descifraLetrasMarcadas(String m, String e) {
        Scanner scM = new Scanner(m);
        Scanner scE = new Scanner(e);
        String resultado = "";
        while (scM.hasNext() && scE.hasNext()) {
            String palabraM = scM.next();
            String palabraE = scE.next();
            for (int i = 0; i < palabraM.length(); i++) {
                if (palabraM.charAt(i) != palabraE.charAt(i)) {
                    resultado += palabraM.charAt(i);
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Esteganografia estego = new Esteganografia();
        Scanner input = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. descifraNulo con n\n2. descifraNulo con espacios\n3. contieneNombre\n4. descifraPalabrasMarcadas\n5. descifraLetrasMarcadas");
        int opcion = Integer.parseInt(input.nextLine());

        switch (opcion) {
            case 1:
                System.out.println("Ingresa el texto:");
                String texto1 = input.nextLine();
                System.out.println("Ingresa el valor de n:");
                int n = Integer.parseInt(input.nextLine());
                System.out.println(estego.descifraNulo(texto1, n));
                break;
            case 2:
                System.out.println("Ingresa el texto con espacios al final:");
                String texto2 = input.nextLine();
                System.out.println(estego.descifraNulo(texto2));
                break;
            case 3:
                System.out.println("Ingresa el mensaje:");
                String mensaje = input.nextLine();
                System.out.println("Ingresa el nombre a buscar:");
                String nombre = input.nextLine();
                System.out.println(estego.contieneNombre(mensaje, nombre));
                break;
            case 4:
                System.out.println("Ingresa el mensaje M:");
                String m1 = input.nextLine();
                System.out.println("Ingresa el mensaje E:");
                String e1 = input.nextLine();
                System.out.println(estego.descifraPalabrasMarcadas(m1, e1));
                break;
            case 5:
                System.out.println("Ingresa el mensaje M:");
                String m2 = input.nextLine();
                System.out.println("Ingresa el mensaje E:");
                String e2 = input.nextLine();
                System.out.println(estego.descifraLetrasMarcadas(m2, e2));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
