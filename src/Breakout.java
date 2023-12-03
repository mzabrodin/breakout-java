/**
 * File: Breakout.java
 * -------------------
 * Name: Breakout
 * Section Leader: The father class of the game of Breakout.
 * Authors: Bublyk Svitlana, Zabrodin Maksym
 * <p>
 * This file will eventually implement the game of Breakout.
 * <p>
 */

import acm.graphics.*;
import acm.program.GraphicsProgram;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * The BreakoutGame class represents a simple Breakout game with different levels.
 * The game involves a ball bouncing off a paddle to break bricks and earn points.
 * Players can choose the level of difficulty before starting the game.
 */
public class Breakout extends GraphicsProgram {
    /**
     * Runs the Breakout game by setting up the initial conditions, adding mouse listeners,
     * and starting the game loop.
     */
    public void run() {
        setup();
        addMouseListeners();
        playGame();
    }

    /**
     * The main game loop responsible for handling different game levels,
     * initializing game elements, and continuously updating the game state.
     */
    private void playGame() {
        while (true) {
            chooseLevel();
            waitForClick();
            if (BreakoutVars.GAME_MODE == 1) {
                BreakoutVars.NUMBER_OF_POINTS = 0;
                BreakoutVars.NUMBER_OF_REMOVED_BRICKS = 0;
                BreakoutVars.NUMBER_OF_LIVES = BreakoutVars.NUMBER_OF_TURNS + 2;
                removeAll();
                drawBricks();
                ball();
                showPoints();
                drawHeart();
                drawPaddle();
                GLabel pressToStart = new GLabel("Click to play");
                pressToStart.setFont("Courier New-30");
                pressToStart.setLocation(getWidth() / 2.0 - pressToStart.getWidth() / 2.0, getHeight() / 2.0 + getHeight() / 8.0);
                add(pressToStart);
                waitForClick();
                remove(pressToStart);
                moveBall();
            } else if (BreakoutVars.GAME_MODE == 2) {
                BreakoutVars.NUMBER_OF_POINTS = 0;
                BreakoutVars.NUMBER_OF_REMOVED_BRICKS = 0;
                BreakoutVars.NUMBER_OF_LIVES = BreakoutVars.NUMBER_OF_TURNS;
                removeAll();
                drawBricks();
                ball();
                showPoints();
                drawHeart();
                drawPaddle();
                GLabel pressToStart = new GLabel("Click to play");
                pressToStart.setFont("Courier New-30");
                pressToStart.setLocation(getWidth() / 2.0 - pressToStart.getWidth() / 2.0, getHeight() / 2.0 + getHeight() / 8.0);
                add(pressToStart);
                waitForClick();
                remove(pressToStart);
                moveBall();
            } else if (BreakoutVars.GAME_MODE == 3) {
                BreakoutVars.NUMBER_OF_POINTS = 0;
                BreakoutVars.NUMBER_OF_REMOVED_BRICKS = 0;
                BreakoutVars.NUMBER_OF_LIVES = BreakoutVars.NUMBER_OF_TURNS;
                removeAll();
                drawBricks();
                ball();
                showPoints();
                drawHeart();
                drawPaddle();
                GLabel pressToStart = new GLabel("Click to play");
                pressToStart.setFont("Courier New-30");
                pressToStart.setLocation(getWidth() / 2.0 - pressToStart.getWidth() / 2.0, getHeight() / 2.0 + getHeight() / 8.0);
                add(pressToStart);
                waitForClick();
                remove(pressToStart);
                moveBall();
            }
        }
    }

