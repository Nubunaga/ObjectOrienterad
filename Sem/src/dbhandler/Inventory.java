/*External inventory handler that are used to check different part of inventory
* @ Author Netanel Avraham Eklind*/

package dbhandler;

/********************************/
// packages for association with package dbhandler.
import model.TotalSaleDTO;
import test.InventoryDb;
/********************************/

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
        for (ItemDTO checker : inv.getInventoryList()) {
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
    public void uppdateInvetory(TotalSaleDTO totalSale){

        // goes through each item and checks for both inventory and recent sale.
       for (ItemDTO item : totalSale.getSale().getItem()) {
           for (ItemDTO uppdate: inv.getInventoryList()){
               if (item.getItemID().equals(uppdate.getItemID())){
                   uppdate.setQuantity(uppdate.getQuantity()-item.getQuantity());
               }
           }
       }

    }
    /*get the inventory object.*/
    public InventoryDb getInv() {
        return inv;
    }
}
