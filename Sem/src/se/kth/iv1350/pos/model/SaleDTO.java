/**This class help create the Sale data transferable object to be accessed by different classes in the program.
* @ Author Netanel Avraham Eklind*/

// current class
package se.kth.iv1350.pos.model;

// import associated classes.
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import java.util.ArrayList;

public class SaleDTO {
   private ArrayList<ItemDTO> item;
   private float runningTotal;

    /**
    * constructor for the Sale DTO object
    * @param item is an <code> ArrayList <ItemDTO> </code> containing the current sale items.
    * @param runningTotal contains the current sale cost for the costumer.*/
    SaleDTO(ArrayList<ItemDTO> item,float runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
    }

    /**
    * Overrides the current object method and print correctly
    * */
    public String toString(){
        return String.format((""+this.item +System.lineSeparator())+ "Running total: %.2f",runningTotal);
    }

    /**
    * Gets the running total for the object
    * @return running total.
    * */
    public float getRunningTotal(){
        return this.runningTotal;
    }

    /**Get the item list for the current sale
    *
    * @return the item as an array list.
    * */
    public ArrayList<ItemDTO> getItem() {
        return item;
    }
}
