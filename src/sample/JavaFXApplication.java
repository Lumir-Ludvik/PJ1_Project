package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.*;
import java.lang.Integer;

public class JavaFXApplication extends Application {
    public boolean left = false;
    public boolean start = false;
    public boolean up = false;
    public boolean right = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Polaris");
        CatapultController controller = CatapultController.create();
        Scene scene = controller.createScene();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case SPACE:
                        start = !start;
                        break;
                    case LEFT:
                        left = true;
                        break;
                    case UP:
                        up = true;
                        break;
                    case RIGHT:
                        right = true;
                        break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case LEFT:
                        left = false;
                        break;
                    case UP:
                        up = false;
                        break;
                    case RIGHT:
                        right = false;
                        break;
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(x -> System.exit(0));
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (start) {
                    controller.simulation.startPressed();
                    controller.simulation.hud.invertShowStartMess();
                }
                if (left) {
                    controller.simulation.leftPressed();

                }
                if (up) {
                    controller.simulation.centerPressed();

                }
                if (right) {
                    controller.simulation.rightPressed();

                }
            }
        };
        timer.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("scorePolaris.txt")));
                    pw.println(controller.simulation.hud.getScore());
                    pw.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, "Shutdown-thread"));
    }

    public static void doLaunch(String... args) {
        Application.launch(args);
    }
}
