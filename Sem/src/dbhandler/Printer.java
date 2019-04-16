package dbhandler;

import model.Reciept;
import model.Register;

public class Printer {
    Reciept reciept;
    Register reg;
    public Printer(){

    }
    public Printer(Reciept reciept){
        this.reciept = reciept;
    }
    public Reciept showChange(Reciept reciept){
        reciept.setChange(reciept.getTotalSale().getTotalCost() - reciept.getTotalSale().getCashPayment().getPayemtn());
       return reciept;
    }
}
