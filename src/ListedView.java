import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
        dateCol.setCellValueFactory(new PropertyValueFactory<Receipt,String>("date"));
        TableColumn storeCol = new TableColumn("Store");
        storeCol.setCellValueFactory(new PropertyValueFactory<Receipt,String>("store"));
        TableColumn itemCol = new TableColumn("Items");
        itemCol.setCellValueFactory(new PropertyValueFactory<Receipt,String>("items"));
        TableColumn subtotalCol = new TableColumn("Subtotal");
        subtotalCol.setCellValueFactory(new PropertyValueFactory<Receipt,String>("subtotal"));
        TableColumn totalCol = new TableColumn("Total");
        totalCol.setCellValueFactory(new PropertyValueFactory<Receipt,String>("total"));
        receiptTable.getColumns().addAll(dateCol,storeCol,itemCol,subtotalCol,totalCol);

        receiptTable.setItems(FXCollections.observableArrayList(new Receipt(),new Receipt()));

        setHgap(10);
        setVgap(5);
    }

}
