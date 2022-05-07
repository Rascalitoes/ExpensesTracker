import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ReceiptViewController extends Stage {
    private ArrayList<Receipt> receipts;
    private int currReceipt;

    ReceiptViewController(){
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
                        rView.update(3);
                    }
                }
        );

        rView.getSubmit().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        receipts.add(new Receipt(rView.getItems().getItemNames()));
                        System.out.println(receipts.get(currReceipt).toString());
                    }
                }
        );

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
    }

}
