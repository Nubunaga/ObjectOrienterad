/*This class is used to update different external systems and also check what is in register as sale atm.
* @ Author Netanel Avraham Eklind*/
package model;
// Associated classes are imported.
import dbhandler.ExternalAccountingSystem;
import dbhandler.Inventory;
import dbhandler.Printer;

public class Register {
    private ExternalAccountingSystem exas;
    private Inventory inv;
    //constructor blank
    public Register(){

    }
    // constructor
    public Register(Inventory inv, ExternalAccountingSystem exas){
        this.exas = exas;
        this.inv = inv;
    }
    // method to add the current sale.
    public Reciept addToRegister(TotalSaleDTO totalSale){
    inv.uppdateInvetory(totalSale);
    exas.logSale(totalSale);
    Reciept reciept = new Reciept(totalSale);
    Printer printer = new Printer(reciept);
    Reciept change  = printer.showChange(reciept);
    return change;
    }
    // get the accounting object.
    public ExternalAccountingSystem getExas() {
        return exas;
    }
}
