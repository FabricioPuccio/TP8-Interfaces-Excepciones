package ejercicios_excepciones;


import ejercicios_excepciones.excepciones.EdadInvalidaException;
import java.util.Scanner;

public class ValidacionEdad {

    public static void ejecutarEjercicio() {
        System.out.println("\nEJERCICIO 4: EXCEPCIÓN PERSONALIZADA - VALIDACIÓN DE EDAD");
        System.out.println("=============================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese su edad: ");
            int edad = scanner.nextInt();

            validarEdad(edad);
            System.out.println("Edad válida: " + edad + " años");

        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número entero válido");
        }
    }

    private static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0) {
            throw new EdadInvalidaException("La edad no puede ser negativa: " + edad);
        } else if (edad > 120) {
            throw new EdadInvalidaException("La edad no puede ser mayor a 120 años: " + edad);
        } else if (edad < 18) {
            throw new EdadInvalidaException("Edad insuficiente para realizar la operación: " + edad);
        }
    }
}
