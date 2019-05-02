/**This class is used to create the object <code> Receipt </code> that is used to by the program to
 *print the information about the current sale.
 * @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.model;

public class Receipt {
    private TotalSaleDTO totalSale;
    float change;
    private String newLine = System.getProperty("line.separator"); // get the OS new line operation

    /**Constructor for the object Receipt
    * @param totalSale contains all the information about the current sale after a end of add item is sent to <code>
    * model.Sale </code>.*/
    Receipt(TotalSaleDTO totalSale){
        this.totalSale = totalSale;
        this.change = 0;
    }

    /**Gets the total sale object from <code> Receipt </code> to be used by the program
    * @return totalSale with the sale information.*/
    public TotalSaleDTO getTotalSale() {
        return totalSale;
    }

    /**This method sets the current sale, change.
    * @param change is the difference between total cost and payment and is calculated in <code> printer.showChange
    * </code>.*/
    public void setChange(float change) {
        this.change = change;
    }
    /**Overwrites method in "object" thus making the object <code> Receipt </code> printable.*/
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("TestStore"+newLine));
        sb.append("Address Test street 23"+newLine);
        sb.append(String.format("Items:"+ newLine));
        sb.append(String.format(""+this.totalSale.getSale().getItem())+newLine);
        sb.append(String.format("Total cost: %.2f :-",this.totalSale.getTotalCost())+newLine);
        sb.append(String.format(" Payment: %.2f :-",this.totalSale.getCashPayment().getPayment())+newLine);
        sb.append(String.format(" Change: %.2f :-",this.change));
        return sb.toString();
    }
}