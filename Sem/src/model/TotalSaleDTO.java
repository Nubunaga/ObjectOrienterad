package model;

public class TotalSaleDTO {
   private SaleDTO sale;
   private float totalCost;
  private  CashPayment cashPayment;
  TotalSaleDTO(SaleDTO sale, float totalCost,CashPayment payment){
        this.sale = sale;
        this.totalCost = totalCost;
        this.cashPayment = payment;
    }

    public CashPayment getCashPayment() {
        return cashPayment;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public SaleDTO getSale() {
        return sale;
    }

    public String toString() {
        return "["+this.sale +" "+this.cashPayment+"}";
    }
}
