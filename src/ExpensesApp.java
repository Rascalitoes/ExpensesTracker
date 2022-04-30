import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ExpensesApp extends Application {
    private ArrayList<Receipt> receipts;

    public void start(Stage stage) throws Exception {
        // Create view
        Pane p = new Pane();
        ReceiptView rView = new ReceiptView();
        p.getChildren().add(rView);

        receipts = new ArrayList<Receipt>();

        // Set window attributes
        stage.setTitle("Current Receipt");
        stage.setResizable(true);
        stage.setScene(new Scene(p));
        stage.show();

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
                        System.out.println(receipts.get(0).toString());
                    }
                }
        );

    }

    public static void main(String[] args) {
        launch(args);
    }
}
