package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class HUD implements Paintable {
    private int score;
    private boolean showStartMess = true;

    public void increaseScore(){
        score += 100;
    }
    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(Color.YELLOW);
        gc.fillText(""+score, 210,520);
        if(showStartMess){
            gc.fillText("Press space to start!",170,200 );
        }
    }
    public void invertShowStartMess(){
        showStartMess = false;
    }
}
