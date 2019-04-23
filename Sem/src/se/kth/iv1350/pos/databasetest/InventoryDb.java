/*Test Db for Inventory
* @ Author: Netanel Avraham Eklind*/

package se.kth.iv1350.pos.databasetest;

import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.io.PrintWriter;
import java.util.ArrayList;

public class InventoryDb   {
    ArrayList<ItemDTO> inventoryList;       // create a list to use
    /*Constructor*/
    public InventoryDb(){
    this.inventoryList = new ArrayList<ItemDTO>();
    }

    /*Create "new" database with different items to find*/
    public void database() throws Exception{
        inventoryList.add(new ItemDTO(23.50f,"Milk","3536", 0.12f,10));
        inventoryList.add(new ItemDTO(24.95f,"Butter","3537", 0.12f,15));
        inventoryList.add(new ItemDTO(19.95f,"Bread","3538", 0.12f,10));
        inventoryList.add(new ItemDTO(10.00f,"Roses","3539", 0.12f,10));
        inventoryList.add(new ItemDTO(36.95f,"Sallad","3540", 0.12f,10));
        inventoryList.add(new ItemDTO(15.95f,"Ketchup","3541", 0.12f,10));
        inventoryList.add(new ItemDTO(26.95f,"Beer","3542", 0.21f,10));
        inventoryList.add(new ItemDTO(21.95f,"Water","3543", 0.12f,10));

        // Print the PLU text to a text file
        PrintWriter PLU = new PrintWriter("PLU-list.text");
        for(ItemDTO print: inventoryList)
        PLU.println(print.getName()+" "+print.getItemID());
        PLU.flush();
        PLU.close();
    }

    /*Get the entire database list.*/
    public ArrayList<ItemDTO> getInventoryList() {
        return inventoryList;
    }
}
