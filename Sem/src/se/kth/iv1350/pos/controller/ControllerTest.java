package se.kth.iv1350.pos.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.model.Register;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

import static org.junit.Assert.*;

public class ControllerTest {
    private Inventory inventory;
    private Sale sale;
    private Register register;
    Controller controller;

    @Before
    public void setUp() throws Exception { controller = new Controller(new Inventory(new InventoryDb()),new Register());
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void startNewSale() {
        controller.startNewSale();
        Assert.assertNotNull(controller.getSale());
    }

    @Test
    public void addItem() {
        SaleDTO instance = controller.addItem("3536",3);
        Assert.assertEquals(controller.addItem("3536",3),instance);
        }

    @Test
    public void enterCostumerID() {
    }

    @Test
    public void addPayment() {
    }

    @Test
    public void getInv() {
    }

    @Test
    public void getRegister() {
    }

    @Test
    public void getSale() {
    }
}