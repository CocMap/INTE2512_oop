package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class v6_CommunicatingBetweenWindows extends Application{

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v6_Communicating Between Windows");
        button = new Button("Click me");

        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Question", "Are you sexy :))?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 500, 300);
        window.setScene(scene);
        window.show();
    }
}
