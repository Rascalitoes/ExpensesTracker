import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.sqlite.javax.SQLitePooledConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ExpensesApp extends Application {
    private ArrayList<Receipt> receipts;
    private int currReceipt;

    public void start(Stage stage) throws Exception {
//        new ReceiptViewController();

        Connection c = null;
        try
        {
            // create a database connection
            c = DriverManager.getConnection("jdbc:sqlite:expenses.db");
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        new ExpensesAppViewController(c);
//        finally
//        {
//            try
//            {
//                if(c != null)
//                    c.close();
//            }
//            catch(SQLException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
