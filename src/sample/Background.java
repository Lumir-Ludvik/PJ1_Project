package sample;

import commons.Constants;
import javafx.scene.canvas.GraphicsContext;

public class Background implements Paintable {
    @Override
    public void paint(GraphicsContext gc) {
        gc.drawImage(Constants.BACKGROUND, 0, 0);
    }
}
