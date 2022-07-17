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
    private Receipt receipt;
    private String insertOrUpdate;
//    private ArrayList<Receipt> receipts;
//    private int currReceipt;

    ReceiptViewController(Connection c, Receipt r){
        Pane p = new Pane();
        receipt = r;
        ReceiptView rView = new ReceiptView(receipt);
        p.getChildren().add(rView);
        insertOrUpdate = "insert";
        if(receipt != null){
            insertOrUpdate = "update";
        }

        this.setTitle("Current Receipt");
        this.setResizable(true);
        this.setScene(new Scene(p));
        this.show();

        rView.getAdd1Row().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        //Need to change this
                        rView.update(receipt,receipt.itemCount()+1);
                    }
                }
        );

        rView.getMonthDropdown().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        receipt.setMonth(rView.getMonthDropdown().getSelectionModel().getSelectedIndex()+1);
                        rView.updateDate(receipt);
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
                            receipt.setDay(rView.getDayDropdown().getSelectionModel().getSelectedIndex()+1);
                        }

                    }
                }
        );

        rView.getYearDropdown().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        receipt.setYear(
                                Integer.parseInt(rView.getYearDropdown().getSelectionModel()
                                        .getSelectedItem().toString())
                        );
                        rView.updateDate(receipt);
                    }
                }
        );

        rView.getSubmit().setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent actionEvent) {
                    receipt.setItems(rView.getItems());

                    System.out.println("items rn: " + receipt.toString());
                    PreparedStatement pst;
                    try {
                        pst = c.prepareStatement( "insert into receipts(date,store,subtotal,total,tax,card) values(?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                        pst.setString(1, receipt.getDate().toString());
                        pst.setInt(2, receipt.getStoreID());
                        pst.setBigDecimal(3, receipt.getSubtotal());
                        pst.setBigDecimal(4, receipt.getTotal());
                        pst.setBigDecimal(5, receipt.getTax());
                        pst.setInt(6, receipt.getCardID());
                        pst.executeUpdate();
                        ResultSet rs = pst.getGeneratedKeys();
                        System.out.println(rs.getInt(1));

//                        pst = c.prepareStatement(insertOrUpdate + " into items(receiptID,name,price) values(?,?,?)");
//                        pst.setInt(1,1);
//                        pst.setString(2, receipt.getItems()[0].getName());
//                        pst.setBigDecimal(3,receipt.getItems()[0].getAmount());
//                        pst.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
//                    } finally {
//                        try {
//                            if(c != null){
//                                c.close();
//                            }
//                        }
//                        catch(SQLException e) {
//                            e.printStackTrace();
//                        }
                    }
                    close();
                }
            }
        );
    }

}
