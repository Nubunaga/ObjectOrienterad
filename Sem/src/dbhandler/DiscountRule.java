/*This class is used to transport information to sale with different discount rules that are acquired from discount db
* @ Author Netanel Avraham Eklind */
package dbhandler;
// import packages associated with this class
import model.SaleDTO;
import test.DiscountDb;
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
                if (check.getItemID() == this.discountDb.getItemId()) {     // check rule 1: ItemID
                    check.setPrice(check.getPrice() * 0.77f);
                }
                if (check.getItemID().equals(discountDb.getItemId()) && check.getQuantity() == this.discountDb.getQuantity()) { // check rule 2: Quantity and ID
                    check.setPrice(check.getPrice() * 0.9f);
                }
            }
                if (logs.getRunningTotal() == discountDb.getReduction() || costumerId.equals(discountDb.getCostumerID())) { // check rule 3: Costumer ID or just total cost reduction
                    discount = 0.7f;
                    return discount;
                }
                if (logs.getRunningTotal() == discountDb.getReduction() && costumerId.equals(discountDb.getCostumerID())) { // check rule 3: both costumer id and total cost.
                    discount = 0.5f;
                    return discount;
                }
            // catch if contact is lost.
        } catch (Exception e) {
            System.out.println("Lost connection to Discount Db");
        }
        return 0;
    }
}
