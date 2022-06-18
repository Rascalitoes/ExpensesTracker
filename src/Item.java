import javafx.util.Pair;

import java.math.BigDecimal;

public class Item extends Pair<String,BigDecimal> implements java.io.Serializable{
//    private String name;
//    private BigDecimal amount;
    // Category when that's done
    // Also option for item to be returned
    // Basically a K-V Pair

    public Item(String description, BigDecimal amount){
        super(description,amount);
//        this.name = description;
//        this.amount = amount;
    }

    public Item(String description, String amount){
        super(description,new BigDecimal(amount));
//        this.name = description;
//        this.amount = new BigDecimal(amount);
    }

    public String getName(){
        return this.getKey();
    }

    public BigDecimal getAmount(){
        return this.getValue();
    }

    public String toString(){
        return this.getKey() + "\t\t" + this.getValue();
    }

}
