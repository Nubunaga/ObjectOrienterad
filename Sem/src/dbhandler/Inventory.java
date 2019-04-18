package dbhandler;

import model.TotalSaleDTO;
import test.InventoryDb;

public class Inventory {
        InventoryDb inv;
    public Inventory(InventoryDb inv){
        this.inv = inv;
    }
    public ItemDTO checkValidation (String itemID,int quantity) {
        for (ItemDTO checker : inv.getInventoryList()) {
            if (itemID.equals(checker.getItemID())) {
                return new ItemDTO(checker.getPrice(),checker.getName(),checker.getItemID(),checker.getVatRate(),quantity);
            }
        }
        return null;
    }
    public void uppdateInvetory(TotalSaleDTO totalSale){
       for (ItemDTO item : totalSale.getSale().getItem()) {
           for (ItemDTO uppdate: inv.getInventoryList()){
               if (item.getItemID().equals(uppdate.getItemID())){
                   uppdate.setQuantity(uppdate.getQuantity()-item.getQuantity());
               }
           }
       }

    }

}
