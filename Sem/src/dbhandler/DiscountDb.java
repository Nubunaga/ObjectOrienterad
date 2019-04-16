package dbhandler;

public class DiscountDb {
    private String itemId;
    private int quantity ;
    private String costumerID;
    private float reduction;
    public DiscountDb() {
        this.itemId = "3536";
        this.quantity = 3;
        this.reduction = 0.3f;
        this.costumerID = "abba";
    }

    public String getCostumerID() {
        return costumerID;
    }
    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getReduction() {
        return reduction;
    }
}
