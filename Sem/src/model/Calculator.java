package model;

import dbhandler.ItemDTO;

import java.util.ArrayList;

public class Calculator {
    Calculator() {

    }

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
    float calculateTotalCost(SaleDTO sale){
        float totalCost = sale.getRunningTotal();
        return totalCost;
    }

}
