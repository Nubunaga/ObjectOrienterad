/*This class is to be used as a end DTO and send all the information to the register for processing.
* @ Author Netanel Avraham Eklind */

package se.kth.iv1350.pos.model;

public class TotalSaleDTO {
   private SaleDTO sale;
   private float totalCost;
  private  CashPayment cashPayment;
  // constructor
  TotalSaleDTO(SaleDTO sale, float totalCost,CashPayment payment){
        this.sale = sale;
        this.totalCost = totalCost;
        this.cashPayment = payment;
    }
    // access the payment object
    public CashPayment getCashPayment() {
        return cashPayment;
    }
    // access the total cost value
    public float getTotalCost() {
        return totalCost;
    }
    // access the whole sale DTO object
    public SaleDTO getSale() {
        return sale;
    }
    // printable DTO object
    public String toString() {
        return "["+this.sale +" "+this.cashPayment+"}";
    }
}
