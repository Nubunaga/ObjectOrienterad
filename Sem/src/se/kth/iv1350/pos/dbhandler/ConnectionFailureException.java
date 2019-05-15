/**
 * A class used to throw an <code>Exception</code> each time connection is lost to a server, extends
 * <code>RuntimeException</code>
 *
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.dbhandler;

public class ConnectionFailureException extends java.lang.RuntimeException {
    /**
     * Uses the constructor in the super class to implement the new message.
     * */
    public ConnectionFailureException(){
        super("There is no connection to database");
    }
}
