/**
 * Used to test the <code> {@link se.kth.iv1350.pos.dbhandler.Printer}</code>class for unwanted events.
 * @author Netanel Avraham Eklind
 * */
package se.kth.iv1350.pos.dbhandler;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.View;


import java.io.IOException;

public class PrinterTest {
    private Printer printer;
   private Register register;
   private Inventory inventory;
   private InventoryDb inventoryDb;
   private ExternalAccountingSystem externalAccountingSystem;

    @Before
    public void setUp() throws Exception {
        printer = new Printer();
        inventoryDb = InventoryDb.getInstance();
        inventory = new Inventory(inventoryDb);
        externalAccountingSystem = ExternalAccountingSystem.getInstance();
        register = new Register(inventory,externalAccountingSystem);
    }

    @After
    public void tearDown() throws Exception {
        printer = null;
    }
}