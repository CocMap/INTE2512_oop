package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class v12_DropDownMenu extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v12_DropDownMenu");

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
        button.setOnAction(e -> getChoice(choiceBox));

        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private static void getChoice(ChoiceBox<String> choiceBox) {
        String items = choiceBox.getValue();
        System.out.printf(items + " ");
    }
}
