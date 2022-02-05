package com.example.threefatftw;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    //TODO
    // - Add flags
    // - Discover Classes (styleClass)
    // - See if Carousel effect is possible(currency, length, weight)
    // - See if background music in game possible (loop-able)
    // - Add graph for both currencies

    //FIXME Fix the length/currency/weight text not fitting
    // - Fix System Crash (fazet terminate liveresponse popup ~possible solution is timeout)
    // - Fix standalone jar

    @Override
    public void start(Stage stage) throws IOException {
        HelloController.selectedMode="length";

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Length.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
/*
        HelloController controller = fxmlLoader.getController();
        scene.setOnKeyPressed(event -> {
            System.out.println(event.getCode()+"///"+HelloController.selectedMode);
        });*/


        scene.getStylesheets().add("switchtolength.css");

        scene.getStylesheets().add("style.css");
        //stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String...args) {
        launch();
    }
}
// https://stackoverflow.com/questions/34036207/javafx-could-not-load-font-face-font-because-of-com-sun-javafx-css-stylemanager
//
//