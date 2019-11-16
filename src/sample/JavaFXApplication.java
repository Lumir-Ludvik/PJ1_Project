package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
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
        Pane p = new HBox();
        p.setPadding(new javafx.geometry.Insets(5,5,5,5));
        /*Image image = new Image(JavaFXApplication.class.getResourceAsStream("polarisBackground.png"));
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);*/
        p.setBackground(new Background(new BackgroundImage(new Image(JavaFXApplication.class.getResourceAsStream("polarisBackground.png")), REPEAT, NO_REPEAT, CENTER, DEFAULT)));
        primaryStage.show();
        primaryStage.setOnCloseRequest(x -> System.exit(0));
    }

    public static void doLaunch(String...args) {
        Application.launch(args);
    }
}
