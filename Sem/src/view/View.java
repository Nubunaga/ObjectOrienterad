/*The view class that is present here is used in the MVC layering to get the output
* of the program, all input and output will come from here as well
* @ Author: Netanel Avraham Eklind*/


package view;
// packages that are associated to view package.
import controller.Controller;
import dbhandler.ItemDTO;
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
      String registerEnd = "End";
      String itemID;
      float payment;
      for (;;) {    // places the program in an infintite loop.
        System.out.println("Enter command");

        switch (in.next()) {

          /*Start new sale*/
          case "newSale":
            contr.startNewSale();
            System.out.println("Enter itemId! End with signal *End* ");

            /*Add item*/
            while (!registerEnd.equals(itemID = in.next())) {       // checks for "End"

              // try to use the sale program, if null return catch nullPointException
              try {
                SaleDTO saleInfo = contr.addItem(itemID,in.nextInt());
                System.out.println("" + saleInfo);
              }
              // catch the NullPointerException and print "no itemID valid".
              catch (Exception e) {
                System.out.println("No item id for that item");
              }
            }

            /*Discount*/
            // enter the costumerId if there is allowed,
            System.out.println("Enter costumer id: ");
            SaleDTO newSale = contr.enterCostumerID(in.next());    // send costumer id
            System.out.println("" + newSale);// Print new sale-value after discount

            /*Payment*/
            payment = in.nextFloat();
            Reciept change = contr.addPayment(payment);             // send payment
            clearScreen();
            System.out.println("" + change);// Print the reciept that will be recived.
            break;

            /*Check inventory*/
          case "CheckInv":
            for (ItemDTO check : contr.getInv().getInv().getInventoryList()) {
              System.out.println("" + check);
            }
              break;

            /*Register check*/
          case "checkRegister":
            System.out.println(contr.getRegister().getExas().getRegisterMoney());
            break;
            default:
              System.out.println("Not valid command");
        }
      }
    }

    /*a static method that only task is to clear a cmd command screen so the user only sees the reciept.*/
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
