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

public class PrinterTest {
    private Printer printer;
   private Register register;

    @Before
    public void setUp() throws Exception {
        printer = new Printer();
        register = new Register(new Inventory(new InventoryDb()),new ExternalAccountingSystem());
    }

    @After
    public void tearDown() throws Exception {
        printer = null;
    }

    @Test
    /**Test the calculation of the change*/
    public void testChangeCalculation(){
        Sale sale = new Sale();
        sale.addToSale(new ItemDTO(23.5f,"Milk","3536",0.12f,3));
        TotalSaleDTO totalSaleDTO = sale.endSale(new CashPayment(20));
       Receipt receipt= register.addToRegister(totalSaleDTO);
        Assert.assertThat("A calculation is made only if there is an instance",printer.showChange(receipt),
                CoreMatchers.isA(Receipt.class));
    }
}