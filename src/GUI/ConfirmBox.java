package GUI;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {

    static boolean answer;


    public static boolean display(String title, String message) {
        Stage popupWindow = new Stage();

        //block event from other windows
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle(title);
        popupWindow.setWidth(250);

        Label label = new Label();
        label.setText(message);

        //create two button
        Button yesButton = new Button("yes");
        Button noButton = new Button("no");

        yesButton.setOnAction(e -> {
            answer = true;
            popupWindow.close();
        });


        noButton.setOnAction(e -> {
            answer = false;
            popupWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        popupWindow.setScene(scene);
        popupWindow.showAndWait();

        return answer;
    }
}
