/**
 * This class <code>implements</code> <code>DiscountCalculator</code> and is used when
 * the strategy "with costumer id" is not chosen..
 * @Author Netanel Avraham Eklind
 * */
package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.database.DiscountDb;

import java.util.ArrayList;

public class WithoutCorrectID implements DiscountCalculator {
    private DiscountDb discountDb;
    @Override
    /**
     * The implemented method from <code>DiscountCalculator</code> that calculates the discount
     * with the costumer id rules not applied.
     * @param sale          contains all the <code>ItemDTO</code> for the current
     *                      sale
     * @param discountDb    is the object with the discount rules.
     *
     * @return discount containing the float value to be calculated with.
     * */
    public float calculateDiscount(ArrayList<ItemDTO> sale, DiscountDb discountDb) {
        float discount = 1;
        this.discountDb = discountDb;
        for (ItemDTO check : sale) {
            if ( discountItemID(check) ) {
                discount -= 0.02;
            }
        }
        return discount;
    }
    /**
     * This method is used to check the item id for discount rule, item id.
     *
     * @param check contains the current <code> ItemDTO </code> in the array list
     * and checks the item id for a match.
     *
     * @return true if a match is found
     * */
    private boolean discountItemID(ItemDTO check){
        return check.getItemID().equals( this.discountDb.getItemId() );
    }
}
