/**
 * This class is used to test the <code> {@link se.kth.iv1350.pos.dbhandler.DiscountRule }</code> class
 * for any unwanted events
 * @author Netanel Avraham Eklind
 * */
package se.kth.iv1350.pos.dbhandler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.model.Sale;

import java.util.ArrayList;

public class DiscountRuleTest {
    DiscountRule discountRule;
    ArrayList<ItemDTO> salelog;
    Sale sale;

    @Before
    public void setUp() throws Exception {
        discountRule = new DiscountRule();
        salelog = new ArrayList<>();
        sale = new Sale();
    }

    @After
    public void tearDown() throws Exception {
        discountRule = null;
        sale = null;
        salelog = null;
    }

    @Test
    /**Check DiscountRule 1, ItemId*/
    public void testDiscount1(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,3);
        discountRule.calculateDiscount(salelog,"abba");
        Assert.assertTrue("Same id",discountRule.getDiscountDb().getItemId().equals(item.getItemID()));
    }

    @Test
    /**Check DiscountRule 2, ItemId and quantity*/
    public void testDiscount2(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,3);
        discountRule.calculateDiscount(salelog,"abba");
        Assert.assertTrue("Same id",discountRule.getDiscountDb().getItemId().equals(item.getItemID())
        && discountRule.getDiscountDb().getQuantity() == item.getQuantity());
    }
    @Test
    /**Check DiscountRule 3, CostumerId*/
    public void testDiscount3(){
        boolean instance = (1 >= discountRule.calculateDiscount(salelog,"abba")
        )?true:false;
        Assert.assertTrue("there have been a discount",instance);
    }
    @Test
    /**Check DiscountRule 3, costumerIDFail*/
    public void testDiscount4(){
        float discount = 1;
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,3);
        discount = discountRule.calculateDiscount(salelog,"sara");
        boolean instance = (1 >= discount)?false:true;
        Assert.assertFalse("There has not been a discount",instance);
    }

}