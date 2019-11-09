package shapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sample.Paintable;


public class Triangle implements Paintable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private Direction8 direction;
	
	public Triangle(int xPos, int yPos, int width, int height, Direction8 direction, Color color) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
		this.color = color;
		this.direction = direction;
	}
	
	public void paint(GraphicsContext gc) {
		gc.setFill(color);
		gc.setStroke(color);
		double[][] points = getVertices();
	    gc.fillPolygon(points[0], points[1], Math.min(points[0].length, points[1].length));
	}

	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	
	 private double[][] getVertices() {
		    double[] xpoints = null;
		    double[] ypoints = null;

		    switch (direction) {
		      case EAST:
		        xpoints = new double[]{xPos, xPos + (width), xPos};
		        ypoints = new double[]{yPos, yPos + (height / 2), yPos + height};
		        break;

		      case NORTHEAST:
		        xpoints = new double[]{xPos, xPos + width, xPos + width};
		        ypoints = new double[]{yPos, yPos, yPos + height};
		        break;

		      case NORTH:
		        xpoints = new double[]{xPos, xPos + (width / 2), xPos + width};
		        ypoints = new double[]{yPos + height, yPos, yPos + height};
		        break;

		      case NORTHWEST:
		        xpoints = new double[]{xPos, xPos, xPos + width};
		        ypoints = new double[]{yPos + height, yPos, yPos};
		        break;

		      case WEST:
		        xpoints = new double[]{xPos, xPos + width, xPos + width};
		        ypoints = new double[]{yPos + (height / 2), yPos, yPos + height};
		        break;

		      case SOUTHWEST:
		        xpoints = new double[]{xPos, xPos, xPos + width};
		        ypoints = new double[]{yPos, yPos + height, yPos + height};
		        break;

		      case SOUTH:
		        xpoints = new double[]{xPos, xPos + (width / 2), xPos + width};
		        ypoints = new double[]{yPos, yPos + height, yPos,};
		        break;

		      case SOUTHEAST:
		        xpoints = new double[]{xPos, xPos + width, xPos + width};
		        ypoints = new double[]{yPos + height, yPos + height, yPos};
		        break;

		      default:
		        throw new IllegalStateException(
		            "Instance ukazuje do nedefinovaneho smeru");
		    }
		    return new double[][]{xpoints, ypoints};
		  }
}
