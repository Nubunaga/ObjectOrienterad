/*External system handler that updates the accounting system with recent purchases
* @ Author: Netanel Avraham Eklind */


package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.TotalSaleDTO;

public class ExternalAccountingSystem {
    float registerMoney;
    /*Constructor*/
    public ExternalAccountingSystem(){

    }

    /*Log the Sale of the previous sale (cash)*/
    public void logSale(TotalSaleDTO totalSale){
        registerMoney = (totalSale.getTotalCost()- totalSale.getCashPayment().getPayemtn());
    }
    /*Get the amount in account*/
    public float getRegisterMoney() {
        return registerMoney;
    }
}
