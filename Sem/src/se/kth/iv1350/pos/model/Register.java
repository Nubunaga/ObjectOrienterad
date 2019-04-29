/*This class is used to update different external systems and also check what is in register as sale atm.
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;
// Associated classes are imported.
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.Printer;

public class Register {
    private ExternalAccountingSystem externalAccountingSystem;
    private Inventory inv;
    //constructor blank
    public Register(){

    }
    // constructor
    public Register(Inventory inv, ExternalAccountingSystem externalAccountingSystem){
        this.externalAccountingSystem = externalAccountingSystem;
        this.inv = inv;
    }
    // method to add the current sale.
    public Receipt addToRegister(TotalSaleDTO totalSale){
    updateExternalSystem(totalSale);
    return printReceipt(totalSale);
    }
    // get the accounting object.
    public ExternalAccountingSystem getExternalAccountingSystem() {
        return externalAccountingSystem;
    }

    private Receipt printReceipt(TotalSaleDTO totalSale){
        Receipt receipt = new Receipt(totalSale);
        Printer printer = new Printer(receipt);
        return printer.showChange(receipt);
    }

    private void updateExternalSystem(TotalSaleDTO totalSale){
        inv.updateInventory(totalSale);
        externalAccountingSystem.logSale(totalSale);
    }
}
