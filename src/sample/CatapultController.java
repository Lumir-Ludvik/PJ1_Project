package sample;

import commons.Constants;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;;

import java.io.IOException;

public class CatapultController {
    @FXML
    private javafx.scene.canvas.Canvas canvas;

    @FXML
    private BorderPane root;

    public Simulation simulation;


    public static CatapultController create() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                CatapultController.class.getResource("sample.fxml"));
        loader.load();
        CatapultController result = loader.getController();
        result.init();
        return result;
    }

    private void init() {
        Canvas.createCanvas(canvas);
        simulation = new Simulation();
        Canvas.getInstance().redraw();
    }

    public Scene createScene() {
        return new Scene(root, 450, 540);
    }



    private void doBallMovement() {
        simulation.startSimulation();
        Platform.runLater(this::restoreToInitialState);
    }

    private void restoreToInitialState() {
        simulation.restore();
    }
}
