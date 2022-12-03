package com.saho.minor_1_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LogisticsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LogisticsApplication.class.getResource("HomeView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1094, 500);
        stage.setTitle("Logistics Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
