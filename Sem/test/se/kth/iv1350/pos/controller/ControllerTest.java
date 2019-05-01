/**
 * This class is used to test the <code> {@link se.kth.iv1350.pos.controller.Controller}</code> class
 * for any bugs or unwanted events
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.controller;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.dbhandler.*;
import se.kth.iv1350.pos.model.*;


public class ControllerTest {
    private InventoryDb inventoryDb = new InventoryDb();
    private Inventory inventory;
    private Register register;
    private Controller controller;

    @Before
    /**At the startup of the test program, create the necessary object and use them to test the controller class. */
    public void setUp() throws Exception {
    inventory = new Inventory(inventoryDb);
    register = new Register(inventory,new ExternalAccountingSystem());
    controller = new Controller(inventory,register);
    }

    @After
    /**This is used to declare all the object as null so there is no conflict when the program is "live"*/
    public void tearDown() throws Exception {
        inventoryDb = null;
        inventory = null;
        register = null;
        controller = null;
    }

    @Test
    /**Test if after the new Sale signal is sent, that a object is created.*/
    public void startNewSale() {
        controller.startNewSale();
        Assert.assertNotNull("The object sale is created",controller.getSale());
    }

    @Test
    /**Check if add item, correct, returns sale information correctly.*/
    public void testAddItem(){
        Assert.assertThat("SaleDTO is created",addSaleInstance(),CoreMatchers.isA(SaleDTO.class));
    }

    @Test
    /**This test how the program reacts when there is no item found */
    public void testNullItem(){
        addSaleInstance();
        try{
            controller.addItem("3562",1);}
        catch (NullPointerException e ){
        Assert.assertThat("There is no item",e,CoreMatchers.isA(NullPointerException.class));
        }
    }

    @Test
    /**Check if <code> addItem </code> return contains right information.*/
    public void containsItem(){
    Assert.assertThat("The object contains items",addSaleInstance().getItem(),CoreMatchers.everyItem
            (CoreMatchers.instanceOf(ItemDTO.class)));
    }

    @Test
    /**Check if the discount updates the current sale,with correct costumer id*/
    public void testCostumerID(){
       SaleDTO test = addSaleInstance();
        Assert.assertNotSame(test.getRunningTotal()
                ,controller.enterCostumerID("abba").getRunningTotal());

    }
    @Test
    /**test if the discount updates the current sale with wrong costumer id.*/
    public void testWrongCostumerID(){
        addSaleInstance();
       SaleDTO testAfterDiscount = controller.enterCostumerID("abba");
       SaleDTO testWrongID = controller.enterCostumerID("sara");
        Assert.assertNotSame(testAfterDiscount.getRunningTotal(),testWrongID.getRunningTotal());

    }
    @Test
    /**Test if the <code> addPayment </code> executes correctly*/
    public void testObjectCash(){
        addSaleInstance();
        Receipt instance = controller.addPayment(60);
        Assert.assertThat("A receipt is created",instance,CoreMatchers.isA(Receipt.class));
    }

    /**Used to instanceOfSale a add item or anything of this matter*/
    private SaleDTO addSaleInstance(){
        controller.startNewSale();
        inventoryDb.getInventoryList().add(new Item(23.50f,"Milk","3536", 0.12f,10));
        inventoryDb.getInventoryList().add(new Item(24.95f,"Butter","3537", 0.12f,15));
        inventoryDb.getInventoryList().add(new Item(19.95f,"Bread","3538", 0.12f,10));
        inventoryDb.getInventoryList().add(new Item(10.00f,"Roses","3539", 0.12f,10));
        return controller.addItem("3536",1);
    }
}
