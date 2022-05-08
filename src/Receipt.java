import javafx.util.Pair;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.LongAccumulator;

public class Receipt {

    private Card card;
    private LocalDate date;
    private BigDecimal subtotal;
    private BigDecimal total;
    private BigDecimal tax;
    private Item[] items;
    private Store store;

    public Receipt(String[] itemNames){
        date = LocalDate.now();
//        subtotal;
//        total;
//        tax;
        items = new Item[itemNames.length];
        for (int i = 0; i < itemNames.length; i++) {
            items[i] = new Item(itemNames[i],null);
        }
//        store;
    }

    public Receipt(String[] itemNames, String[] itemPrices){
        date = LocalDate.now();
//        subtotal;
//        total;
//        tax;
        items = new Item[itemNames.length];
        for (int i = 0; i < itemNames.length; i++) {
            items[i] = new Item(itemNames[i],new BigDecimal(itemPrices[i]));
        }
//        store;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String toString(){
        return Arrays.toString(items);
    }

    public LocalDate getDate(){return date;}
    public void setDay(int day){date = date.withDayOfMonth(day);}
    public void setMonth(int month){date = date.withMonth(month);}
    public void setYear(int year){date = date.withYear(year);}

    //
//    public Receipt(BigDecimal total, Store store, Date date, Card card){
//        this.total = total;
//        this.store = store;
//        this.date = date;
//        this.card = card;
//        items = new Item[0];
//    }
//
//    public Receipt(BigDecimal total, Item item, Store store, Date date, Card card){
//        this.total = total;
//        this.store = store;
//        this.date = date;
//        this.card = card;
//        this.items = new Item[]{item};
//
//        computeSubtotal();
//        computeTax();
//    }
//
//    public Receipt(BigDecimal total, Item[] items, Store store, Date date, Card card){
//        this.total = total;
//        this.store = store;
//        this.date = date;
//        this.card = card;
//        this.items = items;
//
//        computeSubtotal();
//        computeTax();
//    }
//
//    public BigDecimal getSubtotal(){ return subtotal; }
//    public BigDecimal getTotal(){ return total; }
//    public BigDecimal getSubTax(){ return tax; }
//    public Card getCard(){ return card; }
//    public Date getDate(){ return date; }
//    public Store getStore(){ return store; }
//
//    public void addItem(Item item){
//        Item[] tempItems = new Item[items.length+1];
//        System.arraycopy(items, 0, tempItems, 0, items.length);
//        tempItems[items.length] = item;
//        items = tempItems;
//        tempItems = null;
//
//        computeSubtotal();
//        computeTax();
//    }
//
//    public void addItem(Item item, double total){
//        Item[] tempItems = new Item[items.length+1];
//        System.arraycopy(items, 0, tempItems, 0, items.length);
//        tempItems[items.length] = item;
//        items = tempItems;
//        tempItems = null;
//
//        computeSubtotal();
//        setTotal(total);
//        computeTax();
//    }
//
//    private void computeSubtotal(){
//        BigDecimal compute = new BigDecimal(0);
//        for (Item item: items) {
//            compute = compute.add(item.getAmount());
//        }
//        this.subtotal = compute;
//    }
//
//    private void computeTax(){
//        this.tax = total.subtract(subtotal);
//    }
//
//    private void setTotal(double total){
//        this.total = BigDecimal.valueOf(total);
//    }
//
//    public void printReceipt(){
//        System.out.println(store+": "+date+"\n"+ card);
//        for (Item item: items) {
//            System.out.println("\t"+item);
//        }
//        System.out.println("Total: "+total);
//        System.out.println();
//    }
}
