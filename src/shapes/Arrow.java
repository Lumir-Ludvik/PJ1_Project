package shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;
import sample.Paintable;


public class Arrow implements Paintable {

	private int xPos;
	private int yPos;
	private double len;
	private double angle;
	private Color color;
	private double arrowSize;
	
	public Arrow(int xPos, int yPos, double len, double angle,double arrowSize, Color color) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.len = len;
		this.angle = angle;
		this.color = color;
		this.arrowSize = arrowSize;
	}
	
	public void paint(GraphicsContext gc) {
		Affine oldTransform = gc.getTransform();
		Transform transform = Transform.translate(xPos, yPos);
		transform = transform.createConcatenation(Transform.rotate(-angle, 0, 0));
		gc.setTransform(new Affine(transform));
		gc.setFill(color);
		gc.setStroke(color);
		gc.strokeLine(0, 0, len, 0);
		gc.fillPolygon(new double[] { len, len - arrowSize, len - arrowSize, len },
				new double[] { 0, -arrowSize, arrowSize, 0 }, 4);
		gc.setTransform(oldTransform);
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
}
