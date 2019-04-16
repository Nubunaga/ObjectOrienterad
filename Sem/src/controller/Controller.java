package controller;

import dbhandler.ExternalAccountingSystem;
import dbhandler.Inventory;
import dbhandler.ItemDTO;
import model.*;

public class Controller {
    private Inventory inv;
    private Sale sale;
    private Register register;
    public Controller(){

    }
    public Controller(Inventory inv,Register reg){
    this.inv = inv;
    this.register = reg;
    }
    public void startNewSale(){
        this.sale = new Sale();
    }
    public SaleDTO addItem(String itemID, int quantity){
        ItemDTO item = inv.checkValidation(itemID,quantity);
        SaleDTO saleinfo =  sale.addSale(item);
        return saleinfo;
    }
    public SaleDTO enterCostumerID(String costumerID){
        SaleDTO newSale = sale.applySaleChange(costumerID);
        return newSale;
    }
    public Reciept addPayment(float pay){
        CashPayment payment = new CashPayment(pay);
        TotalSaleDTO totalCost = sale.endSale(payment);
       Reciept change = register.addToRegister(totalCost);
         return change;
    }
}
