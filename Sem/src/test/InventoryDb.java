package test;

import dbhandler.ItemDTO;

import java.util.ArrayList;

public class InventoryDb {
    ArrayList<ItemDTO> inventoryList;
    public InventoryDb(){
    this.inventoryList = new ArrayList<ItemDTO>();
    }
    public void database(){
        inventoryList.add(new ItemDTO(23.50f,"Mjölk","3536", 0.12f,10));
        inventoryList.add(new ItemDTO(24.95f,"Smör","3537", 0.12f,15));
        inventoryList.add(new ItemDTO(19.95f,"Bröd","3538", 0.12f,10));
        inventoryList.add(new ItemDTO(10.00f,"Ros","3539", 0.12f,10));
        inventoryList.add(new ItemDTO(36.95f,"Sallad","3540", 0.12f,10));
        inventoryList.add(new ItemDTO(15.95f,"Ketchup","3541", 0.12f,10));
        inventoryList.add(new ItemDTO(26.95f,"Öl","3542", 0.21f,10));
        inventoryList.add(new ItemDTO(21.95f,"Vatten","3543", 0.12f,10));
        System.out.println("done");
    }

    public ArrayList<ItemDTO> getInventoryList() {
        return inventoryList;
    }
}