    /**
     * Displays the level selection screen with buttons for different difficulty levels.
     */
    private void chooseLevel() {
        removeAll();
        setBackground(new Color(245, 240, 206));

        GLabel breakout = new GLabel("Breakout");
        breakout.setFont("Courier New-50");
        breakout.setLocation(getWidth() / 2.0 - breakout.getWidth() / 2.0, 130);
        add(breakout);

        BreakoutVars.LEVEL1_RECT_BUTTON = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET, BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.LEVEL1_RECT_BUTTON.setFilled(true);
        BreakoutVars.LEVEL1_RECT_BUTTON.setColor(new Color(48, 66, 43));
        BreakoutVars.LEVEL1_LABEL_BUTTON = new GLabel("1");
        BreakoutVars.LEVEL1_LABEL_BUTTON.setFont("Courier New-50");
        BreakoutVars.LEVEL1_LABEL_BUTTON.setColor(Color.WHITE);
        BreakoutVars.LEVEL1_LABEL_BUTTON.setLocation(getWidth() / 2.0 - BreakoutVars.LEVEL1_LABEL_BUTTON.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT - 10);
        add(BreakoutVars.LEVEL1_RECT_BUTTON);
        add(BreakoutVars.LEVEL1_LABEL_BUTTON);

        BreakoutVars.LEVEL2_RECT_BUTTON = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING, BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.LEVEL2_RECT_BUTTON.setFilled(true);
        BreakoutVars.LEVEL2_RECT_BUTTON.setColor(new Color(95, 111, 82));
        BreakoutVars.LEVEL2_LABEL_BUTTON = new GLabel("2");
        BreakoutVars.LEVEL2_LABEL_BUTTON.setFont("Courier New-50");
        BreakoutVars.LEVEL2_LABEL_BUTTON.setColor(Color.WHITE);
        BreakoutVars.LEVEL2_LABEL_BUTTON.setLocation(getWidth() / 2.0 - BreakoutVars.LEVEL2_LABEL_BUTTON.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING - 10);
        add(BreakoutVars.LEVEL2_RECT_BUTTON);
        add(BreakoutVars.LEVEL2_LABEL_BUTTON);

        BreakoutVars.LEVEL3_RECT_BUTTON = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET + 2 * (BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING), BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.LEVEL3_RECT_BUTTON.setFilled(true);
        BreakoutVars.LEVEL3_RECT_BUTTON.setColor(new Color(169, 179, 136));
        BreakoutVars.LEVEL3_LABEL_BUTTON = new GLabel("3");
        BreakoutVars.LEVEL3_LABEL_BUTTON.setFont("Courier New-50");
        BreakoutVars.LEVEL3_LABEL_BUTTON.setColor(Color.WHITE);
        BreakoutVars.LEVEL3_LABEL_BUTTON.setLocation(getWidth() / 2.0 - BreakoutVars.LEVEL3_LABEL_BUTTON.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING - 10);
        add(BreakoutVars.LEVEL3_RECT_BUTTON);
        add(BreakoutVars.LEVEL3_LABEL_BUTTON);
    }

    /**
     * Draws the paddle on the screen.
     */
    private void drawPaddle() {
        BreakoutVars.PADDLE_RECT = new GRect(getWidth() / 2.0 - BreakoutVars.PADDLE_WIDTH / 2.0, getHeight() - BreakoutVars.PADDLE_Y_OFFSET, BreakoutVars.PADDLE_WIDTH, BreakoutVars.PADDLE_HEIGHT);
        BreakoutVars.PADDLE_RECT.setFilled(true);
        BreakoutVars.PADDLE_RECT.setColor(new Color(95, 111, 82));
        add(BreakoutVars.PADDLE_RECT);
    }

