/**The se.kth.iv1350.pos.view class that is presented here is a user interface class that takes input by the user and show
output as return. This is to keep a good structure and handling for the programmer and user.
* @ Author: Netanel Avraham Eklind*/



package se.kth.iv1350.pos.view;
// packages that are associated to se.kth.iv1350.pos.view package.
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.Item;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.SaleDTO;

// utility and io classes that are used in this class
import java.io.IOException;
import java.util.*;

public class View {
  private Scanner in = new Scanner(System.in);
  private  Controller controller;

  /** Constructor for the View object,blank.*/
  public View(){

    }

    /** Constructor for the View object.
     *
     * @param controller
     */
  public View(Controller controller){

      this.controller = controller;
    }

    /**
    * The method runFakeSale purpose is to start the "user interface" for the user of this program and takes command
    * as inputs from the user to initialize different part of the program.
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
            for (Item check : controller.getInventory().getInventoryDb().getInventoryList()) {
              System.out.println("" + check);
            }
              break;

            /*Register check*/
          case "register":

            System.out.println(controller.getRegister().getExternalAccountingSystem().getRegisterMoney());

            break;
            default:
              clearScreen();
              System.out.println("Not valid command!");
              System.out.println("Valid commands: \"newSale\" , \"inventory\" , \"register\"");
        }
      }
    }
/**
* The method <code>addItem</code> purpose is to take command if the user enters a new sale, and allow the user to enter
* an item id to add to the sale.under the code a <code> while </code> loop will continuously check for a command to end
* the new sale. A <code> try / catch </code> exception handler is used to handle the "no item found".
* */
    private void addItem(){
     String itemID;
            while (!"End".equals(itemID = in.next())) {
              try {
                SaleDTO saleInfo = controller.addItem(itemID,in.nextInt());
                System.out.println("" + saleInfo);
              }
              catch (Exception e) {
                System.out.println("No item id for that item");
              }
            }
   }
   /**The purpose of he method <code> addDiscount </code> is to give the user a input chanel for discount and receives a
   * input at <code> SaleDTO newSale = controller.enterCostumerID(in.next()) </code> for the costumer id in string form.
   * This will then send this information to check the discount rules if this is applicable.
   * */
   private void addDiscount(){
            System.out.println("Enter costumer id: ");
            SaleDTO newSale = controller.enterCostumerID(in.next());
            System.out.println("" + newSale);
   }
   /**The method <code> addPayment </code> is to take an input from the user as a payment and receive back a object that
   * shows the change for the sale, if there is any. A <code> try /catch </code> is implemented if the person entering
   * the code enters wrong id, this will then restart the input with a message that says "wrong input". */
    private void addPayment(){
      try {
        Receipt change = controller.addPayment(in.nextFloat());
        clearScreen();
        System.out.println("" + change);
      }
      catch (Exception e){
        System.out.println("what!?");

      }
   }
    /**a static method that only task is to clear a cmd command screen so the user only sees the Receipt.*/
  private static void clearScreen() throws IOException, InterruptedException {
    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }
}
