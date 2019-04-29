/*Creates the cash object for the payment system
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;

public class CashPayment {
    float payment;
    public CashPayment(float payment){
        this.payment = payment;
    }

    // get the payment primitive data
    public float getPayment() {
        return payment;
    }

    /*Used to overwrite and be able to print the object.
    * @return <code> ""+this.payment </code> as a string. */
    public String toString(){
        return ""+this.payment;
    }
}
