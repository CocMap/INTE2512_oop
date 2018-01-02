package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class v9_GridPane extends Application {
    //create Stage
    Stage window = new Stage();

    //main program
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v9_GridPane");

        //layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);                        //set vertical spacing
        grid.setHgap(10);                       //set horizontal spacing

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

        //button Login
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, namePassword, nameInputPassWord, loginButton, validUsername);

        Scene scene = new Scene(grid, 320, 120);
        window.setScene(scene);
        window.show();
    }
}
