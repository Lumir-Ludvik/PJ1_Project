package sample;

import javafx.application.Application;
import javafx.stage.Stage;

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
