package se.kth.iv1350.pos.dbhandler;
// inventoryList.add(new ItemDTO(23.50f,"Milk","3536", 0.12f,10));
public class Item {
    private float price;
    private String name;
    private String itemID;
    private float vatRate;
    private int quantity;
    public Item(float price,String name,String itemId,float vat,int quantity){
        this.price = price;
        this.name = name;
        this.itemID = itemId;
        this.vatRate = vat;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getItemID() {
        return itemID;
    }

    public float getPrice() {
        return price;
    }

    public float getVatRate() {
        return vatRate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[ "+this.name));
        sb.append(String.format(", %.2f",this.price));
        sb.append(":- , "+this.itemID + ", "+this.quantity+ ", "+this.vatRate+" ]");
        return sb.toString();
    }
}
