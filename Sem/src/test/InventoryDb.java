package test;

import dbhandler.ItemDTO;

import java.util.ArrayList;

public class InventoryDb {
    ArrayList<ItemDTO> inventoryList= new ArrayList<ItemDTO>();
    public InventoryDb(){

    }
    public void database(ItemDTO item){
        inventoryList.add(item);
    }

}
