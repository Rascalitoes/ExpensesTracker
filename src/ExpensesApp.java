import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExpensesApp extends Application {
    private ArrayList<Receipt> receipts;
    private int currReceipt;

    public void start(Stage stage) throws Exception {
//        new ReceiptViewController();
        new ExpensesAppViewController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
