/**
 * Used to test the <code> {@link se.kth.iv1350.pos.dbhandler.Inventory}</code> for unwanted events.
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.dbhandler;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.model.CashPayment;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.TotalSaleDTO;

public class InventoryTest {
    Inventory inventory;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory(InventoryDb.getInstance());
        inventory.getInventoryDb();
    }

    @After
    public void tearDown() throws Exception {
        inventory = null;
    }

    @Test
    /**Test the validation system for the inventory by looking for an instance of ItemDTO*/
    public void validationTest()throws InvalidIDException{
        Assert.assertThat("An ItemDTO is created", inventory.checkValidation("3536",3),
                CoreMatchers.isA(ItemDTO.class));
    }
    @Test
    /**test if the item DTO returned is the same as the one asked for*/
    public void ItemTest()throws InvalidIDException{
        ItemDTO item = inventory.checkValidation("3536",3);
        boolean checker = (item.getItemID().equals("3536"))?true:false;
        Assert.assertTrue("This is the right item",checker);
    }

    @Test
    /**Test for a wrong ItemID result in a <code> throw exception</code>*/
    public void ItemIDFail(){
        try {
        inventory.checkValidation("4000",1);
        }
        catch (InvalidIDException e){
            Assert.assertThat("There is nothing thrown in inventory", e, CoreMatchers.isA(InvalidIDException.class));
        }
    }

    @Test
    /**Test how the method handles a update to inventory.*/
    public void testUpdateInventory(){
        Sale sale = new Sale();
        ItemDTO saleLog = new ItemDTO(23.5f,"Milk","3536",0.12f,4);
        sale.addToSale(saleLog);
        int amount = 0;

        for (Item item : inventory.getInventoryDb().getInventoryList()){
            if(item.getItemID().equals(saleLog.getItemID())){
                amount += item.getQuantity();
            }
        }

        TotalSaleDTO totalSaleDTO = sale.endSale(new CashPayment(35));
        inventory.updateInventory(totalSaleDTO);

        for(Item item : inventory.getInventoryDb().getInventoryList()){
            if(item.getItemID().equals(saleLog.getItemID())){
                Assert.assertTrue("change of inventory",amount > item.getQuantity() );
            }
        }
    }
    @Test
    /**Test that a thrown is made if the "error" code is sent*/
    public void testThrowConnectionFaliure()throws InvalidIDException{
        try {
        inventory.checkValidation("1337",3);
        }
        catch (ConnectionFailureException connection){
            Assert.assertThat("There is no thrown",connection,CoreMatchers.isA(ConnectionFailureException.class));
        }
    }
}