import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) throws IOException {
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        ObjectOutputStream out;

        String[] items = {"Carrots","Celery","Broccoli","Eggs","Milk"};
        receipts.add(new Receipt(
                new String[]{"Carrots", "Celery", "Broccoli", "Eggs", "Milk"},
                new String[]{"4.55","3.00","5.99","6.99","4.30"}
        ));
        receipts.add(new Receipt(
                new String[]{"DVD","Desktop PC"},
                new String[]{"0.99","450"}
        ));
        receipts.add(new Receipt(
                new String[]{"Pillow"},
                new String[]{"35.00"}
        ));

        out = new ObjectOutputStream(new FileOutputStream("test.dat"));
        out.writeObject(receipts);
        out.close();
        System.out.println("Complete!");
    }
}
