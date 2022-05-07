import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ExpensesAppView extends GridPane {

    public ExpensesAppView(){

        setPadding(new Insets(15, 10, 15, 10));
        setHgap(10);
        setVgap(5);
        setPrefSize(600, 300);
    }

}
