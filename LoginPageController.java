
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import Users.User;
public class LoginPageController {

    public enum Role {
        STUDENT, ADMIN
    }
    public Label labelSelector;
    public ChoiceBox<Role> selectorAccount;
    public Label labelEmail;
    public TextField txtFieldEmail;
    public Label labelPassword;
    public PasswordField txtFieldPassword;
    public Button btnLogin;
    public Role selectedRule;
    public Label loginMessage;

    private Scene scene;
    private Stage stage;
    private Parent root;


    public void initialize() {

        // Add roles to the ChoiceBox
        selectorAccount.getItems().addAll(Role.STUDENT, Role.ADMIN);

        // Set Admin as a default role
        selectorAccount.setValue(selectorAccount.getItems().get(1));

        // Add a listener to the ChoiceBox to handle selection changes
        selectorAccount.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // Update label or perform other actions based on the selected role
                labelSelector.setText("Selected Role: " + newValue);
                selectedRule = newValue;
            }
        });

        btnLogin.setOnMouseClicked(mouseEvent -> handleLoginButtonAction());

    }

    private void handleLoginButtonAction() {
        // Implement login functionality based on the selected role
        Role selectedRole = selectorAccount.getValue();
        String email = txtFieldEmail.getText();
        String password = txtFieldPassword.getText();


        boolean loginSuccessful = performLogin(selectedRole, email, password);


        if (loginSuccessful) {
            // Successful login logic
            loginMessage.setText("Login Successful");
            loginMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold");  // Set text color to green
        } else {
            // Failed login logic
            loginMessage.setText("Login Failed");
            loginMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold");  // Set text color to red
        }
    }

    private boolean performLogin(Role role, String email, String password) {
        // login logic here with database and regular expressions and return true if successful, false otherwise

        return User.isValidEmail(email) && User.isValidPassword(password);
    }
    public void switch2sceneHome(ActionEvent e) throws IOException{
        try{
            String username = txtFieldEmail.getText(); //this should change the label to the username or the email the user enter
    
            username = username.substring(0, username.indexOf('@'));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            root = loader.load(); //root must be here or else it wont work
            
            //creating an instance of HomeController
            HomeController scene2 = loader.getController();
            scene2.displayname(username);
    
    
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            }catch(IndexOutOfBoundsException e0){
                labelEmail.setText("Email: "+"\nCorrect email format: username@example.com");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}
