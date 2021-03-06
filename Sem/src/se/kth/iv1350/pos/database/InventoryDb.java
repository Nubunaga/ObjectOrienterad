/**Test Db for Inventory
 *  this is a singleton made class.
* @ Author: Netanel Avraham Eklind*/

package se.kth.iv1350.pos.database;

import se.kth.iv1350.pos.dbhandler.Item;

import java.io.PrintWriter;
import java.util.ArrayList;

public class InventoryDb   {
    private ArrayList<Item> inventoryList;       // create a list to use
    private static InventoryDb single_instance = null;

    /**Constructor*/
    private InventoryDb()throws Exception{
    this.inventoryList = new ArrayList<Item>();
        database();
    }
    /**
     * This get the one and only instance made by this object.
     * @return an instance of the object <code>{@link InventoryDb}</code>.
     * */
    public static InventoryDb getInstance()throws Exception{
        if(single_instance == null){
            single_instance = new InventoryDb();
        }
        return single_instance;
    }

    /**Create "new" database with different items to find
     * @throws Exception to print the file, this is thrown*/
    private void database() throws Exception{
        inventoryList.add(new Item(23.50f,"Milk","3536", 0.12f,10));
        inventoryList.add(new Item(24.95f,"Butter","3537", 0.12f,15));
        inventoryList.add(new Item(19.95f,"Bread","3538", 0.12f,10));
        inventoryList.add(new Item(10.00f,"Roses","3539", 0.12f,10));
        inventoryList.add(new Item(36.95f,"Sallad","3540", 0.12f,10));
        inventoryList.add(new Item(15.95f,"Ketchup","3541", 0.12f,10));
        inventoryList.add(new Item(26.95f,"Beer","3542", 0.21f,10));
        inventoryList.add(new Item(21.95f,"Water","3543", 0.12f,10));
        printFile();
    }

    /**Get the entire database list.
     * @return inventoryList*/
    public ArrayList<Item> getInventoryList() {
        return inventoryList;
    }

    private void printFile()throws Exception {
        PrintWriter PLU = new PrintWriter("PLU-list.text");
        for (Item print : inventoryList)
            PLU.println(print.getName() + " " + print.getItemID());
        PLU.flush();
        PLU.close();
    }
}
