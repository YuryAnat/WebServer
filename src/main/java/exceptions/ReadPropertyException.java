package exceptions;

public class ReadPropertyException extends Throwable {
    public ReadPropertyException(String message){
        super(message);
    }
    public ReadPropertyException(String message, Exception e){
        super(message, e);
    }
}
