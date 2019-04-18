package dbhandler;

import controller.Controller;
import model.TotalSaleDTO;
import test.InventoryDb;

public class Inventory {
        InventoryDb inv;
    public Inventory(InventoryDb inv){
        this.inv = inv;
    }
    public ItemDTO checkValidation (String itemID,int quantity) {
        try{
        for (ItemDTO checker : inv.getInventoryList()) {
            if (itemID.equals(checker.getItemID())) {
                return new ItemDTO(checker.getPrice(),checker.getName(),checker.getItemID(),checker.getVatRate(),quantity);
            }
        }
        }
        catch (Exception e){
           System.out.println("Lost connection to InvDatabase ");
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
