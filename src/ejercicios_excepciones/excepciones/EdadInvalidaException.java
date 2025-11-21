package ejercicios_excepciones.excepciones;

public class EdadInvalidaException extends Exception {

    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }

    public EdadInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
