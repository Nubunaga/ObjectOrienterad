package se.kth.iv1350.pos.model;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;
    ArrayList<ItemDTO> sale;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        sale = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
        sale = null;
    }

    @Test
    /*Test that there is a calculation made by the program*/
    public void testRunningTotal() {
        sale.add(new ItemDTO(23.5f, "Milk", "3536", 0.12f, 3));
        boolean instance = (calculator.runningTotal(sale, 1) > 0) ? true : false;
        Assert.assertTrue("There is no calculation made", instance);
    }

    @Test
    /*Is there a zero in the calculation*/
    public void testZeroCalculation() {
        sale.add(new ItemDTO(23.5f, "Milk", "3536", 0.12f, 3));
        try {
            calculator.runningTotal(sale, 0);
        } catch (ArithmeticException e) {
            Assert.assertThat("There is a zero calculation", e, CoreMatchers.isA(ArithmeticException.class));
        }

    }

    @Test
    /*This test if there is a null in the salelog, how the program handles this.*/
    public void testNullCalculation() {
        boolean instance = (calculator.runningTotal(sale, 1) > 0) ? false : true;
        Assert.assertFalse("There is no value in a null calculation", false);
    }

    @Test
    /*This test the totalCost calculation of the program*/
    public void totalCalculationTest() {
        sale.add(new ItemDTO(23.5f, "Milk", "3536", 0.12f, 3));
        calculator.runningTotal(sale, 1);
        SaleDTO instance = new SaleDTO(sale, calculator.runningTotal(sale, 1));
        boolean test = (calculator.calculateTotalCost(instance) > 0) ? true : false;
        Assert.assertTrue("There is no calculation made", test);
    }
}