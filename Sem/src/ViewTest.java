import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.model.Register;
import se.kth.iv1350.pos.view.View;

import java.util.Scanner;

import static org.junit.Assert.*;

public class ViewTest {
    Controller controller;
    View view;
    Scanner in;

    @Before
    public void setUp() throws Exception {
         controller = new Controller(new Inventory(new InventoryDb()),new Register());
         view = new View(controller);
         in = new Scanner(System.in);
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
        view = null;
        in = null;
    }

    @Test
    public void runFakeSale() throws Exception {
    }

    @Test
    public void addItem() {
    }

    @Test
    public void addDiscount() {
    }

    @Test
    public void addPayment() {
    }
}