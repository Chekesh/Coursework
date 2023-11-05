package com.example.coursework;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Transition {
    public static void TransitionWindows(Label label, String name, double width, double height, boolean variability) throws IOException {
        label.getScene().getWindow().hide();

        FXMLLoader fxmlLoader = new FXMLLoader(Transition.class.getResource(name+".fxml"));

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(name);
        if(variability){
            stage.setMinWidth(750);
            stage.setMinHeight(550);
            System.out.println("ограничения установлены");
        }
        stage.setResizable(variability);
        stage.show();

        //label.getScene().getWindow().hide();
    }

    public static void Alert(String setHeaderText, String ContentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(setHeaderText);
        alert.setContentText(ContentText);
        alert.showAndWait();/*.ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });*/
    }





}
