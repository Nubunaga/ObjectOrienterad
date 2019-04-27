/*This class is used to update different external systems and also check what is in register as sale atm.
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;
// Associated classes are imported.
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.Printer;

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
    updateExternalSystem(totalSale);
    return printReceipt(totalSale);
    }
    // get the accounting object.
    public ExternalAccountingSystem getExas() {
        return exas;
    }

    private Reciept printReceipt(TotalSaleDTO totalSale){
        Reciept reciept = new Reciept(totalSale);
        Printer printer = new Printer(reciept);
        Reciept change  = printer.showChange(reciept);
        return change;
    }

    private void updateExternalSystem(TotalSaleDTO totalSale){
        inv.updateInventory(totalSale);
        exas.logSale(totalSale);
    }
}
