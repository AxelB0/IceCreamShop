package be.intecbrussel.sellers;

public class NoMoreIceCreamException extends Exception {
    public NoMoreIceCreamException(){
        this("Hey man, we're out.");
    }

    public NoMoreIceCreamException(String message){
        super(message);
    }


}
