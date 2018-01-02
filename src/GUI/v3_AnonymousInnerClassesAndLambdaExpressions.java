package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class v3_AnonymousInnerClassesAndLambdaExpressions extends Application { //ActionEvent = button
    //create a new button
    Button button = new Button();
    Button button2 = new Button();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //create stage name "v3_Anonymous Inner Classes And Lambda Expressions"
        primaryStage.setTitle("v3_Anonymous Inner Classes And Lambda Expressions");

        //create a button
        button = new Button("Click me");
        button2 = new Button("Click me 2");

        //---------------------Anonymous Inner Class----------
        //this class will handle the button events
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("I am an Anonymous Inner Class");
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("I am another Anonymous Inner Class");
            }
        });

        //IMPORTANT--------------------Lambada Expression---------------------
        button.setOnAction(e -> System.out.println("I am Lambada Expression"));

        //set the layout and add the button to that layout
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        //set up the Scene
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
