import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class ReceiptView extends GridPane {
    int rowCount;
    ItemView [] itemViews;
    Button submit, add1MoreRows;
    ScrollPane itemsContainer;
    ItemView items;

    public ReceiptView(){
        rowCount = 5;
        itemViews = new ItemView[rowCount];

        Label storeLabel = new Label("Store Name:");
        add(storeLabel,0,0);

        Label monthLabel = new Label("Month");
        add(monthLabel,0,1);

        Label dateLabel = new Label("Date");
        add(dateLabel,1,1);

        Label yearLabel = new Label("Year");
        add(yearLabel,2,1);

        TextField storeName = new TextField();
        add(storeName,1,0,3,1);

        ComboBox monthDropdown = new ComboBox(FXCollections.observableArrayList("January,February,March,April,May,June,July,August,September,October,November,December".split(",")));
        add(monthDropdown,0,2);

        ComboBox dateDropdown = new ComboBox(FXCollections.observableArrayList("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31".split(",")));
        add(dateDropdown,1,2);

        ComboBox yearDropdown = new ComboBox(FXCollections.observableArrayList("2022,2021,2020,2019,2018,2017,2016,2015".split(",")));
        add(yearDropdown,2,2);

        Separator separator = new Separator();
        add(separator,0,3,4,1);

        /**************************************/

        itemsContainer = new ScrollPane();
        items = new ItemView(rowCount);
        itemsContainer.setContent(items);
        itemsContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        itemsContainer.prefWidth(300);
        itemsContainer.setFitToWidth(true);
        add(itemsContainer,0,5,3,1);

        add1MoreRows = new Button("+1 Row");
        add1MoreRows.setPrefWidth(300);
        add(add1MoreRows,0, rowCount +5,3,1);

        separator = new Separator();
        add(separator,0, rowCount +6,3,1);

        /**************************************/

        Label subtotalLabel = new Label("Subtotal:");
        setHalignment(subtotalLabel, HPos.RIGHT);
        add(subtotalLabel,1, rowCount +7);

        Label totalLabel = new Label("Total:");
        setHalignment(totalLabel, HPos.RIGHT);
        add(totalLabel,1, rowCount +8);

        TextField subtotal = new TextField();
        subtotal.setPrefWidth(30);
        add(subtotal,2, rowCount +7);

        TextField total = new TextField();
        total.setPrefWidth(30);
        add(total,2, rowCount +8);

        submit = new Button("Save");
        setHalignment(submit,HPos.RIGHT);
        add(submit,0, rowCount +9,3,1);

        Label cardLabel = new Label("Card #");
        add(cardLabel,0, rowCount +7);

        ComboBox cards = new ComboBox(FXCollections.observableArrayList("1234,5678".split(",")));
        add(cards,0, rowCount +8);

        setPadding(new Insets(15, 10, 15, 10));
        setHgap(10);
        setVgap(5);
        int height = rowCount *30 + 270;
        setPrefSize(300, height);
    }

    public void update(int rowCount){
        if(rowCount > this.rowCount){
            items.addRows(rowCount-this.rowCount);
        }
        else{
            items = new ItemView(rowCount);
        }
        this.rowCount = rowCount;
        itemsContainer.setContent(items);
    }

    public Button getSubmit() {return submit;}
    public Button getAdd1Row() {return add1MoreRows;}
    public ItemView getItems() {
        return items;
    }
}
