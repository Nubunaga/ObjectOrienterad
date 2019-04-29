/*This class help create the Sale data transferable object to be accessed by different classes in the program.
* @ Author Netanel Avraham Eklind*/
package se.kth.iv1350.pos.model;
// import associated classes.
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import java.util.ArrayList;

public class SaleDTO {
    ArrayList<ItemDTO> item;    // create a list to store all the items.
    float runningTotal;
    // constructor
    SaleDTO(ArrayList<ItemDTO> item,float runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
    }

    //print the object
    public String toString(){
        return String.format((""+this.item +System.lineSeparator())+ "Running total: %.2f",runningTotal);
    }

    // get the running total primitive data
    public float getRunningTotal(){
        return this.runningTotal;
    }

    // get the item objects.
    public ArrayList<ItemDTO> getItem() {
        return item;
    }
}
