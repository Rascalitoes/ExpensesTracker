import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.naming.directory.SearchControls;
import javafx.scene.control.TableColumn;

public class ListedView extends GridPane {

    public ListedView(){
        Label searchLabel = new Label("Search:");
        add(searchLabel,0,0);

        TextField searchBox = new TextField();
        add(searchBox,1,0);

        TableView<Receipt> receiptTable = new TableView<Receipt>();
        add(receiptTable,0,1,2,1);

        TableColumn dateCol = new TableColumn("Date");
        TableColumn storeCol = new TableColumn("Store");
        TableColumn itemCol = new TableColumn("Items");
        TableColumn subtotalCol = new TableColumn("Subtotal");
        TableColumn totalCol = new TableColumn("Total");
        receiptTable.getColumns().addAll(dateCol,storeCol,itemCol,subtotalCol,totalCol);



        setHgap(10);
        setVgap(5);
    }

}
