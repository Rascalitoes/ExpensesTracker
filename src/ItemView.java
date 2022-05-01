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
        }

        setVgap(5);
        setHgap(3);
    }

    // There's no way to 'unadd' items to the pane :(
    public void addRows(int itemNum){
        for (int i = currentRows; i < currentRows+itemNum; i++) {
            itemNames.add(new TextField());
            itemNames.get(i).setPrefWidth(190);
            add(itemNames.get(i),0,1+i,2,1);
            itemPrices.add(new TextField());
            itemPrices.get(i).setPrefWidth(70);
            add(itemPrices.get(i),3,1+i);
        }
        this.currentRows += itemNum;
    }

    public String[] getItemNames() {
        // String[] only returns the textfields that have been filled in
        int validText = 0;
        for (TextField t: itemNames) {
            if(t.getText().length() > 0){
                validText++;
            }
        }
        String[] names = new String[validText];
        for (int i = 0; i < validText; i++) {
            if(itemNames.get(i).getText().length() > 0){
                names[i] = itemNames.get(i).getText();
            }
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
