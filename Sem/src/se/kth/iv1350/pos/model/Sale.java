/**This class is used to handle the current sale and send the information needed to other classes with the help of a DTO.
It also is here tio help calculate the current sale value and send back information.
* @ Author Netanel Avraham Eklind*/

//current package
package se.kth.iv1350.pos.model;

// packages classes that are associated with this class.
import se.kth.iv1350.pos.dbhandler.DiscountRule;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import java.util.ArrayList;

public class Sale {
    ArrayList<ItemDTO> sale;
    private Calculator calc ;
    private   DiscountRule dR ;
    private float discount;

   /**constructor that creates new object to be used by sale.*/
    public Sale(){
        this.calc = new Calculator();
        this.dR = new DiscountRule();
        this.sale = new ArrayList<>();
        this.discount = 1;
    }
    /**
    * The method adds a new item to the <code> ArrayList <ItemDTO> sale</code>
    * and increase the sale information.It updates every time a item is added.
    *
    * @param item is a object of <code> ItemDTO </code> that contains all the information about
    * an item.
    *
    * @return a <code> SaleDTO </code> that contains all the information about the current sale.
    * This creates a new DTO each time a new item is added.
    * */
    public SaleDTO addToSale(ItemDTO item){
        if (!item.equals(null)){
            if(newItem(item)){
            sale.add(item);
            }
            return new SaleDTO(sale,calc.runningTotal(sale,this.discount));
        }
        else{
            return null;
        }
    }

    /**This method checks for the discount rules and updates the sale accordingly.
    *
    * @param costumerID takes the id and is used in <code>
    * R.calculateDiscount(sale,logs,costumerID </code> to update discount with or
    * without the correct id.
    *
    * @return the new sale information after calculation.
    * */
    public SaleDTO applySaleChange(String costumerID){
        SaleDTO logs = new SaleDTO(sale,calc.runningTotal(sale,this.discount));
         this.discount = dR.calculateDiscount(sale,logs,costumerID);
        return new SaleDTO(sale,calc.runningTotal(sale,discount));
    }

    /**This method is an end sale signal that tells the program to start creating an object
    * containing all the current information.
    *
    * @param pay is the object containing the amount paid by the costumer.
    *
    * @return <code> TotalSaleDTO(log,totalCost,pay) </code> that contains all information
    * as, item, cost of sale, payment.
    *  */
    public TotalSaleDTO endSale(CashPayment pay){
        SaleDTO log = new SaleDTO(sale,calc.runningTotal(sale,this.discount));
        float totalCost = calc.calculateTotalCost(log);
        return new TotalSaleDTO(log,totalCost,pay);
    }

    /**This private method is used to check if an item added is new or if it has been added to sale
    * before.
    *
    * @param item is current item to be checked.
    *
    * @return true / false depending if found in <code>  if (item.getItemID().equals(check.getItemID()))
    * </code> thus just updating the quantity.
    *  */
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

    /**This method is used to update the quantity by removing the previous sale item and add a new dto with current
    * quantity
    *
    * @param check is the current sale
    *
    * @param item is the <code> ItemDTO </code> that is to be added to sale.
    *
    * @param count is used to count the index of this item.
    *  */
    private void addNewQuantity (ItemDTO check, ItemDTO item,int count){
        sale.remove(count);
        createNewDTO(check,item,count);
    }

    /**Creates the new item DTO here.
    *
    * @param check, current sale item
    *
    * @param item, is the item to be added
    *
    * @param count is the index to add the item to.
    * */
    private void createNewDTO(ItemDTO check, ItemDTO item,int count){
        sale.add(count,new ItemDTO(check.getPrice(),check.getName(),check.getItemID(),
                check.getVatRate(),check.getQuantity()+item.getQuantity()));
    }
}
