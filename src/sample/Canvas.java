package sample;

public class Canvas {
    private static Canvas instatce;
    private javafx.scene.canvas.Canvas canvas;

    private Canvas(javafx.scene.canvas.Canvas canvas){
        this.canvas = canvas;
    }

    public static synchronized Canvas getInstance() {
        if (instatce == null) {
            JavaFXApplication.doLaunch();
        }
        return instatce;
    }

     static synchronized void createCanvas(javafx.scene.canvas.Canvas canvas) {
        if(instatce == null) {
            instatce = new Canvas(canvas);
            Canvas.class.notifyAll();
        }
     }
}
