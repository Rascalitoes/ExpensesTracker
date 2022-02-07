import java.math.BigDecimal;
import java.util.Date;

public class Receipt {
    private final Card card;
    private final Date date;
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal tax;
    private Item[] items;
    private final Store store;

    public Receipt(BigDecimal total, Store store, Date date, Card card){
        this.total = total;
        this.store = store;
        this.date = date;
        this.card = card;
        items = new Item[0];
    }

    public Receipt(BigDecimal total, Item item, Store store, Date date, Card card){
        this.total = total;
        this.store = store;
        this.date = date;
        this.card = card;
        this.items = new Item[]{item};

        computeSubtotal();
        computeTax();
    }

    public Receipt(BigDecimal total, Item[] items, Store store, Date date, Card card){
        this.total = total;
        this.store = store;
        this.date = date;
        this.card = card;
        this.items = items;

        computeSubtotal();
        computeTax();
    }

    public BigDecimal getSubtotal(){ return subtotal; }
    public BigDecimal getTotal(){ return total; }
    public BigDecimal getSubTax(){ return tax; }
    public Card getCard(){ return card; }
    public Date getDate(){ return date; }
    public Store getStore(){ return store; }

    public void addItem(Item item){
        Item[] tempItems = new Item[items.length+1];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        tempItems[items.length] = item;
        items = tempItems;
        tempItems = null;

        computeSubtotal();
        computeTax();
    }

    public void addItem(Item item, double total){
        Item[] tempItems = new Item[items.length+1];
        System.arraycopy(items, 0, tempItems, 0, items.length);
        tempItems[items.length] = item;
        items = tempItems;
        tempItems = null;

        computeSubtotal();
        setTotal(total);
        computeTax();
    }

    private void computeSubtotal(){
        BigDecimal compute = new BigDecimal(0);
        for (Item item: items) {
            compute = compute.add(item.getAmount());
        }
        this.subtotal = compute;
    }

    private void computeTax(){
        this.tax = total.subtract(subtotal);
    }

    private void setTotal(double total){
        this.total = BigDecimal.valueOf(total);
    }

    public void printReceipt(){
        System.out.println(store+": "+date+"\n"+ card);
        for (Item item: items) {
            System.out.println("\t"+item);
        }
        System.out.println();
    }
}
