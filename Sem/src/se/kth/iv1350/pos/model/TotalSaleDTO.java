/*This class is to be used as a end DTO and send all the information to the register for processing.
* @ Author Netanel Avraham Eklind */

//current package
package se.kth.iv1350.pos.model;

public class TotalSaleDTO {
   private SaleDTO sale;
   private float totalCost;
   private  CashPayment cashPayment;

  /*
  * Constructor for the total sale dto object is created.
  *
  * @param sale contains all the current sale information.
  *
  * @param totalCost contains the cost for the current sale.
  *
  * @param payment is the amount paid by the costumer.
  * */
  TotalSaleDTO(SaleDTO sale, float totalCost,CashPayment payment){
        this.sale = sale;
        this.totalCost = totalCost;
        this.cashPayment = payment;
    }

    /*
    * Get the payment of the object
    * @return <code> cashPayment </code>
    * */
    public CashPayment getCashPayment() {
        return cashPayment;
    }
    /*
    * Get the total cost of the program
    * @return totalCost
    * */
    public float getTotalCost() {
        return totalCost;
    }
    /*
    * Get the sale dto for the total sale
    * @return sale
    * */
    public SaleDTO getSale() {
        return sale;
    }
    /*
    * Overrides the current object print and thus correctly allows for a print.
    * */
    public String toString() {
        return "["+this.sale +" "+this.cashPayment+"}";
    }
}
