/**
 * An abstract class that is used to implement the mather pattern algorithm.
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.dbhandler;

import java.util.ArrayList;

public interface Matcher {
    /**
     * creates the template for the matcher algorithm to be used by a class that implement this.
     * @param sale                 contains all current <code>Items</code> in sale
     *
     * @throws InvalidIDException  is thrown if no item is found.
     * */
    float calculateWithID(ArrayList<ItemDTO> sale,String costumerID)throws InvalidIDException;

    float calculateWithoutID(ArrayList<ItemDTO>sale);
}
