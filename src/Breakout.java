/**
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * <p>
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.GraphicsProgram;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

public class Breakout extends GraphicsProgram {

    public void run() {
        setup();
        addMouseListeners();
        playGame();
    }

    private void playGame() {
        while (true) {
            chooseLevel();
            waitForClick();
            if (BreakoutVars.gameStatus == 1) {
                BreakoutVars.pointsCheck = 0;
                BreakoutVars.numberOfRemovedBricks = 0;
                BreakoutVars.heartsCheck = BreakoutVars.NTURNS + 2;
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
            } else if (BreakoutVars.gameStatus == 2) {
                BreakoutVars.pointsCheck = 0;
                BreakoutVars.numberOfRemovedBricks = 0;
                BreakoutVars.heartsCheck = BreakoutVars.NTURNS;
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
            } else if (BreakoutVars.gameStatus == 3) {
                BreakoutVars.pointsCheck = 0;
                BreakoutVars.numberOfRemovedBricks = 0;
                BreakoutVars.heartsCheck = BreakoutVars.NTURNS;
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

    private void chooseLevel() {
        removeAll();
        setBackground(new Color(245, 240, 206));

        GLabel breakout = new GLabel("Breakout");
        breakout.setFont("Courier New-50");
        breakout.setLocation(getWidth() / 2.0 - breakout.getWidth() / 2.0, 130);
        add(breakout);

        BreakoutVars.levelButton1 = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET, BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.levelButton1.setFilled(true);
        BreakoutVars.levelButton1.setColor(new Color(48, 66, 43));
        BreakoutVars.level1 = new GLabel("1");
        BreakoutVars.level1.setFont("Courier New-50");
        BreakoutVars.level1.setColor(Color.WHITE);
        BreakoutVars.level1.setLocation(getWidth() / 2.0 - BreakoutVars.level1.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT - 10);
        add(BreakoutVars.levelButton1);
        add(BreakoutVars.level1);

        BreakoutVars.levelButton2 = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING, BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.levelButton2.setFilled(true);
        BreakoutVars.levelButton2.setColor(new Color(95, 111, 82));
        BreakoutVars.level2 = new GLabel("2");
        BreakoutVars.level2.setFont("Courier New-50");
        BreakoutVars.level2.setColor(Color.WHITE);
        BreakoutVars.level2.setLocation(getWidth() / 2.0 - BreakoutVars.level2.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING - 10);
        add(BreakoutVars.levelButton2);
        add(BreakoutVars.level2);

        BreakoutVars.levelButton3 = new GRect((getWidth() - BreakoutVars.BUTTON_WIDTH) / 2.0, BreakoutVars.BUTTON_Y_OFFSET + 2 * (BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING), BreakoutVars.BUTTON_WIDTH, BreakoutVars.BUTTON_HEIGHT);
        BreakoutVars.levelButton3.setFilled(true);
        BreakoutVars.levelButton3.setColor(new Color(169, 179, 136));
        BreakoutVars.level3 = new GLabel("3");
        BreakoutVars.level3.setFont("Courier New-50");
        BreakoutVars.level3.setColor(Color.WHITE);
        BreakoutVars.level3.setLocation(getWidth() / 2.0 - BreakoutVars.level3.getWidth() / 2.0, BreakoutVars.BUTTON_Y_OFFSET + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING + BreakoutVars.BUTTON_HEIGHT + BreakoutVars.BUTTON_SPACING - 10);
        add(BreakoutVars.levelButton3);
        add(BreakoutVars.level3);
    }

    private void drawPaddle() {
        BreakoutVars.paddle = new GRect(getWidth() / 2.0 - BreakoutVars.PADDLE_WIDTH / 2.0, getHeight() - BreakoutVars.PADDLE_Y_OFFSET, BreakoutVars.PADDLE_WIDTH, BreakoutVars.PADDLE_HEIGHT);
        BreakoutVars.paddle.setFilled(true);
        BreakoutVars.paddle.setColor(new Color(95, 111, 82));
        add(BreakoutVars.paddle);
    }

    public void mouseClicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (BreakoutVars.gameStatus == 0) {
            if (getElementAt(x, y) == BreakoutVars.levelButton1 || getElementAt(x, y) == BreakoutVars.level1) {
                BreakoutVars.gameStatus = 1;
            } else if (getElementAt(x, y) == BreakoutVars.levelButton2 || getElementAt(x, y) == BreakoutVars.level2) {
                BreakoutVars.gameStatus = 2;
            } else if (getElementAt(x, y) == BreakoutVars.levelButton3 || getElementAt(x, y) == BreakoutVars.level3) {
                BreakoutVars.gameStatus = 3;
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        BreakoutVars.isMousePressed = true;
    }

    public void mouseReleased(MouseEvent e) {
        BreakoutVars.isMousePressed = false;
    }

    public void mouseMoved(MouseEvent e) {
        if (BreakoutVars.isMousePressed) {
            double mouseX = e.getX();
            double racketX = mouseX - BreakoutVars.PADDLE_WIDTH / 2.0;
            if (mouseX + BreakoutVars.PADDLE_WIDTH / 2.0 < getWidth() && mouseX - BreakoutVars.PADDLE_WIDTH / 2.0 > 0) {
                BreakoutVars.paddle.setLocation(racketX, getHeight() - BreakoutVars.PADDLE_Y_OFFSET);
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    private void setup() {
        this.setSize(BreakoutVars.WIDTH_, BreakoutVars.HEIGHT_);
        setBackground(new Color(254, 250, 224));
    }

    private void drawBricks() {
        if (BreakoutVars.gameStatus == 1) {
            for (int i = 0; i < BreakoutVars.NBRICKS_PER_ROW; i++) {
                for (int j = 0; j < BreakoutVars.NBRICK_ROWS; j++) {
                    BreakoutVars.brick = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT
                    );
                    BreakoutVars.brick.setFilled(true);
                    if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.brick.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.brick.setColor(new Color(95, 111, 82));
                    } else {
                        BreakoutVars.brick.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.brick);
                }
            }
        }

        if (BreakoutVars.gameStatus == 2) {
            for (int i = 0; i < BreakoutVars.NBRICKS_PER_ROW; i++) {
                for (int j = 0; j < BreakoutVars.NBRICK_ROWS; j++) {
                    BreakoutVars.brick = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT
                    );
                    BreakoutVars.brick.setFilled(true);
                    if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.brick.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.brick.setColor(new Color(95, 111, 82));
                    } else {
                        BreakoutVars.brick.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.brick);
                }
            }
            GLabel level2 = new GLabel("Speed has increased");
            level2.setFont("Courier New-30");
            level2.setLocation(getWidth() / 2.0 - level2.getWidth() / 2.0, getHeight() / 2.0 - level2.getHeight() / 2.0 + getHeight() / 4.0);
            add(level2);
            pause(3000);
            remove(level2);
        }

        if (BreakoutVars.gameStatus == 3) {
            for (int i = 0; i < BreakoutVars.NBRICKS_PER_ROW + 3; i++) {
                for (int j = 0; j < BreakoutVars.NBRICK_ROWS; j++) {
                    BreakoutVars.brick = new GRect(
                            BreakoutVars.BRICK_SEP + (BreakoutVars.BRICK_WIDTH + BreakoutVars.BRICK_SEP) * i,
                            BreakoutVars.BRICK_Y_OFFSET + (BreakoutVars.BRICK_HEIGHT + BreakoutVars.BRICK_SEP) * j,
                            BreakoutVars.BRICK_WIDTH,
                            BreakoutVars.BRICK_HEIGHT);
                    BreakoutVars.brick.setFilled(true);
                    if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 0) {
                        BreakoutVars.brick.setColor(new Color(48, 66, 43));
                    } else if ((j / (BreakoutVars.NBRICK_ROWS / 3)) % 3 == 1) {
                        BreakoutVars.brick.setColor(Color.BLACK);
                    } else {
                        BreakoutVars.brick.setColor(new Color(169, 179, 136));
                    }
                    add(BreakoutVars.brick);
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

    private void ball() {
        if (BreakoutVars.gameStatus == 1) {
            BreakoutVars.vx = BreakoutVars.rgen.nextDouble(3.0, 10.0);
            if (BreakoutVars.rgen.nextBoolean(0.5)) BreakoutVars.vx = -BreakoutVars.vx;
            BreakoutVars.vy = 10.0;
        } else if (BreakoutVars.gameStatus == 2 || BreakoutVars.gameStatus == 3) {
            BreakoutVars.vx = BreakoutVars.rgen.nextDouble(10.0, 5.0);
            if (BreakoutVars.rgen.nextBoolean(0.5)) BreakoutVars.vx = -BreakoutVars.vx;
            BreakoutVars.vy = 15.0;
        }
        BreakoutVars.ball = new GOval(0, 0);
        BreakoutVars.ball.setFilled(true);
        BreakoutVars.ball.setColor(new Color(185, 148, 112));
        BreakoutVars.ball.setSize(2 * BreakoutVars.BALL_RADIUS, 2 * BreakoutVars.BALL_RADIUS);
        BreakoutVars.ball.setLocation(
                getWidth() / 2.0 - BreakoutVars.ball.getWidth() / 2.0,
                getHeight() / 2.0 - BreakoutVars.ball.getHeight() / 2.0);
        add(BreakoutVars.ball);
    }

    private void moveBall() {
        while (BreakoutVars.numberOfBricks != BreakoutVars.numberOfRemovedBricks && BreakoutVars.heartsCheck != 0) {
            BreakoutVars.ball.move(BreakoutVars.vx, BreakoutVars.vy);
            decreaseHeartNumbers();
            addPoints();
            checkWalls();
            pause(10);
            GObject collider = getCollidingObject();
            if (collider == BreakoutVars.paddle) {
                BreakoutVars.vy = Math.abs(BreakoutVars.vy) * (-1);
            } else if (collider != null && collider != BreakoutVars.hearts && collider != BreakoutVars.numberOfHearts && collider != BreakoutVars.numberOfPoints && collider != BreakoutVars.points) {
                play("blink1.au");
                if (collider.getColor() != Color.BLACK) {
                    remove(collider);
                    BreakoutVars.numberOfRemovedBricks++;
                    BreakoutVars.pointsCheck += 5;
                } else if (collider.getColor() == Color.BLACK) {
                    collider.setColor(new Color(95, 111, 82));
                }
                BreakoutVars.vy = -BreakoutVars.vy;
            }
            checkWinOrLoss();
        }
    }

    private void drawHeart() {
        BreakoutVars.hearts = new GImage("heart.png");
        add(BreakoutVars.hearts);
        BreakoutVars.hearts.setLocation(getWidth() - BreakoutVars.hearts.getWidth() * 2, 6);
        if (BreakoutVars.numberOfHearts != null) {
            remove(BreakoutVars.numberOfHearts);
        }
        BreakoutVars.numberOfHearts = new GLabel(": " + BreakoutVars.heartsCheck);
        BreakoutVars.numberOfHearts.setFont("ComicSans-36");
        add(BreakoutVars.numberOfHearts, BreakoutVars.hearts.getX() + BreakoutVars.hearts.getWidth(), BreakoutVars.hearts.getHeight() / 1.25);
    }

    private GObject getCollidingObject() {

        double upRightAngleX = BreakoutVars.ball.getX() - 1;
        double upRightAngleY = BreakoutVars.ball.getY() - 1;

        double upLeftAngleX = BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() + 1;
        double upLeftAngleY = BreakoutVars.ball.getY() - 1;

        double downRightAngleX = BreakoutVars.ball.getX() - 1;
        double downRightAngleY = BreakoutVars.ball.getY() + BreakoutVars.ball.getHeight() + 1;

        double downLeftAngleX = BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() + 1;
        double downLeftAngleY = BreakoutVars.ball.getY() + BreakoutVars.ball.getHeight() + 1;

        double middleUpX = BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() / 2.0;
        double middleUpY = BreakoutVars.ball.getY() - 1;

        double middleDownX = BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() / 2.0;
        double middleDownY = BreakoutVars.ball.getY() + BreakoutVars.ball.getHeight() + 1;

        double middleLeftX = BreakoutVars.ball.getX() - 1;
        double middleLeftY = BreakoutVars.ball.getY() + BreakoutVars.ball.getHeight() / 2.0;

        double middleRightX = BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() + 1;
        double middleRightY = BreakoutVars.ball.getY() + BreakoutVars.ball.getHeight() / 2.0;

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

    private void checkWalls() {
        if (BreakoutVars.ball.getX() <= 0) {
            BreakoutVars.vx = -BreakoutVars.vx;
        } else if (BreakoutVars.ball.getX() + BreakoutVars.ball.getWidth() >= BreakoutVars.APPLICATION_WIDTH) {
            BreakoutVars.vx = -BreakoutVars.vx;
        } else if (BreakoutVars.ball.getY() <= 0) {
            BreakoutVars.vy = -BreakoutVars.vy;
        }
    }

    private void checkWinOrLoss() {
        if (BreakoutVars.heartsCheck == 0) {
            removeAll();
            setBackground(new Color(192, 185, 139));
            BreakoutVars.peremogaOr3rada = new GLabel("You lost!");
            BreakoutVars.peremogaOr3rada.setFont("Courier New-30");
            add(BreakoutVars.peremogaOr3rada, getWidth() / 2.0 - BreakoutVars.peremogaOr3rada.getWidth() / 2.0, getHeight() / 2.0 - BreakoutVars.peremogaOr3rada.getHeight() / 2.0);
            BreakoutVars.gameStatus = 0;
            pause(1000);
        }
        if (BreakoutVars.numberOfRemovedBricks == BreakoutVars.numberOfBricks) {
            removeAll();
            setBackground(new Color(192, 185, 139));
            BreakoutVars.peremogaOr3rada = new GLabel("You won!");
            BreakoutVars.peremogaOr3rada.setFont("Courier New-30");
            add(BreakoutVars.peremogaOr3rada, getWidth() / 2.0 - BreakoutVars.peremogaOr3rada.getWidth() / 2.0, getHeight() / 2.0 - BreakoutVars.peremogaOr3rada.getHeight() / 2.0);
            BreakoutVars.gameStatus = 0;
            pause(1000);
        }
    }

    private void decreaseHeartNumbers() {
        if (BreakoutVars.numberOfRemovedBricks < BreakoutVars.numberOfBricks && BreakoutVars.ball.getY() >= getHeight()) {
            remove(BreakoutVars.ball);
            ball();
            BreakoutVars.heartsCheck--;
            BreakoutVars.numberOfHearts.setLabel(": " + BreakoutVars.heartsCheck);
        }

    }

    public static void play(String sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(sound)));
            clip.start();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private void showPoints() {
        BreakoutVars.points = new GImage("points.png");
        add(BreakoutVars.points, 0, 6);
        if (BreakoutVars.numberOfPoints != null) {
            remove(BreakoutVars.numberOfPoints);
        }
        BreakoutVars.numberOfPoints = new GLabel(": " + BreakoutVars.pointsCheck);
        BreakoutVars.numberOfPoints.setFont("ComicSans-36");
        add(BreakoutVars.numberOfPoints, BreakoutVars.points.getX() + BreakoutVars.points.getWidth(), BreakoutVars.points.getHeight() / 1.2);
    }

    private void addPoints() {
        BreakoutVars.numberOfPoints.setLabel(": " + BreakoutVars.pointsCheck);
    }
}