    /**
     * Handles mouse click events, allowing players to choose the game level.
     *
     * @param event The MouseEvent representing the mouse click.
     */
    public void mouseClicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (BreakoutVars.GAME_MODE == 0) {
            if (getElementAt(x, y) == BreakoutVars.LEVEL1_RECT_BUTTON || getElementAt(x, y) == BreakoutVars.LEVEL1_LABEL_BUTTON) {
                BreakoutVars.GAME_MODE = 1;
            } else if (getElementAt(x, y) == BreakoutVars.LEVEL2_RECT_BUTTON || getElementAt(x, y) == BreakoutVars.LEVEL2_LABEL_BUTTON) {
                BreakoutVars.GAME_MODE = 2;
            } else if (getElementAt(x, y) == BreakoutVars.LEVEL3_RECT_BUTTON || getElementAt(x, y) == BreakoutVars.LEVEL3_LABEL_BUTTON) {
                BreakoutVars.GAME_MODE = 3;
            }
        }
    }

    /**
     * Handles mouse press events, indicating that the mouse button is pressed.
     * This method is used to control the paddle so that it moves only when the user holds down the mouse key
     *
     * @param e The MouseEvent representing the mouse press.
     */
    public void mousePressed(MouseEvent e) {
        BreakoutVars.IS_MOUSE_PRESSED = true;
    }

    /**
     * Handles mouse release events, indicating that the mouse button is released.
     * This method is used to control the paddle so that it moves only when the user holds down the mouse key
     *
     * @param e The MouseEvent representing the mouse release.
     */
    public void mouseReleased(MouseEvent e) {
        BreakoutVars.IS_MOUSE_PRESSED = false;
    }

    /**
     * Handles mouse movement events, allowing the paddle to follow the mouse.
     *
     * @param e The MouseEvent representing the mouse movement.
     */
    public void mouseMoved(MouseEvent e) {
        if (BreakoutVars.IS_MOUSE_PRESSED) {
            double mouseX = e.getX();
            double racketX = mouseX - BreakoutVars.PADDLE_WIDTH / 2.0;
            if (mouseX + BreakoutVars.PADDLE_WIDTH / 2.0 < getWidth() && mouseX - BreakoutVars.PADDLE_WIDTH / 2.0 > 0) {
                BreakoutVars.PADDLE_RECT.setLocation(racketX, getHeight() - BreakoutVars.PADDLE_Y_OFFSET);
            }
        }
    }

    /**
     * Handles mouse drag events
     *
     * @param e The MouseEvent representing the mouse drag.
     */
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    /**
     * Performs the initial setup of the game, setting the size and background color.
     */
    private void setup() {
        this.setSize(BreakoutVars.WIDTH, BreakoutVars.HEIGHT);
        setBackground(new Color(254, 250, 224));
    }

    /**
     * Draws bricks based on the selected game level.
     */
    private void drawBricks() {
        if (BreakoutVars.GAME_MODE == 1) {
            for (int i = 0; i < BreakoutVars.NUMBER_OF_BRICKS_PER_ROW; i++) {
                for (int j = 0; j < BreakoutVars.NUMBER_OF_BRICKS_ROWS; j++) {
                    BreakoutVars.BRICK_RECT = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT
                    );
                    BreakoutVars.BRICK_RECT.setFilled(true);
                    if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.BRICK_RECT.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.BRICK_RECT.setColor(new Color(95, 111, 82));
                    } else {
                        BreakoutVars.BRICK_RECT.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.BRICK_RECT);
                }
            }
        }

        if (BreakoutVars.GAME_MODE == 2) {
            for (int i = 0; i < BreakoutVars.NUMBER_OF_BRICKS_PER_ROW; i++) {
                for (int j = 0; j < BreakoutVars.NUMBER_OF_BRICKS_ROWS; j++) {
                    BreakoutVars.BRICK_RECT = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT
                    );
                    BreakoutVars.BRICK_RECT.setFilled(true);
                    if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.BRICK_RECT.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.BRICK_RECT.setColor(new Color(95, 111, 82));
                    } else {
                        BreakoutVars.BRICK_RECT.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.BRICK_RECT);
                }
            }
            GLabel level2 = new GLabel("Speed has increased");
            level2.setFont("Courier New-30");
            level2.setLocation(getWidth() / 2.0 - level2.getWidth() / 2.0, getHeight() / 2.0 - level2.getHeight() / 2.0 + getHeight() / 4.0);
            add(level2);
            pause(3000);
            remove(level2);
        }

        if (BreakoutVars.GAME_MODE == 3) {
            for (int i = 0; i < BreakoutVars.NUMBER_OF_BRICKS_PER_ROW + 3; i++) {
                for (int j = 0; j < BreakoutVars.NUMBER_OF_BRICKS_ROWS; j++) {
                    BreakoutVars.BRICK_RECT = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT);
                    BreakoutVars.BRICK_RECT.setFilled(true);
                    if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.BRICK_RECT.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NUMBER_OF_BRICKS_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.BRICK_RECT.setColor(Color.BLACK);
                    } else {
                        BreakoutVars.BRICK_RECT.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.BRICK_RECT);
                }
            }
            GLabel level2 = new GLabel("Speed has increased");
            level2.setFont("Courier New-30");
            level2.setLocation(getWidth() / 2.0 - level2.getWidth() / 2.0, getHeight() / 2.0 - level2.getHeight() / 2.0 + getHeight() / 8.0);
            add(level2);
            GLabel level3 = new GLabel("Black bricks have 2 lives each");
            level3.setFont("Courier New-30");
            level3.setLocation(getWidth() / 2.0 - level3.getWidth() / 2.0, getHeight() / 2.0 - level3.getHeight() / 2.0 + getHeight() / 4.0);
            add(level3);
            pause(3000);
            remove(level2);
            remove(level3);
        }
    }

    /**
     * Initializes the ball's position and velocity based on the selected game level.
     */
    private void ball() {
        if (BreakoutVars.GAME_MODE == 1) {
            BreakoutVars.SPEED_X = BreakoutVars.RANDOM_GENERATOR.nextDouble(3.0, 10.0);
            if (BreakoutVars.RANDOM_GENERATOR.nextBoolean(0.5)) BreakoutVars.SPEED_X = -BreakoutVars.SPEED_X;
            BreakoutVars.SPEED_Y = 10.0;
        } else if (BreakoutVars.GAME_MODE == 2 || BreakoutVars.GAME_MODE == 3) {
            BreakoutVars.SPEED_X = BreakoutVars.RANDOM_GENERATOR.nextDouble(10.0, 5.0);
            if (BreakoutVars.RANDOM_GENERATOR.nextBoolean(0.5)) BreakoutVars.SPEED_X = -BreakoutVars.SPEED_X;
            BreakoutVars.SPEED_Y = 15.0;
        }
        BreakoutVars.BALL_OVAL = new GOval(0, 0);
        BreakoutVars.BALL_OVAL.setFilled(true);
        BreakoutVars.BALL_OVAL.setColor(new Color(185, 148, 112));
        BreakoutVars.BALL_OVAL.setSize(2 * BreakoutVars.BALL_RADIUS, 2 * BreakoutVars.BALL_RADIUS);
        BreakoutVars.BALL_OVAL.setLocation(
                getWidth() / 2.0 - BreakoutVars.BALL_OVAL.getWidth() / 2.0,
                getHeight() / 2.0 - BreakoutVars.BALL_OVAL.getHeight() / 2.0);
        add(BreakoutVars.BALL_OVAL);
    }

    /**
     * Moves the ball, checking for collisions and updating the game state.
     */
    private void moveBall() {
        while (BreakoutVars.NUMBER_OF_BRICKS != BreakoutVars.NUMBER_OF_REMOVED_BRICKS && BreakoutVars.NUMBER_OF_LIVES != 0) {
            BreakoutVars.BALL_OVAL.move(BreakoutVars.SPEED_X, BreakoutVars.SPEED_Y);
            decreaseHeartNumbers();
            addPoints();
            checkWalls();
            pause(10);
            GObject collider = getCollidingObject();
            if (collider == BreakoutVars.PADDLE_RECT) {
                BreakoutVars.SPEED_Y = Math.abs(BreakoutVars.SPEED_Y) * (-1);
            } else if (collider != null && collider != BreakoutVars.LIVES_IMAGE && collider != BreakoutVars.NUMBER_OF_LIVES_LABEL && collider != BreakoutVars.NUMBER_OF_POINTS_LABEL && collider != BreakoutVars.POINTS_IMAGE) {
                play("blink1.au");
                if (collider.getColor() != Color.BLACK) {
                    remove(collider);
                    BreakoutVars.NUMBER_OF_REMOVED_BRICKS++;
                    BreakoutVars.NUMBER_OF_POINTS += 5;
                } else if (collider.getColor() == Color.BLACK) {
                    collider.setColor(new Color(95, 111, 82));
                }
                BreakoutVars.SPEED_Y = -BreakoutVars.SPEED_Y;
            }
            checkWinOrLoss();
        }
    }

    /**
     * Draws the heart image indicating the number of lives remaining.
     */
    private void drawHeart() {
        BreakoutVars.LIVES_IMAGE = new GImage("heart.png");
        add(BreakoutVars.LIVES_IMAGE);
        BreakoutVars.LIVES_IMAGE.setLocation(getWidth() - BreakoutVars.LIVES_IMAGE.getWidth() * 2, 6);
        if (BreakoutVars.NUMBER_OF_LIVES_LABEL != null) {
            remove(BreakoutVars.NUMBER_OF_LIVES_LABEL);
        }
        BreakoutVars.NUMBER_OF_LIVES_LABEL = new GLabel(": " + BreakoutVars.NUMBER_OF_LIVES);
        BreakoutVars.NUMBER_OF_LIVES_LABEL.setFont("ComicSans-36");
        add(BreakoutVars.NUMBER_OF_LIVES_LABEL, BreakoutVars.LIVES_IMAGE.getX() + BreakoutVars.LIVES_IMAGE.getWidth(), BreakoutVars.LIVES_IMAGE.getHeight() / 1.25);
    }

    /**
     * Checks for collisions with game elements.
     *
     * @return The colliding GObject, or null if no collision.
     */
    private GObject getCollidingObject() {

        double upRightAngleX = BreakoutVars.BALL_OVAL.getX() - 1;
        double upRightAngleY = BreakoutVars.BALL_OVAL.getY() - 1;

        double upLeftAngleX = BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() + 1;
        double upLeftAngleY = BreakoutVars.BALL_OVAL.getY() - 1;

        double downRightAngleX = BreakoutVars.BALL_OVAL.getX() - 1;
        double downRightAngleY = BreakoutVars.BALL_OVAL.getY() + BreakoutVars.BALL_OVAL.getHeight() + 1;

        double downLeftAngleX = BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() + 1;
        double downLeftAngleY = BreakoutVars.BALL_OVAL.getY() + BreakoutVars.BALL_OVAL.getHeight() + 1;

        double middleUpX = BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() / 2.0;
        double middleUpY = BreakoutVars.BALL_OVAL.getY() - 1;

        double middleDownX = BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() / 2.0;
        double middleDownY = BreakoutVars.BALL_OVAL.getY() + BreakoutVars.BALL_OVAL.getHeight() + 1;

        double middleLeftX = BreakoutVars.BALL_OVAL.getX() - 1;
        double middleLeftY = BreakoutVars.BALL_OVAL.getY() + BreakoutVars.BALL_OVAL.getHeight() / 2.0;

        double middleRightX = BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() + 1;
        double middleRightY = BreakoutVars.BALL_OVAL.getY() + BreakoutVars.BALL_OVAL.getHeight() / 2.0;

        if (getElementAt(upRightAngleX, upRightAngleY) != null) {
            return getElementAt(upRightAngleX, upRightAngleY);
        } else if (getElementAt(upLeftAngleX, upLeftAngleY) != null) {
            return getElementAt(upLeftAngleX, upLeftAngleY);
        } else if (getElementAt(downRightAngleX, downRightAngleY) != null) {
            return getElementAt(downRightAngleX, downRightAngleY);
        } else if (getElementAt(downLeftAngleX, downLeftAngleY) != null) {
            return getElementAt(downLeftAngleX, downLeftAngleY);
        } else if (getElementAt(middleUpX, middleUpY) != null) {
            return getElementAt(middleUpX, middleUpY);
        } else if (getElementAt(middleDownX, middleDownY) != null) {
            return getElementAt(middleDownX, middleDownY);
        } else if (getElementAt(middleLeftX, middleLeftY) != null) {
            return getElementAt(middleLeftX, middleLeftY);
        } else if (getElementAt(middleRightX, middleRightY) != null) {
            return getElementAt(middleRightX, middleRightY);
        }
        return null;
    }

    /**
     * Checks for collisions with walls and updates ball velocity accordingly.
     */
    private void checkWalls() {
        if (BreakoutVars.BALL_OVAL.getX() <= 0) {
            BreakoutVars.SPEED_X = -BreakoutVars.SPEED_X;
        } else if (BreakoutVars.BALL_OVAL.getX() + BreakoutVars.BALL_OVAL.getWidth() >= BreakoutVars.APPLICATION_WIDTH) {
            BreakoutVars.SPEED_X = -BreakoutVars.SPEED_X;
        } else if (BreakoutVars.BALL_OVAL.getY() <= 0) {
            BreakoutVars.SPEED_Y = -BreakoutVars.SPEED_Y;
        }
    }

    /**
     * Checks if the player has won or lost the game.
     */
    private void checkWinOrLoss() {
        if (BreakoutVars.NUMBER_OF_LIVES == 0) {
            removeAll();
            setBackground(new Color(192, 185, 139));
            BreakoutVars.PEREMOGA_OR_3RADA = new GLabel("You lost!");
            BreakoutVars.PEREMOGA_OR_3RADA.setFont("Courier New-30");
            add(BreakoutVars.PEREMOGA_OR_3RADA, getWidth() / 2.0 - BreakoutVars.PEREMOGA_OR_3RADA.getWidth() / 2.0, getHeight() / 2.0 - BreakoutVars.PEREMOGA_OR_3RADA.getHeight() / 2.0);
            BreakoutVars.GAME_MODE = 0;
            pause(1000);
        }
        if (BreakoutVars.NUMBER_OF_REMOVED_BRICKS == BreakoutVars.NUMBER_OF_BRICKS) {
            removeAll();
            setBackground(new Color(192, 185, 139));
            BreakoutVars.PEREMOGA_OR_3RADA = new GLabel("You won!");
            BreakoutVars.PEREMOGA_OR_3RADA.setFont("Courier New-30");
            add(BreakoutVars.PEREMOGA_OR_3RADA, getWidth() / 2.0 - BreakoutVars.PEREMOGA_OR_3RADA.getWidth() / 2.0, getHeight() / 2.0 - BreakoutVars.PEREMOGA_OR_3RADA.getHeight() / 2.0);
            BreakoutVars.GAME_MODE = 0;
            pause(1000);
        }
    }

    /**
     * Decreases the number of remaining lives when the ball falls below the screen.
     */
    private void decreaseHeartNumbers() {
        if (BreakoutVars.NUMBER_OF_REMOVED_BRICKS < BreakoutVars.NUMBER_OF_BRICKS && BreakoutVars.BALL_OVAL.getY() >= getHeight()) {
            remove(BreakoutVars.BALL_OVAL);
            ball();
            BreakoutVars.NUMBER_OF_LIVES--;
            BreakoutVars.NUMBER_OF_LIVES_LABEL.setLabel(": " + BreakoutVars.NUMBER_OF_LIVES);
        }

    }

    /**
     * Plays a sound file specified by the filename.
     *
     * @param sound The filename of the sound file to be played.
     */
    public static void play(String sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(sound)));
            clip.start();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    /**
     * Displays the current points earned in the game.
     */
    private void showPoints() {
        BreakoutVars.POINTS_IMAGE = new GImage("points.png");
        add(BreakoutVars.POINTS_IMAGE, 0, 6);
        if (BreakoutVars.NUMBER_OF_POINTS_LABEL != null) {
            remove(BreakoutVars.NUMBER_OF_POINTS_LABEL);
        }
        BreakoutVars.NUMBER_OF_POINTS_LABEL = new GLabel(": " + BreakoutVars.NUMBER_OF_POINTS);
        BreakoutVars.NUMBER_OF_POINTS_LABEL.setFont("ComicSans-36");
        add(BreakoutVars.NUMBER_OF_POINTS_LABEL, BreakoutVars.POINTS_IMAGE.getX() + BreakoutVars.POINTS_IMAGE.getWidth(), BreakoutVars.POINTS_IMAGE.getHeight() / 1.2);
    }

    /**
     * Updates the points display.
     */
    private void addPoints() {
        BreakoutVars.NUMBER_OF_POINTS_LABEL.setLabel(": " + BreakoutVars.NUMBER_OF_POINTS);
    }
}