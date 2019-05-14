/**
 * The class that implements the observer interface and shows the total revenue for the place
 * of sale during the current session.
 *
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.RevenueObserver;
import se.kth.iv1350.pos.model.TotalSaleDTO;

import java.util.ArrayList;
import java.util.List;

public class TotalRevenueView implements RevenueObserver {
    private List<TotalSaleDTO> revenueOfSales = new ArrayList<>();


    /**Resets the <code>revenueOfSales</code> list.*/
    TotalRevenueView(){
        revenueOfSales.clear();
    }
    /**
     * Updates the list of current sales in session.
     *
     * @param totalSaleDTO                  contains the current
     *                                      sale after payment.
     * */
    public void newRevenue(TotalSaleDTO totalSaleDTO) {
        addNewSale(totalSaleDTO);
        printCurrentRevenue();
    }

    private void addNewSale(TotalSaleDTO totalSaleDTO){
        revenueOfSales.add(totalSaleDTO);
    }
    private void printCurrentRevenue(){
        float totalRevenue = 0;
        System.out.println("### We have now earned ###");
        for(TotalSaleDTO rev : revenueOfSales){
            totalRevenue += rev.getTotalCost();
        }
        System.out.println(String.format("%.2f",totalRevenue));
    }
}
