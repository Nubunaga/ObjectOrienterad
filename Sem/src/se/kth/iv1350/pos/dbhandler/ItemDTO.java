/**This class is used to create a data transferable object "item" to be used in different part of the program.
* @ Author Netanel Avraham Eklind*/


package se.kth.iv1350.pos.dbhandler;

public class ItemDTO {
    private float price;
    private String name;
    private String itemID;
    private float vatRate;
    private int quantity;
    private String newLine = System.getProperty("line.separator");
    /**The constructor for the <code> object </code> item dto .
    * @param price is the cost of item.
    * @param name is the name of the item.
    * @param itemID contains the item id.
    * @param vatRate is the vat rate for the item.
    * @param quantity is the amount that is bought.*/
       public ItemDTO(float price, String name, String itemID,float vatRate, int quantity ){
        this.price = price;
        this.itemID = itemID;
        this.name = name;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }
    /**Overrides the original object print method and allows the object
    * to be printed correctly.*/
    public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("| Name: "+this.name));
            sb.append(String.format(", Price: %.2f",this.price)+":-, Quantity: ");
            sb.append(this.quantity+", Vat Rate :");
            sb.append(this.vatRate+"|"+newLine);
            return sb.toString();
    }
    /**The method <code> getItemID() </code> is used to acquire item id of the object.
     * @return itemID  id for the itemDTO*/
    public String getItemID(){
        return this.itemID;
    }
    /**The methode <code> getName() </code> is used to get the name.
     * @return name    name for the item*/
    public String getName() {
        return name;
    }
    /** The method <code> getPrice()</code> is used to get the price of the item
     * @return price    cost of item*/
    public float getPrice(){
            return price;
    }
    /**The method <code> getVatRate </code> is used to get the var rate of the item.
     * @return vatRate*/
    public float getVatRate(){
            return vatRate;
    }

    /**
     * the method <code> getQuantity </code> is used to get quantity
     * @return quantity     contains the quantity of the item bought
     */
    public int getQuantity(){
            return quantity;
    }
}
