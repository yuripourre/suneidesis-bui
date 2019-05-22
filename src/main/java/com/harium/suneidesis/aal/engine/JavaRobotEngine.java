package com.harium.suneidesis.aal.engine;

import com.harium.suneidesis.aal.input.Input;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;

import static com.harium.suneidesis.aal.input.InputKey.MOUSE_MIDDLE;
import static com.harium.suneidesis.aal.input.InputKey.MOUSE_RIGHT;

public class JavaRobotEngine implements AALEngine {

    int width, height;
    int x, y;

    Process pr;
    Robot robot;

    public JavaRobotEngine() {
        init();
        initRobot();
    }

    private void initRobot() {
        try {
            robot = new Robot();
            setup(robot);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
    }

    private static void setup(Robot robot) {
        robot.setAutoWaitForIdle(true);
        robot.delay(150);
        robot.waitForIdle();
    }

    public void execute(Input input) {
        System.out.println(input.action());

        switch (input.action()) {
            case PRESS:
                robot.keyPress(input.key());
                break;
            case RELEASE:
                robot.keyRelease(input.key());
                break;
            case WAIT:
                robot.delay((int) input.delay());
                break;
            case MOUSE_MOVE:
                x = input.x();
                y = input.y();
                robot.mouseMove(x, y);
                System.out.println("x: "+x);
                System.out.println("y: "+y);
                break;
            case MOUSE_MOVE_RELATIVE:
                x += input.x();
                y += input.y();
                robot.mouseMove(x, y);
                System.out.println("x: "+x);
                System.out.println("y: "+y);
                break;
            case MOUSE_PRESSED:
                int pkey = mouseKey(input.key());
                robot.mousePress(pkey);
                break;
            case MOUSE_RELEASED:
                int rkey = mouseKey(input.key());
                robot.mouseRelease(rkey);
                break;
            case RUN_COMMAND:
                execute(input.command());
                break;
        }
    }

    private int mouseKey(int key) {
        if (key == MOUSE_RIGHT.code()) {
            return InputEvent.BUTTON2_MASK;
        } else if (key == MOUSE_MIDDLE.code()) {
            return InputEvent.BUTTON3_MASK;
        }

        return InputEvent.BUTTON1_MASK;
    }

    private void execute(final String command) {
        new Thread(new Runnable() {
            public void run() {
                Runtime rt = Runtime.getRuntime();
                try {
                    pr = rt.exec(command);
                    pr.waitFor();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void close() {
        pr.destroy();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
