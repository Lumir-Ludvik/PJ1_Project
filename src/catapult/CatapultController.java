package catapult;

import commons.Constants;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;;
import sample.Canvas;

import java.io.IOException;

public class CatapultController {
    @FXML
    private javafx.scene.canvas.Canvas canvas;

    @FXML
    private BorderPane root;

    @FXML
    private Slider power;

    @FXML
    private Slider angle;

    @FXML
    private Button fire;
    private Simulation simulation;

    public static CatapultController create() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                CatapultController.class.getResource("sample.fxml"));
        loader.load();
        CatapultController result = loader.getController();
        result.init();
        return result;
    }

    private  void init() {
        Canvas.createCanvas(canvas);
        Canvas.getInstance().redraw();
        simulation = new Simulation(45, Constants.POWER, 0,0);
    }
    public Scene createScene(){
        return new Scene(root,450,540);
    }
    private void doBallMovement() {
        simulation.startSimulation();
        Platform.runLater(this::restoreToInitialState);
    }

    private void restoreToInitialState(){
        simulation.restore();
    }
}
