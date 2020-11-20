package auxiliarStructures;

public class GreaterKeyException extends Exception {

    public GreaterKeyException(){
        super("El nuevo valor es más grande que el actual.");
    }

}