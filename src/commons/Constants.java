package commons;

import javafx.scene.image.Image;

public final class Constants {
    public static final int GRAVITY = 10;
    public static final int POWER = 50;
    public static final int SIZE_OF_BALL = 5;
    public static final int LEN_OF_CATAPULT = 40;
    public static final Image SPACESHIP;
    static{
        SPACESHIP = new Image(Constants.class.getResourceAsStream("spaceShip.png"));
    }
}
