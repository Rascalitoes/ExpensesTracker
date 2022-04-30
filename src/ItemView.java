import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ItemView extends GridPane {

    private ArrayList<TextField> itemNames, itemPrices;
    private int currentRows;

    public ItemView(int itemNum){

        this.currentRows = itemNum;
        itemNames = new ArrayList<TextField>();
        itemPrices = new ArrayList<TextField>();

        Label itemNameLabel = new Label("Item Name");
        add(itemNameLabel,0,0);

        Label itemPriceLabel = new Label("Price");
        add(itemPriceLabel,3,0);

        for (int i = 0; i < currentRows; i++) {
            itemNames.add(new TextField());
            itemNames.get(i).setPrefWidth(190);
            add(itemNames.get(i),0,1+i,2,1);
            itemPrices.add(new TextField());
            itemPrices.get(i).setPrefWidth(70);
            add(itemPrices.get(i),3,1+i);
            System.out.println("i = " + i);
        }

        setVgap(5);
        setHgap(3);
    }

    public void update(int itemNum){
        int diff = itemNum - this.currentRows;
        if(diff >= 0){
            for (int i = currentRows; i < itemNum; i++) {
                itemNames.add(new TextField());
                itemNames.get(i).setPrefWidth(190);
                add(itemNames.get(i),0,1+i,2,1);
                itemPrices.add(new TextField());
                itemPrices.get(i).setPrefWidth(70);
                add(itemPrices.get(i),3,1+i);
            }
        }
        else{
            for (int i = currentRows-1; i > itemNum; i--) {
                itemNames.remove(i);
                itemPrices.remove(i);

            }
        }
        this.currentRows += diff;
    }

    public String[] getItemNames() {
        String[] names = new String[itemNames.size()];
        for (int i = 0; i < itemNames.size(); i++) {
            names[i] = itemNames.get(i).getText();
        }
        return names;
    }

    public String[] getItemPrices() {
        String[] prices = new String[itemPrices.size()];
        for (int i = 0; i < itemPrices.size(); i++) {
            prices[i] = itemPrices.get(i).getText();
        }
        return prices;
    }
}
