package dbhandler;

import model.TotalSaleDTO;

public class ExternalAccountingSystem {
    public ExternalAccountingSystem(){

    }
    public void logSale(TotalSaleDTO totalSale){
        float registerMoeny = (totalSale.getTotalCost()- totalSale.getCashPayment().getPayemtn());
    }
}
