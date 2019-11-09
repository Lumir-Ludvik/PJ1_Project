package catapult;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import sample.Canvas;

import java.io.IOException;

public class CatapultController {
    @FXML
    private javafx.scene.canvas.Canvas canvas;

    public static CatapultController create() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                CatapultController.class.getResource("sample.fxml")
        );
        loader.load();
        CatapultController result = loader.getController();
        result.init();
        return result;
    }

    private void init() {
        Canvas.createCanvas(canvas);
        Canvas.getInstance().redraw();
        //simulation = new Simulation(angle.getValue(),power.getValue());
    }

    private void doBallMovement() {
        //simulation.startSimulation()
        Platform.runLater(this::restoreToInitialState);
    }

    private void restoreToInitialState(){
        //simulator.restore();
    }
}
