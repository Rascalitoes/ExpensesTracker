import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExpensesAppViewController extends Stage {

    ExpensesAppViewController(){
        Pane p = new Pane();
        ExpensesAppView mainView = new ExpensesAppView();
        p.getChildren().add(mainView);

        mainView.getAddReceipt().setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        new ReceiptViewController();
                    }
                }
        );

        this.setTitle("All Receipts");
        this.setResizable(true);
        this.setScene(new Scene(p));
        this.show();
    }

}
