package model;

import dbhandler.DiscountRule;
import dbhandler.ItemDTO;

import java.util.ArrayList;

public class Sale {
    ArrayList<ItemDTO> sale = new ArrayList<ItemDTO>();
    Calculator calc = new Calculator();
    DiscountRule dR = new DiscountRule();
    public Sale(){

    }
    public SaleDTO addSale(ItemDTO item){
        boolean flag = false;
        if (!item.equals(null)){
            for(ItemDTO check : sale){
                if (item.getItemID().equals(check.getItemID())){
                    check.setQuantity(item.getQuantity()+check.getQuantity());
                    flag = true;
                }
            }
            if(!flag){
            sale.add(item);
            }
            SaleDTO saleInfo = new SaleDTO(sale,calc.runningTotal(sale,1));
            return saleInfo;
        }
        else{
            return null;
        }
    }
    public SaleDTO applySaleChange(String costumerID){
        SaleDTO logs = new SaleDTO(sale,calc.runningTotal(sale,1));
        float discount = dR.calculateDiscount(sale,logs,costumerID);
        SaleDTO saleinfo = new SaleDTO(sale,calc.runningTotal(sale,discount));
        return saleinfo;
    }
    public TotalSaleDTO endSale(CashPayment pay){
        SaleDTO log = new SaleDTO(sale,calc.runningTotal(sale,1));
        float totalCost = calc.calculateTotalCost(log);
        TotalSaleDTO totalSale = new TotalSaleDTO(log,totalCost,pay);
        System.out.println(""+totalSale);
        return totalSale;
    }
}
