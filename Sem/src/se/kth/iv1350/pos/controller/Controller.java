/**
* The controller class that is presented here is used to be a bridge between the view (user interface)
* and the rest of the program.
* @Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.controller;
/** import packages that are in association to this package*/
import se.kth.iv1350.pos.dbhandler.*;
import se.kth.iv1350.pos.model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Inventory inventory;
    private Sale sale;
    private Register register;
    private List<RevenueObserver> revenueObserversList = new ArrayList<>();
    /**a blank constructor if only the class wants to be accessed.*/
    public Controller(){

    }
    /**
    * Constructor for object controller
    * @param  inventory  and reg are 2 object created in main,
     *                    inventory and inventory db
     *
     * @param register  contains register
    */
    public Controller(Inventory inventory,Register register){
    this.inventory = inventory;
    this.register = register;
    }

    /**
     * every new sale for the program.
     * */
    public void startNewSale(){
        this.sale = new Sale();
    }

    /**
    * The method <code> addItem </code> is called each time a new item is to be checked and added to the current sale.
    *
    * @param itemID is the id for the item.
    *
    * @param quantity is used to set the amount of the item that is to be bought.
    *
    * @return saleInfo, object is returned with object and displayed if it contains a object,
    * if <code> null </code> then a exception will be thrown in view.
     *
     * @throws InvalidIDException           checked <code>Exception</code> that is thrown if no item found.
    * */
    public SaleDTO addItem(String itemID, int quantity)throws InvalidIDException {
        ItemDTO item = inventory.checkValidation(itemID,quantity);
        return sale.addToSale(item);
    }

    /**
    * The method take an input as a object string and with that searches the database for this person and apply discount.
     *
    * @param costumerID will be sent as an argument to method <code>sale.applySaleChange()</code>.
    * @return will be of the new sale information as an new object of SaleDTO that will be shown to the costumer.
    */
    public SaleDTO enterCostumerID(String costumerID){
        return sale.applySaleChange(costumerID);
    }

    /**
    * Method <code> addPayment </code> takes input from the view class and creates a object as payment, that is used
    * to create a total sale DTO that contains all information about the current sale.
    *
    * @param amountPaid pay and applies it to a new object, this is then used in <code> new CashPayment(pay) </code>.
    *
    * @return object by the name Receipt that will be created by executing method
    *<code>register.addToRegister(totalCost)</code>
    * */
    public Receipt addPayment(float amountPaid){
        CashPayment payment = new CashPayment(amountPaid);
        TotalSaleDTO totalCost = sale.endSale(payment);
        register.addObservers(revenueObserversList);
         return register.addToRegister(totalCost);
    }

    /**
    * checks the inventory for what items in store.
    *
    * @return <code>ArrayList</code> containing the inventory's items.
    * */
    public ArrayList<Item> checkInventory() {
        return inventory.getInventoryDb().getInventoryList();
    }

    /**
    * checks the register for current amount.
    * @return the current amount of cash in the register, in <code>float</code>
    * */
    public float checkRegister() {
        return register.getExternalAccountingSystem().getRegisterMoney();
    }

    /**
    * Get the register object to be used in the public interface
    * @return sale the current <code>Sale</code> object that is associated with controller
    * */
    Sale getSale() {
        return sale;
    }

    public void addRevenueObserver(RevenueObserver revenueObserver){
        revenueObserversList.add(revenueObserver);
    }
}
