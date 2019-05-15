/**
 * An abstract class that is used to implement the mather pattern algorithm.
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.database.DiscountDb;

import java.util.ArrayList;

public interface Matcher {

    /**
     * creates the template for the matcher algorithm to be used by a class that implement this.
     * @param sale                 contains all current <code>Items</code> in sale
     * @param discountDb            contains the object of the discount database
     *
     * @throws InvalidIDException  is thrown if no item is found.
     * */
    float calculateDiscount(ArrayList<ItemDTO> sale, DiscountDb discountDb)throws InvalidIDException;

}
