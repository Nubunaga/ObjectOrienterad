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
import se.kth.iv1350.pos.view.View;


public class ControllerTest {
    private InventoryDb inventoryDb =InventoryDb.getInstance();
    private Inventory inventory;
    private Register register;
    private Controller controller;
    private View view;

    public ControllerTest() throws Exception {
    }

    @Before
    /**At the startup of the test program, create the necessary object and use them to test the controller class. */
    public void setUp() throws Exception {
    inventory = new Inventory(inventoryDb);
    register = new Register(inventory,ExternalAccountingSystem.getInstance());
    controller = new Controller(inventory,register);
    view = new View(controller);
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
    public void testAddItem()throws InvalidIDException{
        Assert.assertThat("SaleDTO is created",addSaleInstance(),CoreMatchers.isA(SaleDTO.class));
    }

    @Test
    /**This test how the program reacts when there is no item found */
    public void testNullItem()throws InvalidIDException{
        addSaleInstance();
        try{
            controller.addItem("3562",1);}
        catch (InvalidIDException e ){
        Assert.assertTrue("there is a wrong message", e.getMessage().contains(e.getNoItemFound()));
        }
    }

    @Test
    /**Check if there is a lost to database*/
    public void testLostConnection(){
        try {
            controller.addItem("1337", 1);
        }
        catch (DataConnectionFaliureException e){
            Assert.assertTrue("There is no good handling of crash",e.getMessage().equals("Lost connection to server, try again"));
        } catch (InvalidIDException e) {
            Assert.fail("This is the wrong throw");
        }
    }

    @Test
    /**Check if <code> addItem </code> return contains right information.*/
    public void containsItem()throws InvalidIDException{
    Assert.assertThat("The object contains items",addSaleInstance().getItem(),CoreMatchers.everyItem
            (CoreMatchers.instanceOf(ItemDTO.class)));
    }

    @Test
    /**Check if the discount updates the current sale,with correct costumer id*/
    public void testCostumerID()throws InvalidIDException{
       SaleDTO test = addSaleInstance();
        Assert.assertNotSame(test.getRunningTotal()
                ,controller.enterCostumerID("abba").getRunningTotal());

    }
    @Test
    /**test if the discount updates the current sale with wrong costumer id.*/
    public void testWrongCostumerID()throws InvalidIDException{
        addSaleInstance();
       SaleDTO testAfterDiscount = controller.enterCostumerID("abba");
       SaleDTO testWrongID = controller.enterCostumerID("sara");
        Assert.assertNotSame(testAfterDiscount.getRunningTotal(),testWrongID.getRunningTotal());

    }
    @Test
    /**Test if the <code> addPayment </code> executes correctly*/
    public void testObjectCash()throws InvalidIDException{
        addSaleInstance();
        Receipt instance = controller.addPayment(60);
        Assert.assertThat("A receipt is created",instance,CoreMatchers.isA(Receipt.class));
    }

    /**Used to instanceOfSale a add item or anything of this matter*/
    private SaleDTO addSaleInstance()throws InvalidIDException{
        controller.startNewSale();
        inventoryDb.getInventoryList().add(new Item(23.50f,"Milk","3536", 0.12f,10));
        inventoryDb.getInventoryList().add(new Item(24.95f,"Butter","3537", 0.12f,15));
        inventoryDb.getInventoryList().add(new Item(19.95f,"Bread","3538", 0.12f,10));
        inventoryDb.getInventoryList().add(new Item(10.00f,"Roses","3539", 0.12f,10));
        return controller.addItem("3536",1);
    }
}
