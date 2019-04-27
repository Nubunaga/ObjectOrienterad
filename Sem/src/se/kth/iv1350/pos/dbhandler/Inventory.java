/*External inventory handler that are used to check different part of inventory
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.dbhandler;

// packages for association with package se.kth.iv1350.pos.dbhandler.
import se.kth.iv1350.pos.model.TotalSaleDTO;
import se.kth.iv1350.pos.database.InventoryDb;


public class Inventory {
        InventoryDb inv;
        //constructor
    public Inventory(InventoryDb inv){
        this.inv = inv;
    }

    /*Checks for valid item in "data" base*/
    public ItemDTO checkValidation (String itemID,int quantity) {
        // in the event of a lost of connection, a try catch is implemented.
        try{
        for (Item checker : inv.getInventoryList()) {
            if (itemID.equals(checker.getItemID())) {
                return new ItemDTO(checker.getPrice(),checker.getName(),checker.getItemID(),checker.getVatRate(),quantity);
            }
        }
        }
        catch (Exception e){
           System.out.println("Lost connection to InvDatabase ");       // catch if failed to connect
        }
        return null;
    }

    /*Used to update external inventory with new sale info.*/
    public void updateInventory(TotalSaleDTO totalSale){

        // goes through each item and checks for both inventory and recent sale.
       for (ItemDTO item : totalSale.getSale().getItem()) {
           for (Item update: inv.getInventoryList()){
               if (item.getItemID().equals(update.getItemID())){
                   update.setQuantity(update.getQuantity()-item.getQuantity());
               }
           }
       }

    }
    /*get the inventory object.*/
    public InventoryDb getInv() {
        return inv;
    }
}
