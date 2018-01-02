package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//get functionality of Application from javafx
public class v1_BasicWindow extends Application {

    //create a new button
    Button button;

    public static void main(String[] args) {
        //go to Application and set up javafx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create a Stage name "Receiver"
        primaryStage.setTitle("Receiver");

        //create a button
        button = new Button();              //or button = new Button("Click me");
        button.setText("Click me");

        //set the layout and add the button to that layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        //set up the Scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
