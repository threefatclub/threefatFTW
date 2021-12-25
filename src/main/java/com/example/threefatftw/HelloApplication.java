package com.example.threefatftw;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    //TODO
    // - Add Default units ✅✅✅✅✅✅✅✅✅
    // - Add Json for matrix ✅✅✅✅✅
    // - Add dark theme
    // - Add flags
    // - Discover Classes (styleClass)

    //FIXME Fix the length/currency/weight text not fitting
    // - Fix font thingie ✅✅✅✅✅✅✅✅✅
    // - Link Backend to currency ✅✅✅✅✅✅✅✅✅
    // - Fix length matrix (problem with value order) ✅✅✅✅✅✅✅✅✅

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("length.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("switchtolength.css");

        scene.getStylesheets().add("style.css");
        //stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}