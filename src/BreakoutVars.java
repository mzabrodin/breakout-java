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
     * The width of the game application.
     */
    public static final int APPLICATION_WIDTH = 800;
    /**
     * The height of the game application.
     */
    public static final int APPLICATION_HEIGHT = 1000;
    /**
     * Horizontal offset for width calculation.
     */
    public static final int WIDTH_OFFSET = 22;
    /**
     * Vertical offset for height calculation.
     */
    public static final int HEIGHT_OFFSET = 86;
    /**
     * The extended width of the game application.
     */
    public static final int WIDTH = APPLICATION_WIDTH + WIDTH_OFFSET;
    /**
     * The extended height of the game application.
     */
    public static final int HEIGHT = APPLICATION_HEIGHT + HEIGHT_OFFSET;
    /**
     * The label displaying the game result (win/lose) or level status.
     */
    public static GLabel PEREMOGA_OR_3RADA;
    /**
     * The current status of the game (0 for main menu, 1 for leve 1, 2 for level 2, 3 for level 3).
     */
    public static int GAME_MODE = 0;
    /**
     * Flag indicating whether the mouse is pressed.
     */
    public static boolean IS_MOUSE_PRESSED = false;
    /**
     * Random number generator for game elements.
     */
    public static RandomGenerator RANDOM_GENERATOR = RandomGenerator.getInstance();
    /**
     * The label displaying the current number of points in the game.
     */
    public static GLabel NUMBER_OF_POINTS_LABEL;
    /**
     * Counter to keep track of points earned in the game.
     */
    public static int NUMBER_OF_POINTS;
    /**
     * The image representing the points in the game.
     */
    public static GImage POINTS_IMAGE;
    /**
     * The horizontal velocity of the ball.
     */
    public static double SPEED_X;
    /**
     * The vertical velocity of the ball.
     */
    public static double SPEED_Y;
    /**
     * The oval representing the ball in the game.
     */
    public static GOval BALL_OVAL;
    /**
     * The radius of the ball.
     */
    public static final int BALL_RADIUS = 30;
    /**
     * The rectangle representing a brick in the game.
     */
    public static GRect BRICK_RECT;
    /**
     * The number of bricks per row.
     */
    public static final int NUMBER_OF_BRICKS_PER_ROW = 6;
    /**
     * The number of brick rows.
     */
    public static final int NUMBER_OF_BRICKS_ROWS = 6;
    /**
     * The separation between bricks.
     */
    public static final int BRICK_SEP = 14;
    /**
     * The width of each brick.
     */
    public static final int BRICK_WIDTH = (APPLICATION_WIDTH - (NUMBER_OF_BRICKS_PER_ROW + 1) * BRICK_SEP) / NUMBER_OF_BRICKS_PER_ROW;
    /**
     * The height of each brick.
     */
    public static final int BRICK_HEIGHT = 15;
    /**
     * The vertical offset for bricks.
     */
    public static final int BRICK_Y_OFFSET = 80;
    /**
     * The total number of bricks in the game.
     */
    public static int NUMBER_OF_BRICKS = NUMBER_OF_BRICKS_ROWS * NUMBER_OF_BRICKS_PER_ROW;
    /**
     * The number of bricks that have been removed.
     */
    public static int NUMBER_OF_REMOVED_BRICKS = 0;
    /**
     * The width of the paddle.
     */
    public static final int PADDLE_WIDTH = 160;
    /**
     * The height of the paddle.
     */
    public static final int PADDLE_HEIGHT = 30;
    /**
     * The vertical offset for the paddle.
     */
    public static final int PADDLE_Y_OFFSET = 150;
    /**
     * The rectangle representing the paddle in the game.
     */
    public static GRect PADDLE_RECT;
    /**
     * The label displaying the current number of remaining lives (hearts).
     */
    public static GLabel NUMBER_OF_LIVES_LABEL;
    /**
     * The image representing hearts (lives) in the game.
     */
    public static GImage LIVES_IMAGE;
    /**
     * Counter to keep track of remaining hearts (lives).
     */
    public static int NUMBER_OF_LIVES;
    /**
     * The maximum number of turns in the game.
     */
    public static final int NUMBER_OF_TURNS = 3;
    /**
     * The rectangle representing the level 1 button.
     */
    public static GRect LEVEL1_RECT_BUTTON;
    /**
     * The rectangle representing the level 2 button.
     */
    public static GRect LEVEL2_RECT_BUTTON;
    /**
     * The rectangle representing the level 3 button.
     */
    public static GRect LEVEL3_RECT_BUTTON;
    /**
     * The label displaying the level 1 status.
     */
    public static GLabel LEVEL1_LABEL_BUTTON;
    /**
     * The label displaying the level 2 status.
     */
    public static GLabel LEVEL2_LABEL_BUTTON;
    /**
     * The label displaying the level 3 status.
     */
    public static GLabel LEVEL3_LABEL_BUTTON;
    /**
     * The width of the button.
     */
    public static final double BUTTON_WIDTH = 200;
    /**
     * The height of the button.
     */
    public static final double BUTTON_HEIGHT = 60;
    /**
     * The spacing between buttons.
     */
    public static final double BUTTON_SPACING = 20;
    /**
     * The vertical offset for buttons.
     */
    public static final double BUTTON_Y_OFFSET = 400;
}
