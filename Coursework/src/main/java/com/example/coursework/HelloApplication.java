package com.example.coursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Authorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 400.0);
        stage.setTitle("Authorization");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    public void openSecondindow() {
        Stage SecondStage = new Stage();

        SecondStage.setTitle("Второе окно");
    }

    public static void main(String[] args) {
        launch();
    }
}