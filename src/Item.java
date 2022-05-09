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

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String toString(){
        return name + "\t\t" + amount.toString();
    }

}
