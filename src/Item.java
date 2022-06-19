import javafx.util.Pair;

import java.math.BigDecimal;

public class Item implements java.io.Serializable{
    private String name;
    private BigDecimal amount;
    // Category when that's done
    // Also option for item to be returned
    // Basically a K-V Pair

    public Item(String description, BigDecimal amount){
        this.name = description;
        this.amount = amount;
    }

    public Item(String description, String amount){
        this.name = description;
        this.amount = new BigDecimal(amount);
    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String toString(){
        return this.name + "\t\t" + this.amount;
    }

}
