package ejercicios_excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivo {

    public static void ejecutarEjercicio() {
        System.out.println("\nEJERCICIO 3: LECTURA DE ARCHIVO");
        System.out.println("===================================");

        String nombreArchivo = "archivo_inexistente.txt"; // Archivo que no existe

        try {
            leerArchivo(nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.out.println("Solución: Verifique que el archivo exista y la ruta sea correcta");
        }
    }

    private static void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
        String linea;

        System.out.println("Contenido del archivo:");
        while ((linea = reader.readLine()) != null) {
            System.out.println("   " + linea);
        }

        reader.close();
    }
}
