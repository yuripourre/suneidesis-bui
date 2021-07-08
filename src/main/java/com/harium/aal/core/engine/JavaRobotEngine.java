package com.harium.aal.core.engine;

import com.harium.aal.core.input.InputKey;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRobotEngine implements AALEngine {

    int width, height;
    int mouseX, mouseY;

    Robot robot;

    public JavaRobotEngine() {
        init();
    }

    private void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        initRobot();
    }

    private void initRobot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private int mouseKey(int key) {
        if (key == InputKey.MOUSE_RIGHT.code()) {
            return InputEvent.BUTTON2_MASK;
        } else if (key == InputKey.MOUSE_MIDDLE.code()) {
            return InputEvent.BUTTON3_MASK;
        }

        return InputEvent.BUTTON1_MASK;
    }

    public Process run(final String ... command) {

        try {
            ProcessBuilder processBuilder = new ProcessBuilder().command(command).redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();
            return process;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String runOutput(String... command) {
        Process process = run(command);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Read the output from the command
        StringBuilder builder = new StringBuilder();
        String s = null;
        while (true) {
            try {
                if ((s = stdInput.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            builder.append(s);
        }
        return builder.toString();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void typeKey(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        typeKey(key);
    }

    @Override
    public void typeKey(InputKey key) {
        pressKey(key);
        delay(100);
        releaseKey(key);
    }

    @Override
    public void delay(int ms) {
        robot.delay(ms);
    }

    @Override
    public void mouseMove(int x, int y) {
        this.mouseX = x;
        this.mouseY = y;
        robot.mouseMove(mouseX, mouseY);
    }

    @Override
    public void mouseMoveRelative(int x, int y) {
        this.mouseX += x;
        this.mouseY += y;
        robot.mouseMove(mouseX, mouseY);
    }

    @Override
    public void mousePress(InputKey mouseKey) {
        robot.mousePress(mouseKey.code());
    }

    @Override
    public void mouseRelease(InputKey mouseLeft) {
        robot.mouseRelease(mouseLeft.code());
    }

    @Override
    public void pressKey(InputKey key) {
        robot.keyPress(key.code());
    }

    @Override
    public void releaseKey(InputKey key) {
        robot.keyRelease(key.code());
    }
}
