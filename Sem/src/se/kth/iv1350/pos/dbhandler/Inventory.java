/**External inventory handler that are used to check an external inventory system for the correct item
that is searched for in view.
* @ Author Netanel Avraham Eklind*/

package se.kth.iv1350.pos.dbhandler;

// packages for association with package se.kth.iv1350.pos.dbhandler.
import se.kth.iv1350.pos.model.TotalSaleDTO;
import se.kth.iv1350.pos.database.InventoryDb;


public class Inventory{
     private InventoryDb inventoryDb;
     private String argString[];
        /**
        * Constructor for the inventory object.
         * @param  inventoryDb is the database for items.
        * */
    public Inventory(InventoryDb inventoryDb){
        this.inventoryDb = inventoryDb;
    }

    /**
    *   This updated method now receives the parameters and send them to a mather for validation.
     *
    * @param itemID is a <code> String </code> with information about the searched for item in the system.
    *
    * @param quantity contains a <code> int </code> with information on the amount of items to look for.
    *
    * @return an <code> ItemDTO </code> object if an item is found with that specific id.
    * <code> else </code> a null is returned that is used at view to inform that a item is not found.
     *
     * @throws InvalidIDException   checked exception that throws if there is no item Id found.
    *  */
    public ItemDTO checkValidation (String itemID,int quantity)throws InvalidIDException{
        if (itemID.equals("1337")){
                throw  new ConnectionFailureException();
        }
        for (Item checker : inventoryDb.getInventoryList()) {
            if (itemID.equals(checker.getItemID())) {
                return new ItemDTO(checker.getPrice(), checker.getName(),
                        checker.getItemID(), checker.getVatRate(), quantity);
            }
        }
        throw new InvalidIDException(itemID);
    }

    /**
    *Goes through the current sale and updates the quantity och each item that have been sold, with the new quantity
    * in the database.
    *
    * @param totalSale  contains the entire current sale with items, payment and total cost.
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
    /**
    * get the inventory object.
    *
    * @return inventory database*/
    public InventoryDb getInventoryDb() {
        return inventoryDb;
    }

    /**
    * checks if <code> item.getItemID().equals(update.getItemID() </code> is the same.
    *
    * @param itemInDatabase is current database item
    *
    * @param itemInSale is the current sale item
    *
    * @return true if they match. */
    private boolean equals(Item itemInDatabase,ItemDTO itemInSale){
        return (itemInSale.getItemID().equals(itemInDatabase.getItemID()));
    }

    /**
    * Calculate new amount of item to be set.
    *
    * @param itemInDatabase is current database item.
    *
    * @param itemInSale is the current sale item
    *
    * @return a value after <code> update.getQuantity()-item.getQuantity() </code>
    * */
    private int newAmount(Item itemInDatabase, ItemDTO itemInSale){
        return itemInDatabase.getQuantity()-itemInSale.getQuantity();
    }
}
