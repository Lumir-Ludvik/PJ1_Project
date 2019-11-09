package catapult;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.Paintable;

public class HUD implements Paintable {
    private int score;

    public void increaseScore(){
        score += 100;
    }
    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillText(""+score, 10,10);
    }
}
