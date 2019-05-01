/*This class is used to create an instance of item to be filled in a "database" for checking and using in the program.
*
* @Author Netanel Avraham Eklind
* */

package se.kth.iv1350.pos.dbhandler;


public class Item {
    private float price;
    private String name;
    private String itemID;
    private float vatRate;
    private int quantity;

    /*
    * Constructor for the object <code> Item </code>
    * @param price is the cost of the item
    * @param name, name of the item
    * @param itemId is the id that the id has.
    * @param vat is the vat rate for the object
    * @param quantity is the amount of this specific item there is right now.
    *
    * */
    public Item(float price,String name,String itemId,float vat,int quantity){
        this.price = price;
        this.name = name;
        this.itemID = itemId;
        this.vatRate = vat;
        this.quantity = quantity;
    }
    /*
    * Get the name of the Item object
    * @return the name
    * */
    public String getName() {
        return name;
    }
    /*
    * Get the item id of the object
    * @return itemID
    * */
    public String getItemID() {
        return itemID;
    }
    /*
    * Get the price of the item
    * @return the price as float
    * */
    public float getPrice() {
        return price;
    }
    /*
    * Get the vat rate for the item.
    * @return the vat rate
    * */
    public float getVatRate() {
        return vatRate;
    }
    /*Get the quantity of the item
    * @return the quantity*/
    public int getQuantity() {
        return quantity;
    }
    /*set the quantity of the item
    * @param quantity is the new amount of item to
    * be set*/
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /*Overrides the original object print method and thus becomes capable of printing the object.*/
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[ "+this.name));
        sb.append(String.format(", %.2f",this.price));
        sb.append(":- , "+this.itemID + ", "+this.quantity+ ", "+this.vatRate+" ]");
        return sb.toString();
    }
}
