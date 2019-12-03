package sample;

import commons.Constants;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    @FXML
    private Button left;
    @FXML
    private Button center;
    @FXML
    private Button right;

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
        catapultLeft.setPower(100);
        catapultCenter = new Catapult(215, 320, Constants.LEN_OF_CATAPULT);
        catapultCenter.setAngle(90);
        catapultCenter.setPower(100);
        catapultRight = new Catapult(410, 315, Constants.LEN_OF_CATAPULT);
        catapultRight.setAngle(150);
        catapultRight.setPower(100);
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
        left.setDisable(false);
        center.setDisable(false);
        right.setDisable(false);
        ballLeft.stopAndMoveTo(5, 350);
        redraw();
    }

    public void startSimulation() {
        switch (button) {
            case 'l':
                catapultLeft.shootBall(ballLeft, this);
                physics.manageBallMovement(ballLeft, this, (int) canvas.getWidth(), (int) canvas.getWidth());
                break;
            case 'c':
                catapultCenter.shootBall(ballCenter, this);
                physics.manageBallMovement(ballCenter, this, (int) canvas.getWidth(), (int) canvas.getWidth());
                break;
            case 'r':
                catapultRight.shootBall(ballRight, this);
                physics.manageBallMovement(ballRight, this, (int) canvas.getWidth(), (int) canvas.getWidth());
                break;
        }

    }

    public boolean stepOfSimulation() {
        boolean continueSimulation = !ballLeft.overlaps(spaceShip) && !ballCenter.overlaps(spaceShip) && !ballRight.overlaps(spaceShip);
        boolean hitWall = !ballLeft.overlaps(canvas) && !ballCenter.overlaps(canvas) && !ballRight.overlaps(canvas);
        if (!continueSimulation && !hitWall) {
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

    private void leftPressed(ActionEvent event) {
        left.setDisable(true);
        button = 'l';
        startSimulation();
    }

    private void centerPressed(ActionEvent event) {
        left.setDisable(true);
        button = 'c';
        startSimulation();
    }

    private void rightPressed(ActionEvent event) {
        left.setDisable(true);
        button = 'r';
        startSimulation();
    }

    private void init(){
        left.setOnAction(this::leftPressed);
        center.setOnAction(this::centerPressed);
        right.setOnAction(this::rightPressed);
    }
}
