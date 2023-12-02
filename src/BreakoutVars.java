/**
 * File: BreakoutVars.java
 * -------------------
 * Name: BreakoutVars
 * Section Leader: The class that contains variables for the father class.
 * Authors: Bublyk Svitlana, Zabrodin Maksym.
 */

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;

public class BreakoutVars {
    /**
     * Variables of the game window size
     */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 1000;
    public static final int WIDTH_OFFSET = 22;
    public static final int HEIGHT_OFFSET = 86;
    public static final int WIDTH = APPLICATION_WIDTH + WIDTH_OFFSET;
    public static final int HEIGHT = APPLICATION_HEIGHT + HEIGHT_OFFSET;
    /**
     * Variable of the win or loss label
     */
    public static GLabel PEREMOGA_OR_3RADA;
    /**
     * Variable of the game mode status (0 = main menu, 1 = level 1, 2 = level 2, 3 = level 3)
     */
    public static int GAME_MODE = 0;
    /**
     * Boolean variable of mouse pressed status
     */
    public static boolean IS_MOUSE_PRESSED = false;
    /**
     * Variable of random generator
     */
    public static RandomGenerator randomGenerator = RandomGenerator.getInstance();
    /**
     * Variables of the number of points
     */
    public static GLabel NUMBER_OF_POINTS_LABEL;
    public static int NUMBER_OF_POINTS;
    public static GImage POINTS_IMAGE;
    /**
     * Variable of the ball speed
     */
    public static double SPEED_X;
    public static double SPEED_Y;
    /**
     * Variables of the ball
     */
    public static GOval BALL_OVAL;
    public static final int BALL_RADIUS = 30;
    /**
     * Variable of the bricks
     */
    public static GRect BRICK_RECT;
    public static final int NUMBER_OF_BRICKS_PER_ROW = 6;
    public static final int NUMBER_OF_BRICKS_ROWS = 6;
    public static final int BRICK_SEP = 14;
    public static final int BRICK_WIDTH = (APPLICATION_WIDTH - (NUMBER_OF_BRICKS_PER_ROW + 1) * BRICK_SEP) / NUMBER_OF_BRICKS_PER_ROW;
    public static final int BRICK_HEIGHT = 15;
    public static final int BRICK_Y_OFFSET = 80;
    public static int NUMBER_OF_BRICKS = NUMBER_OF_BRICKS_ROWS * NUMBER_OF_BRICKS_PER_ROW;
    public static int NUMBER_OF_REMOVED_BRICKS = 0;
    /**
     * Variable of the paddle
     */
    public static final int PADDLE_WIDTH = 160;
    public static final int PADDLE_HEIGHT = 30;
    public static final int PADDLE_Y_OFFSET = 150;
    public static GRect PADDLE_RECT;
    /**
     * Variables of the number of lives
     */
    public static GLabel NUMBER_OF_LIVES_LABEL;
    public static GImage LIVES_IMAGE;
    public static int NUMBER_OF_LIVES;
    public static final int NUMBER_OF_TURNS = 3;
    /**
     * Variables of the buttons in main menu
     */
    public static GRect LEVEL1_RECT_BUTTON;
    public static GRect LEVEL2_RECT_BUTTON;
    public static GRect LEVEL3_RECT_BUTTON;
    public static GLabel LEVEL1_LABEL_BUTTON;
    public static GLabel LEVEL2_LABEL_BUTTON;
    public static GLabel LEVEL3_LABEL_BUTTON;
    public static final double BUTTON_WIDTH = 200;
    public static final double BUTTON_HEIGHT = 60;
    public static final double BUTTON_SPACING = 20;
    public static final double BUTTON_Y_OFFSET = 400;
}
