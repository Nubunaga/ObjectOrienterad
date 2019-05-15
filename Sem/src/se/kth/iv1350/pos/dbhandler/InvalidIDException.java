/**
 * <code>Exception</code> class that handles what happens if there is no valid itemID.
 * @Author Netanel Avraham Eklind
 */
package se.kth.iv1350.pos.dbhandler;

public class InvalidIDException extends java.lang.Exception {
    private String noItemFound;

    /**
     * Creates a  instance that says that the provided ID is not foind
     * @param itemID                                a <code>String</code>
     *                                              with the id number.
     *
     * */
     InvalidIDException(String itemID){
        super("The Item Id: "+ itemID +" cannot be found");
       this.noItemFound = itemID;
    }
    /**
     * @return the given item ID
     * */
    public String getNoItemFound(){
        return this.noItemFound;
    }
}
