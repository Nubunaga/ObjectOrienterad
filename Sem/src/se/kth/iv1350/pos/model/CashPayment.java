/*Creates the cash object for the payment system
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;

public class CashPayment {
    float payemtn;
    public CashPayment(float payement){
        this.payemtn = payement;
    }
    // get the payment primitive data
    public float getPayemtn() {
        return payemtn;
    }
    //Print object
    public String toString(){
        return ""+this.payemtn;
    }
}
