/*This class is used to create an instance of item to be filled in a "database" for checking and using in the program.
*
* @Author Netanel Avraham Eklind
* */

package se.kth.iv1350.pos.dbhandler;


public class Item {
    /*
    * Declare all the attributes associated with this class
    * */
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[ "+this.name));
        sb.append(String.format(", %.2f",this.price));
        sb.append(":- , "+this.itemID + ", "+this.quantity+ ", "+this.vatRate+" ]");
        return sb.toString();
    }
}
