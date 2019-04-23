/*Used to se.kth.iv1350.pos.databasetest the program with different uses for discounts.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.databasetest;

public class DiscountDb {
    private String itemId;
    private int quantity ;
    private String costumerID;
    private float reduction;
    // constructor
    public DiscountDb() {
        this.itemId = "3536";
        this.quantity = 3;
        this.reduction = 0.3f;
        this.costumerID = "abba";
    }
    // get the ID
    public String getCostumerID() {
        return costumerID;
    }
    // get the item
    public String getItemId() {
        return itemId;
    }
    // get the quantity
    public int getQuantity() {
        return quantity;
    }
    // get the reduction of total sale.
    public float getReduction() {
        return reduction;
    }
}
