/**The calculator class is used to calculate the different part of the program that those classes shall not handle,
this makes the program have better cohesion, making each class do a specific class.
* @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class Calculator {
    /**Constructor blank, for usage to access different part of the class.*/
    Calculator() {

    }
    /**Receives the current sale and calculate the total cost for this sale, is package private to be used only by sale..
    * @param  sale   is  an <code> ArrayList </code> received as the current sale log to get the item cost with its own Vat
    * rate.
    * @param discount is a data type by <code> float</code> that is used to change the price depending if there is a
    * discount applied to that specific item.
    * @return the running total for the entire sale after calculating <code> runningTotal </code>  */
    float runningTotal(ArrayList<ItemDTO> sale,float discount) {
        try {
            float runningTotal = 0;
            for (ItemDTO p : sale) {
                runningTotal += ((p.getPrice() * p.getQuantity()) * (1 + p.getVatRate()));
            }
            return runningTotal * discount;
        }
        catch (ArithmeticException e){
            return 0;
        }
    }
    /**This method is used to calculate the total cost for the entire current sale by getting <code>
     * totalCost = sale.getRunningTotal() </code>.
     * @param sale the current <code> SaleDTO sale </code> that contains all the items of this sale.
     * @return <code> sale.getRunningTotal() </code> as a float that is the total value. */
    float calculateTotalCost(SaleDTO sale){
        return sale.getRunningTotal();
    }

}
