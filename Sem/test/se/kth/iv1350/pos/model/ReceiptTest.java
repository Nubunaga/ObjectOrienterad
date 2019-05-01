/**
 * Used to test the <code>toString</code> method for
 * <code> {@link se.kth.iv1350.pos.model.Receipt}</code>
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.model;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.dbhandler.ItemDTO;


public class ReceiptTest {
    TotalSaleDTO totalSale;
    float change;
    private String newLine = System.getProperty("line.separator");
    Receipt receipt;

    @Before
    public void setUp() throws Exception {
        receipt = new Receipt(totalSale);
        change = -34.3f;
    }

    @After
    public void tearDown() throws Exception {
        receipt = null;
    }

    @Test
    /**This test the entire print system for the printer to work.*/
    public void toString1() {
        Sale sale = new Sale();
        sale.addToSale(new ItemDTO(23.5f,"Milk","3536",0.12f,3));
        TotalSaleDTO totalSaleDTO = sale.endSale(new CashPayment(20));
        Receipt receiptSale = new Receipt(totalSaleDTO);
        Assert.assertTrue("there is no newLine present",receiptSale.toString().contains(newLine));
        Assert.assertTrue("there is no item in this print",receiptSale.toString().contains(totalSaleDTO
        .getSale().getItem().toString()));
        Assert.assertThat("there is no total cost in this string",receiptSale.getTotalSale().getTotalCost(),
                CoreMatchers.isA(Float.class));
        Assert.assertThat("There is no payment object",receiptSale.getTotalSale().getCashPayment(),
                CoreMatchers.isA(CashPayment.class));
        Assert.assertThat("there is no change object",receiptSale.change,CoreMatchers.isA(Float.class));

    }
}