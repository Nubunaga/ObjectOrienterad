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
    public static void main(String[] args)throws Exception{
        /*Classes for the se.kth.iv1350.pos.database file be created here, These are made to se.kth.iv1350.pos.database the different part of the program.*/

        new DiscountDb();
        InventoryDb db = new InventoryDb();
        db.database();

        //create all object needed and then run the "fakeSale" operation.
        ExternalAccountingSystem exAccSys = new ExternalAccountingSystem();
        Inventory inv = new Inventory(db);
        Register reg = new Register(inv,exAccSys);
        Controller controller = new Controller(inv,reg);        //parameters inv,exAccSys used by se.kth.iv1350.pos.controller and sub classes
        new Printer();
                                                                // this operation goes to se.kth.iv1350.pos.view to be ready to start fake sale with a "newSale"
        new View(controller).runFakeSale();
    }
}
