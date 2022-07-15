import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.naming.directory.SearchControls;
import javafx.scene.control.TableColumn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListedView extends GridPane {
    TableView<Receipt> receiptTable;

    public ListedView(Connection c){
        ArrayList<Receipt> receiptArrayList = new ArrayList<Receipt>();

        Label searchLabel = new Label("Search:");
        add(searchLabel,0,0);

        TextField searchBox = new TextField();
        add(searchBox,1,0);

        receiptTable = new TableView<Receipt>();
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

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("select * from receipts");
            while(rs.next()){
                receiptArrayList.add(new Receipt(rs.getString("date"), rs.getString("store"), rs.getBigDecimal("subtotal"), rs.getBigDecimal("total"), rs.getBigDecimal("tax")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        receiptTable.setItems(FXCollections.observableArrayList(receiptArrayList));


        setHgap(10);
        setVgap(5);
    }

    public TableView<Receipt> getListModel() {return receiptTable;}

}
