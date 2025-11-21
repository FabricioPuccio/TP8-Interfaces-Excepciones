package ejercicios_excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {

    public static void ejecutarEjercicio() {
        System.out.println("\nEJERCICIO 5: TRY-WITH-RESOURCES");
        System.out.println("===================================");

        // Ruta del archivo
        String nombreArchivo = "resources/datos_ejemplo.txt";

        System.out.println("Leyendo archivo: " + nombreArchivo);
        System.out.println("-----------------------------------");

        // Try-with-resources - LOS RECURSOS SE CIERRAN AUTOMÁTICAMENTE
        try (FileReader fileReader = new FileReader(nombreArchivo);
             BufferedReader reader = new BufferedReader(fileReader)) {

            String linea;
            int numeroLinea = 1;

            while ((linea = reader.readLine()) != null) {
                System.out.println("Línea " + numeroLinea + ": " + linea);
                numeroLinea++;
            }

            System.out.println("Archivo leído exitosamente");
            System.out.println("Recursos cerrados automáticamente por try-with-resources");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.out.println("Verifique que el archivo exista en: " + nombreArchivo);
        }
    }
}