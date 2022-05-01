import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Testing extends Application {

    public void start(Stage stage) throws Exception {
        ExpensesApp e = new ExpensesApp();
        e.start(stage);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        launch(args);
    }
}
