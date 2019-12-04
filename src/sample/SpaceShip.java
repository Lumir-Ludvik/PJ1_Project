package sample;

import commons.Constants;
import commons.ProcessRoutines;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public class SpaceShip implements Paintable, Boundary {
    private int x;
    private int y;
    private int widthCanvas;
    private int heightCanvas;
    private boolean direction;

    public SpaceShip(int widthCanvas, int heightCanvas) {
        this.widthCanvas = widthCanvas;
        this.heightCanvas = heightCanvas;
        createSpaceShip();
    }

    public void createSpaceShip() {
        Random random = new Random();
        y = random.nextInt( heightCanvas/100*40);
        int chance = random.nextInt(100);
        if(chance < 50) {
            x = 0;
            direction = true;
        } else {
            x = widthCanvas-50;
            direction = false;
        }
    }

    public void moveSpaceShip(){
        if(direction){
            x++;
        } else {
            x--;
        }
    }

    public void hit() {
       createSpaceShip();
    }

    @Override
    public double getXOfCorner() {
        return x;
    }

    @Override
    public double getYOfCorner() {
        return y;
    }

    @Override
    public double getWidth() {
        return 50;
    }

    @Override
    public double getHeight() {
        return 20;
    }

    @Override
    public void paint(GraphicsContext gc) {
        if(!direction){
            gc.drawImage(Constants.SPACESHIP, x, y, 50, 20);
        } else {
            gc.drawImage(Constants.SPACESHIP, x, y, -50, 20);
        }

    }
}
