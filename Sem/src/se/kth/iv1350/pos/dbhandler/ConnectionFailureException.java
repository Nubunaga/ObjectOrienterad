package se.kth.iv1350.pos.dbhandler;

public class ConnectionFailureException extends RuntimeException {
    public ConnectionFailureException(){
        super("There is no connection to database");
    }
}
