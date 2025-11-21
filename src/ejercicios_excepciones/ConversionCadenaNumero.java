package ejercicios_excepciones;

import java.util.Scanner;

public class ConversionCadenaNumero {

    public static void ejecutarEjercicio() {
        System.out.println("\nEJERCICIO 2: CONVERSIÓN DE CADENA A NÚMERO");
        System.out.println("==============================================");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        String entrada = scanner.nextLine();

        try {
            int numero = convertirAEntero(entrada);
            System.out.println("Número convertido: " + numero);
            System.out.println("El doble del número es: " + (numero * 2));

        } catch (NumberFormatException e) {
            System.out.println("Error: '" + entrada + "' no es un número entero válido");
            System.out.println("Mensaje técnico: " + e.getMessage());
        }
    }

    private static int convertirAEntero(String cadena) {
        return Integer.parseInt(cadena);
    }
}
