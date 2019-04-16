package dbhandler;

public class ItemDTO {
    private float price;
    private String name;
    private String itemID;
    private float vatRate;
    private int quantity;
    private String newLine = System.getProperty("line.separator");

        ItemDTO(float price, String name, String itemID,float vatRate, int quantity ){
        this.price = price;
        this.itemID = itemID;
        this.name = name;
        this.vatRate = vatRate;
        this.quantity = quantity;
    }
    public String toString(){
            String s ;
            s = "|"+this.name+","+this.price+":-,"+this.itemID+","+this.quantity+","+this.vatRate+"|"+newLine;
            return s;
    }

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price){
            this.price = price;
    }
}
