package sample;

import commons.Constants;
import javafx.application.Platform;
import shapes.Ball;

public class Simulation {
    private int xAxis;
    private int yAxis;
    private Canvas canvas;
    private Catapult catapult;
    private Ball ball;
    private Physics physics;
    private HUD hud;
    private SpaceShip spaceShip;

    public Simulation(double angle, double power, int catapultXAxis, int catapultYAxis) {
        canvas = Canvas.getInstance();
        xAxis = catapultXAxis;
        yAxis = catapultYAxis;
        catapult = new Catapult(xAxis, yAxis, Constants.LEN_OF_CATAPULT);
        catapult.setAngle(angle);
        catapult.setPower(power);
        ball = new Ball(xAxis, yAxis, Constants.SIZE_OF_BALL);
        physics = new Physics(Constants.GRAVITY);
        canvas.addEntities(catapult);
        canvas.addEntities(ball);
        hud = new HUD();
        canvas.addEntities(hud);
        spaceShip = new SpaceShip((int) canvas.getWidth(), (int) canvas.getHeight());
        //canvas.addEntities(spaceShip);
    }

    public void restore() {
        ball.stopAndMoveTo(xAxis, yAxis);
        redraw();
    }

    public void startSimulation() {
        catapult.shootBall(ball, this);
        physics.manageBallMovement(ball, this, (int) canvas.getWidth(), (int) canvas.getWidth());
    }

    public boolean stepOfSimulation() {
        boolean continueSimulation = !ball.overlaps(spaceShip);
        if (!continueSimulation) {
            spaceShip.hit();
            hud.increaseScore();
        }
        spaceShip.moveSpaceShip();
        redraw();
        return continueSimulation;
    }

    private void redraw() {
        Platform.runLater(canvas::redraw);
    }
}
