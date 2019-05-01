/*This class is used to "print" and return change to the user of the program.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.dbhandler;
// import classes associated with this class.
import se.kth.iv1350.pos.model.Receipt;

public class Printer {
    private Receipt receipt;
    // constructor, blank
    public Printer(){

    }
    /*Constructor that creates the object printer

    * @param receipt contains all the total sale DTO in one object. */
    public Printer(Receipt receipt){
        this.receipt = receipt;
    }
    /*This method calculates the change for the costumer.

    * @param receipt withs contains the total cost and payment.

    * @return the object receipt with the change and all of the information to be shown to the costumer,
    * */
    public Receipt showChange(Receipt receipt){
        receipt.setChange(receipt.getTotalSale().getTotalCost() - receipt.getTotalSale().getCashPayment().getPayment());
       return receipt;
    }
}
