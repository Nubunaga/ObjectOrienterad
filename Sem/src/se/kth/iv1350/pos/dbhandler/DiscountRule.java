/**This class is used to transport information to sale with different discount rules that are acquired from discount db
* @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.dbhandler;
// import packages associated with this class
import se.kth.iv1350.pos.model.SaleDTO;
import se.kth.iv1350.pos.database.DiscountDb;
import java.util.ArrayList;

public class DiscountRule {

    private DiscountDb discountDb;

    /**
    *Constructor for the <code> DiscountRule </code> object
    **/
    public DiscountRule() {
        this.discountDb = new DiscountDb();

    }
    /**
    * The method <code> calculateDiscount </code> calculates a new price following different discount rules provided by
    * a external database.
    *
    * @param sale, is a <code> ArrayList<ItemDTO> </code> that contains the
    *  current sale.
    *
    * @param logs, is a log of all the sale in the current sale that is used
    * to calculate the running total discount rule.
    *
    * @param costumerId, is a string of the costumers id that is used to check for the costumer in the data base.
    *
    * @return if a new discount is checked at <code>  if ( discountRunningTotal(logs,costumerId) ) </code>
    * discount returns a float that is used to calculate new runningTotal thus calculating total cost.
    **/
    public float calculateDiscount(ArrayList<ItemDTO> sale, SaleDTO logs, String costumerId) {
        try {
            float discount = 1;
            for (ItemDTO check : sale) {
                if ( discountItemID(check) ) {
                discount -= 0.01;
                }
                if ( discountQuantity(check) ){

                    discount -= .02f;
                }
            }
                if ( discountRunningTotal(logs,costumerId) ) {
                    discount -= 0.3f;
                    return discount;
                }
        } catch (Exception e) {
            System.out.println("Lost connection to Discount Db");
        }
        return 0;
    }

    /**
    * This method is used to check the item id for discount rule, item id.
    *
    * @param check contains the current <code> ItemDTO </code> in the array list
    * and checks the item id for a match.
    *
    * @return true if a match is found
    * */
    private boolean discountItemID(ItemDTO check){
        return check.getItemID().equals( this.discountDb.getItemId() );
    }

    /**
    * This method is used to check for discount rules item id and item quantity.
    *
    * @param check contains current <code> ItemDTO </code> in the array list.
    *
    * @return true if and only if both <code> check.getItemID().equals( discountDb.getItemId() </code>
    * and <code> check.getQuantity() == this.discountDb.getQuantity() </code> is correct.
    * */
    private boolean discountQuantity (ItemDTO check){
        return ( check.getItemID().equals( discountDb.getItemId() ) && check.getQuantity() == this.discountDb.getQuantity() );
    }
    /**
    * This method is used to check for discount rule, running total and costumer id.
    *
    * @param logs contains the current sale log with all <code> ItemDTO </code> that is in the sale.
    *
    * @param costumerId is a <code> String </code> of the costumer id.
    *
    * @return true if either <code> logs.getRunningTotal() == discountDb.getReduction() </code> or
    * <code> costumerId.equals( discountDb.getCostumerID() </code> is true.
    * */
    private boolean discountRunningTotal(SaleDTO logs,String costumerId){
        return ( logs.getRunningTotal() == discountDb.getReduction() || costumerId.equals( discountDb.getCostumerID() ));
    }

    /**
    * This method is used to get the discount database object from discount rule.
    *
    * @return <code> discountDb </code>.
    * */
    public DiscountDb getDiscountDb() {
        return discountDb;
    }
}
