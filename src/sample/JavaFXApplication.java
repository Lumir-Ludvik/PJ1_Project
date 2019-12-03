package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;
import static javafx.scene.layout.BackgroundRepeat.REPEAT;
import static javafx.scene.layout.BackgroundSize.*;

import java.io.FileInputStream;

public class JavaFXApplication extends Application {

    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Polaris");
        CatapultController controller = CatapultController.create();
        primaryStage.setScene(controller.createScene());
        primaryStage.show();
        primaryStage.setOnCloseRequest(x -> System.exit(0));
    }

    public static void doLaunch(String...args) {
        Application.launch(args);
    }
}
