/**This class is used to transport information to sale with different discount rules that are acquired from discount db
* @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.dbhandler;
// import packages associated with this class
import se.kth.iv1350.pos.database.DiscountDb;

import java.util.ArrayList;

public class DiscountRule{

    private DiscountDb discountDb;
    private String strategy;

    /**
    *Constructor for the <code> DiscountRule </code> object
    **/
    public DiscountRule() {
        this.discountDb = DiscountDb.getInstance();
    }
    /**
    * The method is used to chose a strategy and then call the right algorithm for the discount.
    *
    * @param sale, is a <code> ArrayList </code> that contains the
    *  current sale.
    *
    * @param costumerId, is a string of the costumers id that is used to check for the costumer in the data base.
    *
    * @return if a new discount is checked at <code>  if ( discountRunningTotal(logs,costumerId) ) </code>
    * discount returns a float that is used to calculate new runningTotal thus calculating total cost.
    **/


    public float calculateDiscount(ArrayList<ItemDTO> sale, String costumerId) {
        try {
            this.strategy = costumerId;
            if(discountStrategy()) {
                return new WithCorrectID().calculateDiscount(sale,this.discountDb);
            }
            else{
                return new WithoutCorrectID().calculateDiscount(sale,this.discountDb);
            }

        } catch (ConnectionFailureException e) {
            System.out.println("Lost connection to Discount Db");
        }
        return 0;
    }
    /**
    * This method is used to check for discount rule,costumer id and then chose the
     * correct strategy.
    *
    * @return true if <code> costumerId.equals( discountDb.getCostumerID() </code>
     * is true.
    * */
    private boolean discountStrategy(){
        return  this.strategy.equals( discountDb.getCostumerID());
    }

    /**
    * This method is used to get the discount database object from discount rule.
    *
    * @return <code> discountDb </code>.
    * */
     DiscountDb getDiscountDb() {
        return discountDb;
    }
}
