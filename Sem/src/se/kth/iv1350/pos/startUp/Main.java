/*The startup
* The startup sole role is to start all the object that the program need to operate correctly,
* thereby allowing classes access to the operations needed to start.
* @Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.startUp;        // the package currently in

/*Below follow the packages that are used by main*/
import se.kth.iv1350.pos.controller.*;
import se.kth.iv1350.pos.dbhandler.*;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.database.*;
import se.kth.iv1350.pos.view.*;

public class Main {
    /*The main method will startup different <code> constructors </code> that is crucial to the business program, thus
    * this method is only used to start the program then never again.  */
    public static void main(String[] args)throws Exception{

        new DiscountDb();
        InventoryDb db = new InventoryDb();
        db.database();
        ExternalAccountingSystem exAccSys = new ExternalAccountingSystem();
        Inventory inv = new Inventory(db);
        Register reg = new Register(inv,exAccSys);
        Controller controller = new Controller(inv,reg);
        new Printer();
        new View(controller).runFakeSale();
    }
}
