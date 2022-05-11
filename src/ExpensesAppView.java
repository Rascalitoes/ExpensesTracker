import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ExpensesAppView extends GridPane {
    Button addReceipt;

    public ExpensesAppView(){

        ListedView listedView = new ListedView();
        add(listedView,0,0,4,1);

        addReceipt = new Button("Add Receipt");
        add(addReceipt,0,1);

        HBox spacer = new HBox();
        spacer.setPrefWidth(200);
        spacer.setAlignment(Pos.CENTER);
        add(spacer,1,1);

        Label subtotalSum = new Label("Sub");
        add(subtotalSum,2,1);

        Label totalSum = new Label("total");
        add(totalSum,3,1);

        setPadding(new Insets(15, 10, 15, 10));
        setHgap(10);
        setVgap(5);
        setPrefSize(600, 300);
    }

    public Button getAddReceipt() {return addReceipt;}
}
