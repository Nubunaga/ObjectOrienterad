/*This class is used to "print" and return change to the user of the program.
* @ Author Netanel Avraham Eklind*/

package dbhandler;
// import classes associated with this class.
import model.Reciept;

public class Printer {
    Reciept reciept;
    // constructor, blank
    public Printer(){

    }
    //constructor, with Receipt class
    public Printer(Reciept reciept){
        this.reciept = reciept;
    }
    // calculate and return the change to the user.
    public Reciept showChange(Reciept reciept){
        reciept.setChange(reciept.getTotalSale().getTotalCost() - reciept.getTotalSale().getCashPayment().getPayemtn());
       return reciept;
    }
}
