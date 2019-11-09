package shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.Boundary;
import sample.Paintable;


/**
 * Graphical representation of a ball. It also contains logic for a movement and
 * an acceleration.
 * 
 * @author koz01
 *
 */
public class Ball implements Paintable, Boundary {

	private double x;
	private double y;
	private double xVelocity;
	private double yVelocity;

	private final Ellipse shape;
	private int radius;

	public Ball(int x, int y, int radius) {
		super();
		this.x = x;
		this.y = y;
		this.shape = new Ellipse(x - radius, y - radius, radius * 2, radius * 2, Color.BLUEVIOLET);
		this.radius = radius;
	}

	public void accelerate(double xAcc, double yAcc, double difTime) {
		xVelocity += xAcc * difTime;
		yVelocity += yAcc * difTime;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void move(double time) {
		x += xVelocity * time;
		y += yVelocity * time;
		setShapePosition();
		
	}

	@Override
	public void paint(GraphicsContext gc) {
		shape.paint(gc);
	}

	/**
	 * It makes x dimension of space infinite
	 * 
	 * @param canvasWidth
	 */
	public void fixXCoordinate(int canvasWidth) {
		x = (x + canvasWidth) % canvasWidth;
	}

	public void stopAndMoveTo(int newX, int newY) {
		xVelocity = 0;
		yVelocity = 0;
		this.x = newX;
		this.y = newY;
		setShapePosition();
	}

	private void setShapePosition() {
		shape.setPosition((int) x - radius, (int) y - radius);
	}

	@Override
	public double getXOfCorner() {
		return x - radius;
	}

	@Override
	public double getYOfCorner() {
		return y - radius;
	}

	@Override
	public double getWidth() {
		return radius*2;
	}

	@Override
	public double getHeight() {
		return radius*2;
	}
}