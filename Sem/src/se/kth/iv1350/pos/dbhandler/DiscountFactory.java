package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.database.DiscountDb;

public class DiscountFactory {
    private String strategy;
    public DiscountFactory(DiscountDb db){
        this.strategy = db.getCostumerID();
    }

    DiscountCalculator choseStrategy(String costumerID){
        if (this.strategy.equals(costumerID)){
            return new WithCorrectID();
        }
        else{
            return new WithoutCorrectID();
        }
    }
}
