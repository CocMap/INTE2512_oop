package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class v13_ListeningForSelectionChange extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v13_ListeningForSelectionChange");

        //dropdown list
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        //get items returns the Observable objects which you can add items to
        String[] fruit = {"Apple", "Banana", "Strawberry", "Orange"};
        for(int i = 0; i < fruit.length; i++)
            choiceBox.getItems().add(fruit[i]);
        //set default value
        choiceBox.setValue(fruit[0]);

        //button
        Button button = new Button("add me");

        //listen for selection changes
        choiceBox.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> System.out.println(newValue));

        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }
}
