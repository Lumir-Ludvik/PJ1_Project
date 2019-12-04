package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.LinkedList;
import java.util.List;

public class Canvas {
    private static Canvas instance;
    private javafx.scene.canvas.Canvas canvas;
    private List<Paintable> entities = new LinkedList<>();

    private Canvas(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
    }

    public static synchronized void createCanvas(javafx.scene.canvas.Canvas canvas) {
        if (instance != null) {
            throw new IllegalStateException("Canvas already created");
        }
        instance = new Canvas(canvas);
        Canvas.class.notifyAll();
    }

    public void addEntities(Paintable entity) {
        entities.add(entity);
    }

    public void redraw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Paint paint = gc.getFill();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(paint);
        for (Paintable entity : entities) {
            entity.paint(gc);
        }
    }

    public synchronized static Canvas getInstance() {
        if (instance == null) {
            new Thread(JavaFXApplication::doLaunch).start();
            while (instance == null) {
                try {
                    Canvas.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    public double getHeight() {
        return canvas.getHeight();
    }


    public double getWidth() {
        return canvas.getWidth();
    }
}
