package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication extends Application {

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Polaris");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void doLaunch(String...args) {
        Application.launch(args);
    }
}
