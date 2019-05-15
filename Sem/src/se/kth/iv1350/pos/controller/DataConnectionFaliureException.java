/**
 * A lower abstraction class for the user does not have access to a big log of text, thus making sure only a
 * message is sent back to them.
 * @Author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.controller;

public class DataConnectionFaliureException extends java.lang.RuntimeException {
    public DataConnectionFaliureException(){
        super("Lost connection to server, try again");
    }
}
