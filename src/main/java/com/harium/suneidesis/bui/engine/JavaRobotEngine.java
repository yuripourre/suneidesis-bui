package com.harium.suneidesis.bui.engine;

import com.harium.suneidesis.bui.input.Input;

import java.awt.*;
import java.io.IOException;

public class JavaRobotEngine implements BUIEngine {

    Process pr;
    Robot robot;

    public JavaRobotEngine() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void execute(Input input) {
        switch (input.action()) {
            case PRESS:
                robot.keyPress(input.key());
                break;
            case RELEASE:
                robot.keyRelease(input.key());
                break;
            case MOUSE_MOVE:
                robot.mouseMove(input.x(), input.y());
                break;
            case RUN_COMMAND:
                execute(input.command());
                break;
        }

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

}
