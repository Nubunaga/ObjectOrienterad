/*This class is used to transport information to sale with different discount rules that are acquired from discount db
* @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.dbhandler;
// import packages associated with this class
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.databasetest.DiscountDb;
import java.util.ArrayList;

public class DiscountRule {
    private DiscountDb discountDb;

    // constructor
    public DiscountRule() {
        this.discountDb = new DiscountDb();

    }
    // Method to give new values and calculation for the sale after the discount has been added
    public float calculateDiscount(ArrayList<ItemDTO> sale, SaleDTO logs, String costumerId) {
        // in the event of lost contact to "Db" a try/ catch is implemented
        try {
            float discount;
            for (ItemDTO check : sale) {
                if ( discountItemID(check) ) {     // check rule 1: ItemID
                    check.setPrice(check.getPrice() * 0.77f);
                }
                if ( discountQuantity(check) ){ // check rule 2: Quantity and ID

                    check.setPrice(check.getPrice() * 0.9f);
                }
            }
                if ( discountRunningTotal(logs,costumerId) ) { // check rule 3: Costumer ID or just total cost reduction
                    discount = 0.4f;
                    return discount;
                }
            // catch if contact is lost.
        } catch (Exception e) {
            System.out.println("Lost connection to Discount Db");
        }
        return 0;
    }

    private boolean discountItemID(ItemDTO check){
        return check.getItemID().equals( this.discountDb.getItemId() );
    }
    private boolean discountQuantity (ItemDTO check){
        return ( check.getItemID().equals( discountDb.getItemId() ) && check.getQuantity() == this.discountDb.getQuantity() );
    }
    private boolean discountRunningTotal(SaleDTO logs,String costumerId){
        return ( logs.getRunningTotal() == discountDb.getReduction() || costumerId.equals( discountDb.getCostumerID() ));
    }
}
