/**Used to se.kth.iv1350.pos.database the program with different uses for discounts.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.database;

public class DiscountDb {
    private String itemId;
    private int quantity ;
    private String costumerID;
    private float reduction;
    /**Constructor for the discount database object.*/
    public DiscountDb() {
        this.itemId = "3536";
        this.quantity = 3;
        this.reduction = 0.3f;
        this.costumerID = "abba";
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
     * @retun quantity    contains the quantity of the rule
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
