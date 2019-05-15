/**
 * Used to test the <code> {@link se.kth.iv1350.pos.model.Register}</code>
 * @author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.model;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.database.InventoryDb;
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class RegisterTest {
    Register register;
    Calculator calculator;


    @Before
    public void setUp() throws Exception {
    register = new Register(new Inventory(InventoryDb.getInstance()),ExternalAccountingSystem.getInstance());
    calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        register = null;
    }

    @Test
    /**Test that a receipt is created*/
    public void testReceipt (){
        ItemDTO bought =  new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        ArrayList<ItemDTO> sale = new ArrayList<ItemDTO>();
        sale.add(bought);
        SaleDTO saleDTO = new SaleDTO(sale,calculator.runningTotal(sale,1));
        TotalSaleDTO totalSaleDTO = new TotalSaleDTO(saleDTO,calculator.calculateTotalCost(saleDTO),new CashPayment(250));
        Assert.assertThat("There is a object created",register.addToRegister(totalSaleDTO), CoreMatchers.isA(Receipt.class));
    }

    @Test
    /**Test how the program handles a empty receipt*/
    public void testEmptyReceipt(){

        TotalSaleDTO  instance = new TotalSaleDTO(new SaleDTO(new ArrayList<>(),0),0,new CashPayment(100));
        Assert.assertNotNull("There is no item here ",instance);
    }

}