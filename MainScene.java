import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScene extends Application{
    public static int condition=0;//to change between windows
    public static boolean open=true;//to make the app open or close
    private Stage primaryStage;
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException{
        this.primaryStage = primaryStage;
        changeScene("LoginPage.fxml");

        primaryStage.setTitle("Quizzy");
        primaryStage.show();
}

    public void changeScene(String fxml){
        Parent pane;
        try {
            pane = FXMLLoader.load(getClass().getResource(fxml));
            primaryStage.setScene(new Scene(pane));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}