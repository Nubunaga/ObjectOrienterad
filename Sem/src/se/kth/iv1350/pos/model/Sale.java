/*This class is used to handle the current sale and send the information needed to other classes with the help of a DTO.
It also is here tio help calculate the current sale value and send back information.
* @ Author Netanel Avraham EKlind*/
package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.DiscountRule;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import java.util.ArrayList;

public class Sale {
    ArrayList<ItemDTO> sale; // create a list of arrays to store all new information inside.
    Calculator calc ;
    DiscountRule dR ;
    // constructor
    public Sale(){
        this.calc = new Calculator();
        this.dR = new DiscountRule();
        this.sale = new ArrayList<>();
    }
    // add new item DTO to Sale
    public SaleDTO addToSale(ItemDTO item){
        if (!item.equals(null)){                // checks if there is an item.
            if(newItem(item)){                   // add item if false, else do not.
            sale.add(item);
            }
            SaleDTO saleInfo = new SaleDTO(sale,calc.runningTotal(sale,1)); // return sale dto(information)
            return saleInfo;
        }
        else{
            return null;
        }
    }

    // apply change to sale with the help of discount.
    public SaleDTO applySaleChange(String costumerID){
        SaleDTO logs = new SaleDTO(sale,calc.runningTotal(sale,1)); // the 1 is for a discount change, if there is one.
        float discount = dR.calculateDiscount(sale,logs,costumerID);
        return new SaleDTO(sale,calc.runningTotal(sale,discount));  // this can be seen here as a new variable.
    }

    // end sale signal to gather all information and send it to other classes for calculations.
    public TotalSaleDTO endSale(CashPayment pay){
        SaleDTO log = new SaleDTO(sale,calc.runningTotal(sale,1));
        float totalCost = calc.calculateTotalCost(log);
        TotalSaleDTO totalSale = new TotalSaleDTO(log,totalCost,pay);
        return totalSale;
    }


    private boolean newItem(ItemDTO item){
        int count = 0;
        for(ItemDTO check : sale){
            if (item.getItemID().equals(check.getItemID())){            // if the item already exist in sale.
                addNewQuantity(check,item,count);
               return false;
            }
            count++;
        }
        return true;
    }


    private void addNewQuantity (ItemDTO check, ItemDTO item,int count){
        sale.remove(count);
        createNewDTO(check,item,count);
    }


    private void createNewDTO(ItemDTO check, ItemDTO item,int count){
        sale.add(count,new ItemDTO(check.getPrice(),check.getName(),check.getItemID(),
                check.getVatRate(),check.getQuantity()+item.getQuantity()));
    }
}
