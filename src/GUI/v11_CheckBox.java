package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class v11_CheckBox extends Application {
    //create Stage
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("v11_CheckBox");

        //checkbox
        CheckBox box0 = new CheckBox("Rice");
        CheckBox box1 = new CheckBox("Chicken");
        CheckBox box2 = new CheckBox("Pork");
        CheckBox box3 = new CheckBox("Tuna");

        box0.setSelected(true);

        //button
        Button button = new Button("Order now!");
        button.setOnAction(e -> {
           handleOptions(box0, box1, box2, box3);
        });


        //layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(box0, box1, box2, box3, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private static void handleOptions(CheckBox box0, CheckBox box1, CheckBox box2, CheckBox box3){
        String message = "";

        if(box0.isSelected())
            message += box0.getText() + "\n";

        if(box1.isSelected())
            message += box1.getText() + "\n";

        if(box2.isSelected())
            message += box2.getText() + "\n";

        if(box3.isSelected())
            message += box3.getText() + "\n";

        System.out.println("User order: \n" + message);
    }
}
