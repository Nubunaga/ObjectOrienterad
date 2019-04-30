/*External system handler that updates the accounting system with recent purchases
* @ Author: Netanel Avraham Eklind */


package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.TotalSaleDTO;

public class ExternalAccountingSystem {
    float registerMoney;
    /*
    * Constructor for the object <Code> ExternalAccountingSystem </code> that contains
    * an amount of current register amount
    * */
    public ExternalAccountingSystem(){
    this.registerMoney = 15000;
    }

    /*
    * Placeholder update to an external accounting system that updates with recent sale.
    *
    * @param <code> totalSale </code> contains the entire sale for the current sale including;
    * payment and total cost.
    * */
    public void logSale(TotalSaleDTO totalSale){
        registerMoney += totalSale.getTotalCost();
    }
    /*
    * Get the amount in account.
    *
    * @return  the amount as a <code> float </code>.
    * */
    public float getRegisterMoney() {
        return registerMoney;
    }
}
