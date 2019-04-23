/*For the MVC layering, this packages is only used på class se.kth.iv1350.pos.controller to execute different part of the program
*@ Author Netanel Avraham Eklind*/

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
    // create se.kth.iv1350.pos.controller
    public Controller(Inventory inv,Register reg){
    this.inv = inv;
    this.register = reg;
    }
    // start a new sale object by calling constructor in Sale class
    public void startNewSale(){
        this.sale = new Sale();
    }
    //Add a new item to sale method.
    public SaleDTO addItem(String itemID, int quantity){
        ItemDTO item = inv.checkValidation(itemID,quantity);        // check with inventory class.
        SaleDTO saleinfo =  sale.addSale(item);                     // add this information to sale and then return info
        return saleinfo;
    }

    /* Check Consumer Id for Consumer based discount.
    Else just apply normal discount*/
    public SaleDTO enterCostumerID(String costumerID){
        SaleDTO newSale = sale.applySaleChange(costumerID);
        return newSale;                                             // return new information.
    }

    // add the payment and creates the objects needed for this.
    public Reciept addPayment(float pay){
        CashPayment payment = new CashPayment(pay);
        TotalSaleDTO totalCost = sale.endSale(payment);
       Reciept change = register.addToRegister(totalCost);
         return change;                                             // returns the change if there are any!.
    }
/*Get the inv object*/
    public Inventory getInv() {
        return inv;
    }
/*Get the register object*/
    public Register getRegister() {
        return register;
    }
}
