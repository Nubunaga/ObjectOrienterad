/**Creates the cash object for the payment system
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;

public class CashPayment {
    private float payment;
    public CashPayment(float payment){
        this.payment = payment;
    }

    /**
     * Get the payment attribute
     * @return payment    contains payment of this object*/
    public float getPayment() {
        return payment;
    }

    /**Used to overwrite and be able to print the object.
    * @return <code> ""+this.payment </code> as a string. */
    public String toString(){
        return ""+this.payment;
    }
}
