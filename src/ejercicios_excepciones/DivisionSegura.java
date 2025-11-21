package ejercicios_excepciones;

import java.util.Scanner;

public class DivisionSegura {

    public static void ejecutarEjercicio() {
        System.out.println("\nEJERCICIO 1: DIVISIÓN SEGURA");
        System.out.println("=================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese el dividendo: ");
            double dividendo = scanner.nextDouble();

            System.out.print("Ingrese el divisor: ");
            double divisor = scanner.nextDouble();

            double resultado = dividir(dividendo, divisor);
            System.out.printf("Resultado: %.2f / %.2f = %.2f\n", dividendo, divisor, resultado);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debe ingresar números válidos");
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por cero");
        } finally {
            System.out.println("Bloque finally ejecutado - Recursos liberados");
        }
    }

    private static double dividir(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        return dividendo / divisor;
    }
}
