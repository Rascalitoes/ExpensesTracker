import java.math.BigDecimal;

public class Money {
    BigDecimal money;

    public Money(int dollars, int cents){
        money = new BigDecimal(dollars);
    }

    public Money(double amount){
        money = new BigDecimal(amount);
    }

}
