package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.database.DiscountDb;

import java.util.ArrayList;

public class WithoutCorrectID implements Matcher {
    private DiscountDb discountDb;
    @Override
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
