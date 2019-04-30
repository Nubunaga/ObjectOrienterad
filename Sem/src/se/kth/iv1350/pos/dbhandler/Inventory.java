/*External inventory handler that are used to check an external inventory system for the correct item
that is searched for in view.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.dbhandler;

// packages for association with package se.kth.iv1350.pos.dbhandler.
import se.kth.iv1350.pos.model.TotalSaleDTO;
import se.kth.iv1350.pos.database.InventoryDb;


public class Inventory {
        InventoryDb inventoryDb;
        /*
        * Constructor for the inventory object.
        * */
    public Inventory(InventoryDb inventoryDb){
        this.inventoryDb = inventoryDb;
    }

    /*
    * The method looks through the entire "database" for the specific item with the given item id.
    * This is done by implementing a <code> for (Item checker : inventoryDb.getInventoryList()) </code> that
    * looks through the database for that item.
     *
    * @param itemID is a <code> String </code> with information about the searched for item in the system.
    *
    * @param quantity contains a <code> int <code> with information on the amount of items to look for.
    *
    * @return an <code> ItemDTO </code> object if an item is found with that specific id
    * <code> else </code> a null is returned that is used at view to inform that a item is not found.
    *  */
    public ItemDTO checkValidation (String itemID,int quantity) {
        try{
        for (Item checker : inventoryDb.getInventoryList()) {
            if (itemID.equals(checker.getItemID())) {
                return new ItemDTO(checker.getPrice(),checker.getName(),
                        checker.getItemID(),checker.getVatRate(),quantity);
            }
        }
        }
        catch (Exception e){
           System.out.println("Lost connection to InvDatabase ");
        }
        return null;
    }

    /*Goes through the current sale and updates the quantity och each item that have been sold, with the new quantity
    * in the database.
    *
    * @param <code> totalSale </code> contains the entire current sale with items, payment and total cost.
    * */
    public void updateInventory(TotalSaleDTO totalSale){

       for (ItemDTO itemInSale : totalSale.getSale().getItem()) {
           for (Item itemInDatabase: inventoryDb.getInventoryList()){
               if (equals(itemInDatabase,itemInSale)){
                   itemInDatabase.setQuantity(newAmount(itemInDatabase,itemInSale));
               }
           }
       }

    }
    /*
    * get the inventory object.
    *
    * @return inventory database*/
    public InventoryDb getInventoryDb() {
        return inventoryDb;
    }

    /*
    * checks if <code> item.getItemID().equals(update.getItemID() </code> is the same.
    *
    * @param update is current database item
    *
    * @param item is the current sale item
    *
    * @return true if they match. */
    private boolean equals(Item itemInDatabase,ItemDTO itemInSale){
        return (itemInSale.getItemID().equals(itemInDatabase.getItemID()));
    }

    /*
    * Calculate new amount of item to be set.
    *
    * @param update is current database item.
    *
    * @param item is the current sale item
    *
    * @return a value after <code> update.getQuantity()-item.getQuantity() </code>
    * */
    private int newAmount(Item itemInDatabase, ItemDTO itemInSale){
        return itemInDatabase.getQuantity()-itemInSale.getQuantity();
    }
}
