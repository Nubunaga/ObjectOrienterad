/*This class is used to create the object calculator and calculate total cost, running total
* @ Author Netanel Avraham Eklind */
package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class Calculator {
    //constructor
    Calculator() {

    }
    // calculate running total, package private
    float runningTotal(ArrayList<ItemDTO> sale,float discount) {
        try {
            float runningTotal = 0;
            for (ItemDTO p : sale) {
                runningTotal += ((p.getPrice() * p.getQuantity()) * (1 + p.getVatRate()));
            }
            return runningTotal;
        }
        catch (ArithmeticException e){
            return 0;
        }
    }
    //calculate total cost, package private
    float calculateTotalCost(SaleDTO sale){
        float totalCost = sale.getRunningTotal();
        return totalCost;
    }

}
