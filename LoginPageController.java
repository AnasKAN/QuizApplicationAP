package quizzey.quizzey.LoginPage;

import javafx.scene.control.*;
import quizzey.quizzey.Users.User;

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
}
