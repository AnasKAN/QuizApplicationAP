
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AdminController{
    private Statement stmt;
    private Scene scene;
    private Stage stage;
    public static Connection connection;

    @FXML
    private Button addbtn;

    @FXML
    private TextField addvaluetxtfield;

    @FXML
    private Button initializebtn;

    @FXML
    private Button logoutbtn;

    @FXML
    private TextField querytxtfield;

    @FXML
    private Label resultlbl;

    @FXML
    private Label addlbl;
    @FXML
    private Label querylbl;

    @FXML
    private Button submitbtn;

public AdminController(){
    initializeDB();
}
public void add(){
    try {
        //create a statement that will be used to execute the inserted command
        //#################################################
        //SOMEONE PLEASE DO INPUT VALIDATION SUCH THAT THE TEXTFIELD addvaluetxtfield CANNOT BE SUBMITTED IF IT IS WRONG SQL COMMAND OR EMPTY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //#################################################
        stmt = connection.createStatement();
        stmt.execute(addvaluetxtfield.getText());
        //changing the result label to the result of the add statement if successful
        resultlbl.setText("idk i would love to know how to change the label to the result");
        stmt.close();
    } catch (SQLException e) {
        resultlbl.setText("SQL ADD COMMAND MUST BE WRITTEN LIKE:\nINSERT INTO TABLE_NAME VALUES(VAL1,VAL2,...)");
        System.out.println("SQL ADD COMMAND MUST BE WRITTEN LIKE:\nINSERT INTO TABLE_NAME VALUES(VAL1,VAL2,...)");
        e.printStackTrace();
    }

}
public void query(){
    try {
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(querytxtfield.getText());
        while(rs.next()){
            String name = rs.getString("");
            System.out.println(name);
        }
        //changing the result label to the result of the query
        resultlbl.setText(rs.getString(""));
        stmt.close();
    } catch (SQLException e) {
        resultlbl.setText("SQL QUERY COMMAND MUST BE WRITTEN LIKE:\nSELECT FROM TABLE1, TABLE2,... WHERE...\nNOTE: GO REVISE SOME REFERENCE TO KNOW HOW QUERIES ARE WRITTEN");
        System.out.println("SQL QUERY COMMAND MUST BE WRITTEN LIKE:\nSELECT FROM TABLE1, TABLE2,... WHERE...\nNOTE: GO REVISE SOME REFERENCE TO KNOW HOW QUERIES ARE WRITTEN");
        e.printStackTrace();
    }

}
public void initializeDB() {
    try {
        //1 Load the JDBC driver
        System.out.println("joined the admin page~");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");

        //2 Establish a connection
        connection = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/Quizzey", "root", "6831");
        //  "root", "6831"
        System.out.println("Database connected");
    }
    catch (Exception ex) {
        ex.printStackTrace();
    }
}
public void logout(ActionEvent e) throws IOException{
        System.out.println("Admin page to login page (logout method in admin controller class)");
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}