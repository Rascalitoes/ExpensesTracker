import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String store, cont, desc, total, amount;
        int card;
        Item item;
        Receipt r;
        Store s;


        do {
            System.out.print("Store: ");
            store = input.nextLine();
            s = new Store(store);
            System.out.print("Date: ");
            System.out.println("Card: "+"\n1. TD"+"\n2. Meridian Credit"+"\n3. Meridian Debit");
            card = input.nextInt();
            input.nextLine();
            System.out.println("Total: ");
            total = input.nextLine();
            r = new Receipt(new BigDecimal(total),new Store(store),new Date(),new Card());
            do {
                System.out.print("Amount: ");
                amount = input.nextLine();
                System.out.print("Description: ");
                desc = input.nextLine();
                item = new Item(desc,new BigDecimal(amount));
                r.addItem(item);
                System.out.println("Another item? (y/n) ");
                cont = input.nextLine();
            } while (cont.equalsIgnoreCase("y"));
            System.out.print("Another receipt? (y/n) ");
            cont = input.nextLine();
        } while (cont.equalsIgnoreCase("y"));

        r.printReceipt();

    }
}
