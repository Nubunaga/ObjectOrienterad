/*The startup
* The startup sole role is to start all the object that the program need to operate correctly,
* thereby allowing classes access to the operations needed to start.
* @Author Netanel Avraham Eklind*/

package startUp;        // the package currently in

/************************************************/
/*Below follow the packages that are used by main*/
import controller.Controller;
import dbhandler.*;
import model.Register;
import view.View;
/************************************************/
public class Main {
    public static void main(String[] args){
        //create all object needed and then run the "fakeSale" operation.
        new DiscountDb();
        ExternalAccountingSystem exAccSys = new ExternalAccountingSystem();
        Inventory inv = new Inventory();
        Register reg = new Register(inv,exAccSys);
        Controller contr = new Controller(inv,reg);        //parameters inv,exAccSys used by controller and sub classes
        new Printer();
        // this operation goes to view to be ready to start fake sale with a "newSale"
        new View(contr).runFakeSale();
    }
}
