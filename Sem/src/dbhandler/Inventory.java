package dbhandler;

import model.TotalSaleDTO;
import test.InventoryDb;

public class Inventory {
        InventoryDb inv;
    public Inventory(InventoryDb inv){
        this.inv = inv;
    }
    public ItemDTO checkValidation (String itemID,int quantity){
        ItemDTO test = new ItemDTO(23.50f,"mjölk","3536", 0.12f,quantity);
        if(itemID.equals(test.getItemID())){
            return test;
        }
        else{
            return null;
        }
    }
    public void uppdateInvetory(TotalSaleDTO totalSale){
        ItemDTO test = new ItemDTO(23.50f,"mjölk","3536", 0.12f,45);
        for (ItemDTO item : totalSale.getSale().getItem()){
            test.setQuantity(test.getQuantity()-item.getQuantity());
        }
        System.out.println(""+test);
    }

}
