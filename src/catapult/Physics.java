package catapult;
import commons.ProcessRoutines;
import shapes.Ball;

/**
 * It manages movement of a ball in space after is shot. 
 * It should also contains implementation of a shooting and a ball movement. However, that design
 * would be more complicated.
 * 
 * @author koz01
 *
 */
public class Physics {

	private final int gravity;
	
	
	public Physics(int gravity) {
		super();
		this.gravity = gravity;
	}

	public void manageBallMovement(Ball ball, Simulation manager, int canvasWidth, int canvasHeight) {
		long time = System.currentTimeMillis();
		while(ball.getY() < canvasHeight) {
			ProcessRoutines.sleep(1);
			long newTime = System.currentTimeMillis();
			double difTime = (newTime - time)/1000.;
			ball.move(difTime);
			ball.fixXCoordinate(canvasWidth);
			ball.accelerate(0, gravity, difTime);
			time = newTime;
			if(!manager.stepOfSimulation()) {
				break;
			}
		
		}
	}


}
