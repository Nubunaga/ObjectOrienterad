/*The se.kth.iv1350.pos.view class that is presented here is a user interface class that takes input by the user and show
output as return. This is to keep a good structure and handling for the programmer and user.
* @ Author: Netanel Avraham Eklind*/

package se.kth.iv1350.pos.view;
// packages that are associated to se.kth.iv1350.pos.view package.
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.Reciept;
import se.kth.iv1350.pos.model.SaleDTO;

// utility and io classes that are used in this class
import java.io.IOException;
import java.util.*;

public class View {
  //declare needed variables.
  private Scanner in = new Scanner(System.in);
  private  Controller controller;

  // Constructor for the View object,blank.
  public View(){

    }
  // Constructor for the View object.
  public View(Controller controller){

      this.controller = controller;
    }

    /*
    * The method runFakeSale is the method that runs to begin the initial starting point
    * for the cash register system. This is the user interface that the user, in this case
    * cashier is gonna see and interact with.
    * @ param there is no parameters in this method, it takes input directly from the user.
    * @ return there is no return in this program. ,
    * */
    public void runFakeSale()throws IOException, InterruptedException {
      for (;;) {

        System.out.println("Enter command");

        switch (in.next()) {

          /*Start new sale*/
          case "newSale":
            controller.startNewSale();
            System.out.println("Enter itemId! End with signal *End* ");
            addItem();
            addDiscount();
            addPayment();
            break;

            /*Check inventory*/
          case "inventory":
            for (ItemDTO check : controller.getInv().getInv().getInventoryList()) {
              System.out.println("" + check);
            }
              break;

            /*Register check*/
          case "register":

            System.out.println(controller.getRegister().getExas().getRegisterMoney());

            break;
            default:
              clearScreen();
              System.out.println("Not valid command!");
              System.out.println("Valid commands: \"newSale\" , \"inventory\" , \"register\"");
        }
      }
    }

   private void addItem(){
     String itemID;
            while (!"End".equals(itemID = in.next())) {       // checks for "End"

              // try to use the sale program, if null return catch nullPointException
              try {
                SaleDTO saleInfo = controller.addItem(itemID,in.nextInt());
                System.out.println("" + saleInfo);
              }
              // catch the NullPointerException and print "no itemID valid".
              catch (Exception e) {
                System.out.println("No item id for that item");
              }
            }
   }
   private void addDiscount(){
            System.out.println("Enter costumer id: ");
            SaleDTO newSale = controller.enterCostumerID(in.next());    // send costumer id
            System.out.println("" + newSale);                     // Print new sale-value after discount
   }
   private void addPayment()throws IOException, InterruptedException {
      try {
        Reciept change = controller.addPayment(in.nextFloat());             // send payment
        clearScreen();
        System.out.println("" + change);                        // Print the receipt that will be received.
      }
      catch (Exception e){
        System.out.println("what!?");
      }
   }
    /*a static method that only task is to clear a cmd command screen so the user only sees the receipt.*/
  private static void clearScreen() throws IOException, InterruptedException {
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }
}
