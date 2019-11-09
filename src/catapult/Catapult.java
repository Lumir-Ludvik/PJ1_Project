package catapult;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import commons.ProcessRoutines;
import sample.Paintable;
import shapes.Arrow;
import shapes.Ball;

/**
 * Graphical representation of a catapult and it also implements process of a shooting.
 * @author koz01
 *
 */
/*
public class Catapult implements Paintable{

	private static final int ARR_SIZE = 5;
	private final int x;
	private final int y;
	private final int len;

	private double angle;

	private double power;
	
	private Arrow shape;

	public Catapult(int x, int y, int len) {
		super();
		this.x = x;
		this.y = y;
		this.len = len;
		this.shape = new Arrow(x, y, len, 0, ARR_SIZE, Color.LIGHTBLUE);
	}

	public void setAngle(double angle) {
		this.angle = angle;
		shape.setAngle(angle);
	}

	public void setPower(double power) {
		this.power = power;
	}

	public void shootBall(Ball ball, SimulationManager manager) {
		int xEnd = x + (int) (Math.cos(Math.toRadians(angle)) * len);
		int yEnd = y - (int) (Math.sin(Math.toRadians(angle)) * len);
		double xAcc = Math.cos(Math.toRadians(angle)) * power;
		double yAcc = -Math.sin(Math.toRadians(angle)) * power;
		long time = System.currentTimeMillis();
		while (ball.getX() < xEnd && ball.getY() > yEnd) {
			ProcessRoutines.sleep(1);
			long newTime = System.currentTimeMillis();
			double difTime = (newTime - time)/1000.;
			ball.move(difTime);
			ball.accelerate(xAcc, yAcc, difTime);
			time = newTime;
			manager.stepOfSimulation();
		}
	}

	@Override
	public void paint(GraphicsContext gc) {
		shape.paint(gc);
	}

}
*/