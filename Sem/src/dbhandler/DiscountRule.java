package dbhandler;

import model.SaleDTO;
import test.DiscountDb;

import java.util.ArrayList;

public class DiscountRule {
    private DiscountDb discountDb;


    public DiscountRule(){
        this.discountDb = new DiscountDb();

    }
    public float calculateDiscount(ArrayList<ItemDTO> sale,SaleDTO logs,String costumerId){
        float discount ;
        for(ItemDTO check : sale){
            if (check.getItemID()==this.discountDb.getItemId()){
                check.setPrice(check.getPrice()*0.77f);
            }
            if (check.getItemID().equals(discountDb.getItemId()) && check.getQuantity()== this.discountDb.getQuantity()){
                check.setPrice(check.getPrice()*0.9f);
            }
            if (logs.getRunningTotal() == discountDb.getReduction()|| costumerId.equals(discountDb.getCostumerID())){
                discount = 0.7f;
                return discount;
            }
            if (logs.getRunningTotal() == discountDb.getReduction() && costumerId.equals(discountDb.getCostumerID())){
                discount = 0.5f;
                return discount;
            }
        }
        return 0;
    }
}
