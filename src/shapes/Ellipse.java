package shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.Paintable;


public class Ellipse implements Paintable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	public Ellipse(int xPos, int yPos, int width, int height, Color color) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}

	@Override
	public void paint(GraphicsContext gc) {
		gc.setFill(color);
		gc.setStroke(color);
		gc.fillOval(xPos, yPos, width, height);
	}
	
}
