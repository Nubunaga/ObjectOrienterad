/**This class is used to update different external systems and also check what is in register as sale atm.
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;
// Associated classes are imported.
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.Printer;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private ExternalAccountingSystem externalAccountingSystem;
    private Inventory inv;
    private List<RevenueObserver> revenueObserverList = new ArrayList<>();
    /**A blank constructor that can be used to access the methods in this class.*/
    public Register(){

    }
    /**A constructor that creates the object register witch contains <code>this.externalAccountingSystem </code> and
     * <code>this.inv </code>
     * @param inventory   contain the inventory object.
     * @param externalAccountingSystem contains the externalAccountingSystem object*/
    public Register(Inventory inventory, ExternalAccountingSystem externalAccountingSystem){
        this.externalAccountingSystem = externalAccountingSystem;
        this.inv = inventory;
    }
    /**
     * This method updates <code>updateExternalSystem(totalSale) </code> and creates a receipt
     * @param totalSale   contains all sale information and payment received
     * @return an object by <code> Receipt </code> that contain all the information in <code> totalSale </code>*/
    public Receipt addToRegister(TotalSaleDTO totalSale){
    updateExternalSystem(totalSale);
    return printReceipt(totalSale);
    }
    /**
     * Gets the externalAccountingSystem from the object <code> {@link Register} </code>
     * @return externalAccountingSystem*/
    public ExternalAccountingSystem getExternalAccountingSystem() {
        return externalAccountingSystem;
    }

    private Receipt printReceipt(TotalSaleDTO totalSale){
        Receipt receipt = new Receipt(totalSale);
        Printer printer = new Printer(receipt);
        notifyObserver(totalSale);
        return printer.showChange(receipt);
    }

    private void updateExternalSystem(TotalSaleDTO totalSale){
        inv.updateInventory(totalSale);
        externalAccountingSystem.logSale(totalSale);
    }

    private void notifyObserver(TotalSaleDTO totalSaleDTO){
        revenueObserverList.get(0).newRevenue(totalSaleDTO);
    }
    /**
     * Takes a whole list of <code>{@link RevenueObserver}</code> and register them one by one
     *
     * @param revObs                        contain all the current <code>{@link RevenueObserver}</code>
     * */
    public void addObservers(List<RevenueObserver> revObs){
        for (RevenueObserver rev : revObs){
            addRevenueObserver(rev);
        }
    }

    private void addRevenueObserver(RevenueObserver revenueObserver){
        revenueObserverList.add(revenueObserver);
    }
}
