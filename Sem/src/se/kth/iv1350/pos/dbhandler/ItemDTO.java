/*This class is used to create a data transferable object "item" to be used in different part of the program.
* @ Author Netanel Avraham Eklind*/


package se.kth.iv1350.pos.dbhandler;

public class ItemDTO {
    private float price;
    private String name;
    private String itemID;
    private float vatRate;
    private int quantity;
    private String newLine = System.getProperty("line.separator");
// constructor
       public ItemDTO(float price, String name, String itemID,float vatRate, int quantity ){
        this.price = price;
        this.itemID = itemID;
        this.name = name;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }
    /*Overrides the original object print method and allows the object
    * to be printed correctly.*/
    public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("| Name: "+this.name));
            sb.append(String.format(", Price: %.2f",this.price)+":-, Quantity: ");
            sb.append(this.quantity+", Vat Rate :");
            sb.append(this.vatRate+"|"+newLine);
            return sb.toString();
    }
    // the bellow method are used to get different attributes of the object.
    public String getItemID(){
        return this.itemID;
    }
    public String getName() {
        return name;
    }
    public float getPrice(){
            return price;
    }
    public float getVatRate(){
            return vatRate;
    }
    public int getQuantity(){
            return quantity;
    }

    // the bellow method used to set different attributes of the object.
    public void setPrice(float price){
            this.price = price;
    }
}
