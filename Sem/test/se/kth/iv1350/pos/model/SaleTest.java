/**
 * Used to test the <code> {@link se.kth.iv1350.pos.model.Sale}</code>
 * @author Netanel Avraham Eklind
 * */
package se.kth.iv1350.pos.model;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class SaleTest {
    ArrayList<ItemDTO> salelog;
    Sale sale;

    @Before
    public void setUp() throws Exception {
        salelog = new ArrayList<>();
        sale = new Sale();

    }

    @After
    public void tearDown() throws Exception {
        salelog = null;
    }

    @Test
    /**Test that the array list is created correctly*/
    public void testSaleArray(){
        salelog = new ArrayList<>();
        Assert.assertArrayEquals(new ArrayList<ItemDTO>().toArray(), salelog.toArray());
    }

    @Test
    /**Test adding a new item*/
    public void testAddNewItem(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        salelog.add(item);
        boolean instance = salelog.contains(item);
        Assert.assertTrue("There is a ItemDTO in new salelog",instance);
    }

    @Test
    /**Test that the item is not null*/
    public void testAddItemNotNull(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        salelog.add(item);
        boolean instance = (salelog.get(0).equals(null));
        Assert.assertFalse("there is an null in item",instance);
    }

    @Test
    /**test the add item method for multiple item, added at different times on the current salelog*/
    public void testNotNewItem(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        SaleDTO instance = sale.addToSale(item);
        int count;
        int count2;
        for (ItemDTO check: instance.getItem()){
            count = check.getQuantity();
            SaleDTO instance2 = sale.addToSale(item);
            for (ItemDTO check2: instance2.getItem()){
               count2  = check2.getQuantity();
               Assert.assertTrue("Increase in quantity", count < count2);
            }
        }
    }

    @Test
    /**How the program handles no item found*/
    public void testNullAdd(){
     try {
            sale.addToSale(null);
     }
     catch (NullPointerException e){
         Assert.assertThat("There is no item",e, CoreMatchers.isA(NullPointerException.class));
     }
    }

    @Test
    /**Test discount applying*/
    public void testSaleChange()throws Exception{
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        SaleDTO normalSale = sale.addToSale(item);
        SaleDTO discountSale = sale.applySaleChange("abba");
        Assert.assertNotEquals("New sale uppdate",normalSale.getRunningTotal(),discountSale.getRunningTotal());
    }

    @Test
    /**Test the "end " signal creation*/
    public void testEndSale(){
        ItemDTO item = new ItemDTO(23.5f,"Milk","3536",0.12f,1);
        sale.addToSale(item);
        TotalSaleDTO instance = sale.endSale(new CashPayment(200));
        Assert.assertThat("There is a instanceOfSale of TotalSaleDTO",instance,CoreMatchers.isA(TotalSaleDTO.class));
    }
}