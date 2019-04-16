package model;

public class TotalSaleDTO {
    SaleDTO sale;
    float totalCost;
    CashPayment cashPayment;
    public TotalSaleDTO(SaleDTO sale, float totalCost,CashPayment payment){
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
        String s = "["+this.sale +" "+this.totalCost+" "+this.cashPayment+"}";
        return s;
    }
}
