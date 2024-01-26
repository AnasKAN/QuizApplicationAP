import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MainSceneController{

    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private TextField field_email;

    //when the login button is pressed send information to the database
    @FXML        
    void btnonclick(ActionEvent e){ 
        System.out.println(MainScene.condition);

        MainScene.open = true;
        MainScene.condition = 1; //change the window
        System.out.println(MainScene.condition);

    }

    public void switch2sceneHome(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switch2sceneLogin(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}