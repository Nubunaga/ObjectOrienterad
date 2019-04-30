/*The controller class that is presented here is used to be a bridge between the view (user interface)
* and the rest of the program.
* @Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.controller;
// import packages that are in association to this package
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.*;

public class Controller {
    // declare private attributes that is used by se.kth.iv1350.pos.controller
    private Inventory inv;
    private Sale sale;
    private Register register;
    // a blank constructor if only the class wants to be accessed.
    public Controller(){

    }
    /*Constructor for object controller
    * @param inv and reg are 2 object created in main
    */
    public Controller(Inventory inv,Register reg){
    this.inv = inv;
    this.register = reg;
    }

    /*Starts every new sale for the program.*/
    public void startNewSale(){
        this.sale = new Sale();
    }

    /*The method <code> addItem </code> is called each time a new item is to be checked and added to the current sale
    * @param itemID is the id for the item.
    * @param quantity is used to set the amount of the item that is to be bought
    * @return saleInfo, object is returned with object and displayed if it contains a object.
    * if <code>null</code> then a exception will be thrown in view.
    * */
    public SaleDTO addItem(String itemID, int quantity){
        ItemDTO item = inv.checkValidation(itemID,quantity);
        return sale.addToSale(item);
    }

    /*The method take an input as a object string and with that searches the database for this person and apply discount.
    @param costumerID will be sent as an argument to method <code>sale.applySaleChange()</code>.
    @return will be of the new sale information as an new object of SaleDTO that will be shown to the costumer.
    */
    public SaleDTO enterCostumerID(String costumerID){
        return sale.applySaleChange(costumerID);
    }

    /*Method <code> addPayment </code> takes input from the view class and creates a object as payment, that is used
    to create a total sale DTO that contains all information about the current sale.
    * @param takes pay and applies it to a new object, this is then used in <code> new CashPayment(pay) </code>
    * @return object by the name Receipt that will be created by executing method
     <code>register.addToRegister(totalCost)</code>*/
    public Receipt addPayment(float pay){
        CashPayment payment = new CashPayment(pay);
        TotalSaleDTO totalCost = sale.endSale(payment);
         return register.addToRegister(totalCost);
    }

    /*Gets the inventory object to be used in the public interface.
    * @return the current <code>Inventory</code> object, <code> null</code> or object.*/
    public Inventory getInv() {
        return inv;
    }

    /*Gets the register object to be used in the public interface
    * @return the current <code>Register</code> object that is associated to controller.*/
    public Register getRegister() {
        return register;
    }

    /*Get the register object to be used in the public interface
    * @ return the current <code>Sale</code> object that is associated with controller*/
    public Sale getSale() {
        return sale;
    }
}
