/*This class is used to create the receipt that the costumer will receive containing: Items, Total cost, and Payment
* with change.
* @ Author Netanel Avraham Eklind */
package model;

public class Reciept {
    TotalSaleDTO totalSale;
    float change;
    private String newLine = System.getProperty("line.separator"); // get the OS new line operation
    // constructor
    Reciept(TotalSaleDTO totalSale){
        this.totalSale = totalSale;
        this.change = 0;
    }
    // get the DTO of total sale and can be used.
    public TotalSaleDTO getTotalSale() {
        return totalSale;
    }
    // sets a new change value
    public void setChange(float change) {
        this.change = change;
    }
    //printable object
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Items:"+ newLine));
        sb.append(String.format(""+this.totalSale.getSale().getItem())+newLine);
        sb.append(String.format("Total cost: %.2f :-",this.totalSale.getTotalCost())+newLine);
        sb.append(String.format(" Payment: %.2f :-",this.totalSale.getCashPayment().getPayemtn())+newLine);
        sb.append(String.format(" Change: %.2f :-",this.change));
        return sb.toString();
    }
}