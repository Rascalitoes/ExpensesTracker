import java.math.BigDecimal;

public class Item {
    private String description;
    private BigDecimal amount;
    // Category when that's done
    // Also option for item to be returned

    public Item(String description, BigDecimal amount){
        this.description = description;
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String toString(){
        return description + "\t\t" + amount.toString();
    }

}
