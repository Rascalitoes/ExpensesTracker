import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

public class ExpensesAppViewController extends Stage {

    ExpensesAppViewController(Connection connection){
        Pane p = new Pane();
        ExpensesAppView mainView = new ExpensesAppView(connection);
        p.getChildren().add(mainView);

        mainView.getAddReceipt().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        new ReceiptViewController(connection, new Receipt());
                    }
                }
        );

        mainView.getListView().setOnMouseClicked(
                new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent mouseEvent) {
                        if (mouseEvent.getClickCount() == 2) {
                            new ReceiptViewController(connection, mainView.getListView().getSelectionModel().getSelectedItem());
                        }

                    }
                }
        );


        this.setTitle("All Receipts");
        this.setResizable(true);
        this.setScene(new Scene(p));
        this.show();
    }

}
