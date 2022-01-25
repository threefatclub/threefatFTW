package com.example.threefatftw;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    //TODO
    // - Add Default units ✅✅✅✅✅✅✅✅✅
    // - Add Json for matrix ✅✅✅✅✅
    // - Add flags
    // - Discover Classes (styleClass)
    // - See if Caroussel effect is possible(currency, length, weight)
    // - See if background music in game possible (loopable)
    // - Add graph for both currencies

    //FIXME Fix the length/currency/weight text not fitting
    // - Fix font thingie ✅✅✅✅✅✅✅✅✅
    // - Link Backend to currency ✅✅✅✅✅✅✅✅✅
    // - Fix length matrix (problem with value order) ✅✅✅✅✅✅✅✅✅
    // - Fix System Crash (fazet terminate liveresponse popup ~possible solution is timout)
    // - Fix standalone jar

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Length.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
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