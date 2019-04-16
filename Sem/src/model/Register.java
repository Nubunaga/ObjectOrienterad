package model;

import controller.Controller;
import dbhandler.ExternalAccountingSystem;
import dbhandler.Inventory;
import dbhandler.Printer;

public class Register {
    private ExternalAccountingSystem exas;
    private Inventory inv;
    public Register(){

    }
    public Register(Inventory inv, ExternalAccountingSystem exas){
        this.exas = exas;
        this.inv = inv;
    }
    public Reciept addToRegister(TotalSaleDTO totalSale){
    inv.uppdateInvetory(totalSale);
    exas.logSale(totalSale);
    Reciept reciept = new Reciept(totalSale);
    Printer printer = new Printer(reciept);
    Reciept change  = printer.showChange(reciept);
    return change;
    }

}
