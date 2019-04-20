/*This class is used to create a data transferable object "item" to be used in different part of the program.
* @ Author Netanel Avraham Eklind*/


package dbhandler;

public class ItemDTO {
    //declare the attributes.
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
    //To string to print the object.
    public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("|"+this.name));
            sb.append(String.format(",%.2f",this.price)+":-,");
            sb.append(this.quantity+",");
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price){
            this.price = price;
    }
}
