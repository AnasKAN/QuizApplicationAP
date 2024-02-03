import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;

import Users.User;

public class LoginPageController {

    public enum Role {
        TEACHER, STUDENT, ADMIN
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
    public static String fxml;

    public void initialize() {

        // Add roles to the ChoiceBox
        selectorAccount.getItems().addAll(Role.TEACHER, Role.STUDENT, Role.ADMIN);

        // Set Admin as a default role
        selectorAccount.setValue(selectorAccount.getItems().get(2));

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
        System.out.println(selectedRole);

        boolean loginSuccessful = performLogin(selectedRole, email, password);


        if (loginSuccessful && selectedRole.equals("Admin")) {
            // Successful login logic to admin
            System.out.println("login page to admin page (handle login action method in login page controller class)");
            loginMessage.setText("Login Successful");
            loginMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold");  // Set text color to green

        }else if(loginSuccessful && selectedRole.equals("Student")){
            System.out.println("login page to home page as a student(handle login action method in login page controller class)");
            loginMessage.setText("Login Successful");
            loginMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold");  // Set text color to green
        }else if(loginSuccessful && selectedRole.equals("Teacher")){
            System.out.println("login page to home page as a teacher(handle login action method in login page controller class)");
            loginMessage.setText("Login Successful");
            loginMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold");  // Set text color to green
            
        } else {
            // Failed login logic
            System.out.println("failed to login");
            loginMessage.setText("Login Failed");
            loginMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold");  // Set text color to red
            
        }
    }

    private boolean performLogin(Role role, String email, String password) {
        // login logic here with database and regular expressions and return true if successful, false otherwise
        Boolean test = dbLogin();
        System.out.println("enter perform login");
        if(User.isValidEmail(email) && User.isValidPassword(password)){
            return test;

        }
        else{
            return test;
        }

        
    }

    public boolean dbLogin(){
        System.out.println("Enter Login");
        DataBase dbc = new DataBase();
        Connection connectdb = dbc.getConnection();
        String email = txtFieldEmail.getText();
        String password = txtFieldPassword.getText();

        String valid = "select count(1) From students where email ='" +email+ "' AND password ='"+ password+ "'"; 
        // "select count(1) From students where email = ' "+  email  +"' AND password = ' "+ password +"' ;";
        try {
            Statement statement = connectdb.createStatement();
            ResultSet queryResult = statement.executeQuery(valid);

            while(queryResult.next()){
                System.out.println(email);
                System.out.println(password);
                System.out.println("the query result = "+ queryResult.getInt(1));
                if(queryResult.getInt(1)==1){
                    System.out.println("logged in");
                    return true;
                }
                else{
                    System.out.println("not logged in");
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;

    }


    public void changeScene(ActionEvent e) throws IOException{
        if (dbLogin()){
        try{

            System.out.println("changescene method used in the class login page");
            String username = txtFieldEmail.getText(); //this should change the label to the username or the email the user enter
            username = username.substring(0, username.indexOf('@'));
            String role = selectorAccount.getValue().toString();

            if(role.equals("ADMIN")){
                System.out.println("Admin page loading");
                fxml="AdminDB.fxml";
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                root = loader.load(); //root must be here or else it wont work

                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if(role.equals("STUDENT")){
                System.out.println("Student page loading");
                fxml="HomeScreen.fxml";
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                root = loader.load(); //root must be here or else it wont work
                //creating an instance of HomeController
                HomeController scene2 = loader.getController();
                scene2.displayname(username);
                
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if(role.equals("TEACHER")){
                System.out.println("Teacher page loading");
                fxml="HomeScreen.fxml";

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                root = loader.load(); //root must be here or else it wont work
                //creating an instance of HomeController
                HomeController scene2 = loader.getController();
                scene2.displayname(username);
                
                stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else{  
                System.out.println("no role has been chosen");
            }
            }catch(IndexOutOfBoundsException e0){
                labelEmail.setText("Email: "+"\nCorrect email format: username@example.com");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        else{
            System.out.println("Error");
        }
    }
}