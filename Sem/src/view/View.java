package view;

import controller.Controller;
import model.Reciept;
import model.SaleDTO;
import java.util.*;

public class View {

  Scanner in = new Scanner(System.in);
  private  Controller contr;

  // Constructor for the View object.
    public View(){

    }
  // Constructor for the View object.
  public View(Controller contr){

      this.contr = contr;
    }

    // start new sale
    public void runFakeSale() {
        //start new sale object and declare variables.
      contr.startNewSale();
      String registerEnd = "End";
      String itemID;
      float payment;
      float amount;
      // check for "End" signal to stop, else just add items.
        System.out.println("Enter itemId! End with signal *End* ");
      while(!registerEnd.equals(itemID =in.next())){

          // try to use the sale program, if null return catch nullPointException
         try {
            SaleDTO saleInfo = contr.addItem(itemID, in.nextInt());
            System.out.println("" + saleInfo);
         }
         // catch the NullPointerException and print "no itemID valid".
      catch(NullPointerException e){
          System.out.println("No item id for that item");
        }
      }
      // enter the costumerId if there is allowed,
      System.out.println("Enter costumer id: ");
      SaleDTO newSale =  contr.enterCostumerID(in.next());
      System.out.println(""+ newSale);
      payment = in.nextFloat();
      Reciept change = contr.addPayment(payment);
      clearScreen();
      System.out.println(""+change);
    }
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
