import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

public class HomeController{

    private Scene scene;
    private Stage stage;

    @FXML
    private Label userLbl;

    public void displayname(String username){
        userLbl.setText(username);
    }

    public void logout(ActionEvent e) throws IOException{
        System.out.println("Home page to login page (logout method in home controller class)");
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switch2sceneQuiz(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Quiz.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switch2sceneQuestion(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Question.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}