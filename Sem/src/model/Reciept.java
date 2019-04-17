package model;

public class Reciept {
    TotalSaleDTO totalSale;
    float change;
    private String newLine = System.getProperty("line.separator");
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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Total cost: %.2f :-",this.totalSale.getTotalCost())+newLine);
        sb.append(String.format(" Payment: %.2f :-",this.totalSale.getCashPayment().getPayemtn())+newLine);
        sb.append(String.format(" Change: %.2f :-",this.change));
        return sb.toString();
    }
}