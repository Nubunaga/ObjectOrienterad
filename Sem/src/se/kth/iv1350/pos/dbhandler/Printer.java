/*This class is used to "print" and return change to the user of the program.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.dbhandler;
// import classes associated with this class.
import se.kth.iv1350.pos.model.Receipt;

public class Printer {
    Receipt reciept;
    // constructor, blank
    public Printer(){

    }
    //constructor, with Receipt class
    public Printer(Receipt reciept){
        this.reciept = reciept;
    }
    // calculate and return the change to the user.
    public Receipt showChange(Receipt reciept){
        reciept.setChange(reciept.getTotalSale().getTotalCost() - reciept.getTotalSale().getCashPayment().getPayment());
       return reciept;
    }
}
