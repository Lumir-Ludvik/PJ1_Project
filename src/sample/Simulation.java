package sample;

import commons.Constants;
import commons.ProcessRoutines;
import javafx.application.Platform;
import shapes.Ball;

public class Simulation {
    private char button;
    private Canvas canvas;
    private Catapult catapultLeft;
    private Catapult catapultCenter;
    private Catapult catapultRight;
    private Ball ballLeft;
    private Ball ballCenter;
    private Ball ballRight;


    private Physics physics;
    private HUD hud;
    private SpaceShip spaceShip;
    private Background background;

    public Simulation() {
        canvas = Canvas.getInstance();
        background = new Background();
        canvas.addEntities(background);
        catapultLeft = new Catapult(45, 345, Constants.LEN_OF_CATAPULT);
        catapultLeft.setAngle(45);
        catapultLeft.setPower(Constants.POWER);
        catapultCenter = new Catapult(215, 320, Constants.LEN_OF_CATAPULT);
        catapultCenter.setAngle(90);
        catapultCenter.setPower(Constants.POWER);
        catapultRight = new Catapult(410, 315, Constants.LEN_OF_CATAPULT);
        catapultRight.setAngle(150);
        catapultRight.setPower(Constants.POWER);
        ballLeft = new Ball(45, 345, Constants.SIZE_OF_BALL);
        ballCenter = new Ball(215, 320, Constants.SIZE_OF_BALL);
        ballRight = new Ball(410, 315, Constants.SIZE_OF_BALL);
        physics = new Physics(Constants.GRAVITY);
        canvas.addEntities(catapultLeft);
        canvas.addEntities(catapultCenter);
        canvas.addEntities(catapultRight);
        canvas.addEntities(ballLeft);
        canvas.addEntities(ballCenter);
        canvas.addEntities(ballRight);
        hud = new HUD();
        canvas.addEntities(hud);
        spaceShip = new SpaceShip((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.addEntities(spaceShip);
    }

    public void restore() {
        ballLeft.stopAndMoveTo(45, 345);
        ballCenter.stopAndMoveTo(215, 320);
        ballRight.stopAndMoveTo(410, 315);
        redraw();
    }

    public void startSimulation() {
        switch (button) {
            case 'l':
                catapultLeft.shootBall(ballLeft, this);
                physics.manageBallMovement(ballLeft, this, (int) canvas.getWidth(), (int) canvas.getHeight());
                break;
            case 'c':
                catapultCenter.shootBall(ballCenter, this);
                physics.manageBallMovement(ballCenter, this, (int) canvas.getWidth(), (int) canvas.getHeight());
                break;
            case 'r':
                catapultRight.shootBall(ballRight, this);
                physics.manageBallMovement(ballRight, this, (int) canvas.getWidth(), (int) canvas.getHeight());
                break;
        }

    }

    public boolean stepOfSimulation() {
        boolean continueSimulation = !ballLeft.overlaps(spaceShip);
        //boolean hitWall = !ballLeft.overlaps(canvas);
        if (!continueSimulation) {
            spaceShip.hit();
            hud.increaseScore();
        }
        redraw();
        return continueSimulation;
    }

    private void redraw() {
        Platform.runLater(canvas::redraw);
    }


    public void startPressed(){
        spaceShip.moveSpaceShip();
        if (spaceShip.getXOfCorner() + 50  >= canvas.getWidth() || spaceShip.getXOfCorner() <= 0) {
            spaceShip.createSpaceShip();
        }
        Platform.runLater(this::restore);
    }

    public void leftPressed() {
        button = 'l';
        startSimulation();
        Platform.runLater(this::restore);
    }

    public void centerPressed() {
        button = 'c';
        startSimulation();
        Platform.runLater(this::restore);
    }

    public void rightPressed() {
        button = 'r';
        startSimulation();
        Platform.runLater(this::restore);
    }
}
