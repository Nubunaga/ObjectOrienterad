/**Used to se.kth.iv1350.pos.database the program with different uses for discounts.
 *  this is a singleton made class.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.database;

public class DiscountDb {
    private String itemId;
    private int quantity ;
    private String costumerID;
    private float reduction;
    private static DiscountDb single_instance = null;
    /**Constructor for the discount database object.*/
    private DiscountDb() {
        this.itemId = "3536";
        this.quantity = 3;
        this.reduction = 0.3f;
        this.costumerID = "abba";
    }
    /**
     * This method gets the only instance made by this class.
     * @return object by <code>{@link DiscountDb}</code>
     * */
    public static DiscountDb getInstance(){
        if(single_instance == null){
            single_instance = new DiscountDb();
        }
        return single_instance;
    }
    /**
     * Gets the costumer id
     * @return costumerID   is the id in the database
     * */
    public String getCostumerID() {
        return costumerID;
    }
    /**
     * Gets the item id
     * @return itemID    contains the item id in database
     * */
    public String getItemId() {
        return itemId;
    }
    /**
     * get the quantity of the object
     * @return  quantity    contains the quantity of the rule
     * */
    public int getQuantity() {
        return quantity;
    }
    /**
     * gets the reduction check for the discount database
     * @return reduction    contain that specific rule
     * */
    public float getReduction() {
        return reduction;
    }
}
