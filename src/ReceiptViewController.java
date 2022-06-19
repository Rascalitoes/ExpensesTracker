import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ReceiptViewController extends Stage {
    private ArrayList<Receipt> receipts;
    private int currReceipt;

    ReceiptViewController(Connection c){
        Pane p = new Pane();
        ReceiptView rView = new ReceiptView();
        p.getChildren().add(rView);

        receipts = new ArrayList<Receipt>();
        receipts.add(new Receipt(rView.getItems().getItemNames()));
        currReceipt = 0;

        this.setTitle("Current Receipt");
        this.setResizable(true);
        this.setScene(new Scene(p));
        this.show();

        rView.getAdd1Row().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        rView.update(rView.getItemRows()+1);
                    }
                }
        );

//        rView.getSubmit().setOnAction(
//                new EventHandler<ActionEvent>() {
//                    public void handle(ActionEvent actionEvent) {
//                        receipts.add(new Receipt(rView.getItems().getItemNames()));
//                        System.out.println(receipts.get(currReceipt).toString());
//                    }
//                }
//        );

        rView.getMonthDropdown().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        receipts.get(currReceipt).setMonth(
                                rView.getMonthDropdown().getSelectionModel().getSelectedIndex()+1
                        );
                        rView.updateDate(receipts.get(currReceipt));
                    }
                }
        );

        /* Changing the range of the days counts as an action. It causes this block to trigger
         * when the list resets and its length is 0. To prevent this, we check for selected index
         * of -1 to prevent running invalid code on the 0th of a month (rather than 1st to 28-31st).
         */
        rView.getDayDropdown().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        if(rView.getDayDropdown().getSelectionModel().getSelectedIndex() != -1){
                            receipts.get(currReceipt).setDay(
                                    rView.getDayDropdown().getSelectionModel().getSelectedIndex()+1
                            );
                        }

                    }
                }
        );

        rView.getYearDropdown().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        receipts.get(currReceipt).setYear(
                                Integer.parseInt(rView.getYearDropdown().getSelectionModel()
                                        .getSelectedItem().toString())
                        );
                        rView.updateDate(receipts.get(currReceipt));
                    }
                }
        );

        rView.getSubmit().setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    receipts.get(currReceipt).setItems(rView.getItems().getItems());
                    System.out.println("items rn: " + receipts.get(currReceipt).toString());
                    Statement statement = null;
                    PreparedStatement pst;
                    try {
                        statement = c.createStatement();
                        statement.setQueryTimeout(30);  // set timeout to 30 sec.

                        statement.addBatch("create table if not exists receipts " +
                                "(id integer primary key autoincrement not null," +
                                "date text)");
                        statement.addBatch("create table if not exists items (receiptID integer," +
                                "name text, price numeric)");
                        statement.executeBatch();

                        pst = c.prepareStatement("insert into receipts(date) values(?)");
                        pst.setString(1, receipts.get(currReceipt).getDate().toString());
                        pst.executeUpdate();

                        pst = c.prepareStatement("insert into items(receiptID,name,price) values(?,?,?)");
                        pst.setInt(1,1);
                        pst.setString(2, receipts.get(currReceipt).getItems()[0].getKey());
                        pst.setBigDecimal(3,receipts.get(currReceipt).getItems()[0].getValue());
                        pst.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if(statement != null){
                                statement.close();
                            }
                            if(c != null){
                                c.close();
                            }
                        }
                        catch(SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        );
    }

}
