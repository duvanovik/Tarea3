package auxiliarStructures;

public class GreaterKeyException extends Exception {

    public GreaterKeyException(){
        super("El nuevo valor es m�s grande que el actual.");
    }

}