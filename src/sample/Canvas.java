package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.LinkedList;
import java.util.List;

public class Canvas implements Boundary {
    private static Canvas instance;
    private javafx.scene.canvas.Canvas canvas;
    private List<Paintable> entities = new LinkedList<>();

    private Canvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
    }

     public static void createCanvas(javafx.scene.canvas.Canvas canvas) {
        if (instance == null) {
            instance = new Canvas(canvas);
        }
    }

    public void addEntities(Paintable entity) {
        entities.add(entity);
    }

    public void redraw(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Paint paint = gc.getFill();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setFill(paint);
        for (Paintable entity: entities) {
            entity.paint(gc);
        }
    }

    public static Canvas getInstance() {
        if (instance == null) {
            JavaFXApplication.doLaunch();
        }
        return instance;
    }

    public double getHeight() {
        return canvas.getHeight();
    }

    @Override
    public double getXOfCorner() {
        return getWidth();
    }

    @Override
    public double getYOfCorner() {
        return getHeight();
    }

    public double getWidth() {
        return canvas.getWidth();
    }
}
