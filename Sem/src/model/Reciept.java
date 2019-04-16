package model;

public class Reciept {
    TotalSaleDTO totalSale;
    float change;
    Reciept(TotalSaleDTO totalSale){
        this.totalSale = totalSale;
        this.change = 0;
    }

    public TotalSaleDTO getTotalSale() {
        return totalSale;
    }

    public void setChange(float change) {
        this.change = change;
    }
    public String toString(){
        return ""+this.change;
    }
}
