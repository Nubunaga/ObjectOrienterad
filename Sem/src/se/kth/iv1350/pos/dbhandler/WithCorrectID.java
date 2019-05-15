package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.database.DiscountDb;

import java.util.ArrayList;

public class WithCorrectID implements Matcher {
    private DiscountDb discountDb;
    public WithCorrectID(){
    }

    @Override
    public float calculateDiscount(ArrayList<ItemDTO> sale, DiscountDb discountDb) {
        float discount = 1;
        this.discountDb = discountDb;
        for (ItemDTO check : sale) {
            if ( discountItemID(check) ) {
                discount -= 0.04;
            }
            if ( discountQuantity(check) ){

                discount -= .04f;
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

    /**
     * This method is used to check for discount rules item id and item quantity.
     *
     * @param check contains current <code> ItemDTO </code> in the array list.
     *
     * @return true if and only if both <code> check.getItemID().equals( discountDb.getItemId() </code>
     * and <code> check.getQuantity() == this.discountDb.getQuantity() </code> is correct.
     * */
    private boolean discountQuantity (ItemDTO check){
        return ( check.getItemID().equals( discountDb.getItemId() ) && check.getQuantity() == this.discountDb.getQuantity() );
    }
}
