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
    //constructor, with Receipt class
    public Printer(Receipt receipt){
        this.receipt = receipt;
    }
    // calculate and return the change to the user.
    public Receipt showChange(Receipt receipt){
        receipt.setChange(receipt.getTotalSale().getTotalCost() - receipt.getTotalSale().getCashPayment().getPayment());
       return receipt;
    }
}
