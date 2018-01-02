package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class v10_ExtractAndValidInput extends Application {
    Stage window = new Stage();
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v10_Extract And Valid Input");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //name label Username
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel, 0, 0);       //appear in the top left

        //name textfield Input Username
        TextField nameInput = new TextField("Enter username");
        GridPane.setConstraints(nameInput, 1, 0);

        //name label Password
        Label namePassword = new Label("Password");
        GridPane.setConstraints(namePassword, 0, 1);

        //name textfield Input Password
        TextField nameInputPassWord = new TextField();
        nameInputPassWord.setPromptText("Enter your password");
        GridPane.setConstraints(nameInputPassWord, 1, 1);

        //check valid username
        Button validUsername = new Button("Check");
        GridPane.setConstraints(validUsername, 3, 0);
        validUsername.setOnAction(e -> {
            isInt(nameInput, nameInput.getText());
        });

        //button Login
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        gridPane.getChildren().addAll(nameLabel, nameInput, namePassword, nameInputPassWord, loginButton, validUsername);

        Scene scene = new Scene(gridPane, 320, 120);


        window.setScene(scene);
        window.show();
    }

    private static boolean isInt(TextField nameInput, String message) {
        try {
            int age = Integer.parseInt(nameInput.getText());
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a number");
            return false;
        }
    }
}
