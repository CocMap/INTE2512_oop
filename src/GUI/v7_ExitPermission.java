package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class v7_ExitPermission extends Application {
    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v7_Exit Permission");

        // 'X' symbol on top right corner
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgramPermission();
        });

        //close button
        button = new Button("Click program");
        button.setOnAction(e -> closeProgramPermission());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        System.out.println("File is saved!");
        window.close();
    }

    private void closeProgramPermission() {
        Boolean answer = ConfirmBox.display("Exit", "Are you sure to exit");
        if(answer) {
            System.out.println("File is saved!");
            window.close();
        }
    }
}
