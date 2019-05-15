/**External system handler that updates the accounting system with recent purchases
 * this is a singleton made class.
* @ Author: Netanel Avraham Eklind */


package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.TotalSaleDTO;

public class ExternalAccountingSystem {
    private float registerMoney;
    private static ExternalAccountingSystem single_instance = null;
    /**
    * Constructor for the object <Code> ExternalAccountingSystem </code> that contains
    * an amount of current register amount
    * */
    private ExternalAccountingSystem(){
    this.registerMoney = 15000;
    }
    /**
     * This method gets one instance of the class <code>{@link ExternalAccountingSystem}</code>
     *
     * @return an single object instance of <code> {@link ExternalAccountingSystem}</code>
     * */
    public static ExternalAccountingSystem getInstance(){
        if(single_instance == null){
            single_instance = new ExternalAccountingSystem();
        }
        return single_instance;
    }
    /**
    * Placeholder update to an external accounting system that updates with recent sale.
    *
    * @param  totalSale  contains the entire sale for the current sale including;
    * payment and total cost.
    * */
    public void logSale(TotalSaleDTO totalSale){
        registerMoney += totalSale.getTotalCost();
    }
    /**
    * Get the amount in account.
    *
    * @return  the amount as a <code> float </code>.
    * */
    public float getRegisterMoney() {
        return registerMoney;
    }
}
