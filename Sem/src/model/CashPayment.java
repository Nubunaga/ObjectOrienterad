package model;

public class CashPayment {
    float payemtn;
    public CashPayment(float payement){
        this.payemtn = payement;
    }

    public float getPayemtn() {
        return payemtn;
    }
    public String toString(){
        return ""+this.payemtn;
    }
}
