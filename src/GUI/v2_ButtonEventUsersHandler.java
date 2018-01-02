package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//get functionality of Application from javafx
public class v2_ButtonEventUsersHandler extends Application implements EventHandler<ActionEvent> {
    Button button;
    Button button2;

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
        //'this' -> handle method
        button.setOnAction(this);

        //create a button2
        button2 = new Button("Click me 2");
        button2.setOnAction(this);

        //set the layout and add the button to that layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.getChildren().add(button2);

        //set up the Scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //click button to call an event -> handle method
    @Override
    public void handle(ActionEvent event) {
        //identify source from 'button'
        if(event.getSource() == button) {
            System.out.println("I love you");
        }

        if(event.getSource() == button2) {
            System.out.println("I love you too ^^");
        }
    }
}
