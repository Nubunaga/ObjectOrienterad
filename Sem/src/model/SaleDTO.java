package model;

import dbhandler.ItemDTO;

import java.util.ArrayList;

public class SaleDTO {
    ArrayList<ItemDTO> item;
    float runningTotal;

    SaleDTO(ArrayList<ItemDTO> item,float runningTotal){
        this.item = item;
        this.runningTotal = runningTotal;
    }
    public String toString(){
        String s = String.format((""+this.item +System.lineSeparator())+ "Running total: %.2f",runningTotal);
        return s;
    }
    public float getRunningTotal(){
        return this.runningTotal;
    }

    public ArrayList<ItemDTO> getItem() {
        return item;
    }
}
