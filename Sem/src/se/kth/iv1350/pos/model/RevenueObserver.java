/**
 * A listener <code>Interface</code> class that is implemented in an observer pattern
 *
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.model;

public interface RevenueObserver {

    /**
     * Creates the template for the class that want to use the observer interface .
     * */
    void newRevenue(TotalSaleDTO totalSaleDTO);
}
