/*This class is used to handle the current sale and send the information needed to other classes with the help of a DTO.
It also is here tio help calculate the current sale value and send back information.
* @ Author Netanel Avraham EKlind*/
package model;

import dbhandler.DiscountRule;
import dbhandler.ItemDTO;

import java.util.ArrayList;

public class Sale {
    ArrayList<ItemDTO> sale = new ArrayList<ItemDTO>(); // create a list of arrays to store all new information inside.
    Calculator calc = new Calculator();
    DiscountRule dR = new DiscountRule();
    // constructor
    public Sale(){

    }
    // add new item DTO to Sale
    public SaleDTO addSale(ItemDTO item){
        boolean flag = false;
        if (!item.equals(null)){                // checks if there is an item.
            for(ItemDTO check : sale){
                if (item.getItemID().equals(check.getItemID())){            // if the item already exist in sale.
                    check.setQuantity(item.getQuantity()+check.getQuantity());
                    flag = true;
                }
            }
            if(!flag){      // add item if false, else do not.
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
        SaleDTO saleinfo = new SaleDTO(sale,calc.runningTotal(sale,discount));  // this can be seen here as a new variable.
        return saleinfo;
    }
    // end sale signal to gather all information and send it to other classes for calculations.
    public TotalSaleDTO endSale(CashPayment pay){
        SaleDTO log = new SaleDTO(sale,calc.runningTotal(sale,1));
        float totalCost = calc.calculateTotalCost(log);
        TotalSaleDTO totalSale = new TotalSaleDTO(log,totalCost,pay);
        return totalSale;
    }
}
