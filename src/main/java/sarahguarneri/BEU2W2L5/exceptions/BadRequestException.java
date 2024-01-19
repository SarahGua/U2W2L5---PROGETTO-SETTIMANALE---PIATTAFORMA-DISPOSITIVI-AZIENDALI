package sarahguarneri.BEU2W2L5.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String messsage){
        super(messsage);
    }
}
