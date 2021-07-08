package com.harium.aal.core.input;

import java.awt.*;

public class JavaRobotKeyboardInput implements KeyboardInput {

    public static final int DELAY_TYPE = 200;

    private Robot robot;

    public JavaRobotKeyboardInput() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void typeKey(String charCode) {
        InputKey key = InputKey.findByLabel(charCode);
        typeKey(key);
    }

    @Override
    public void typeKey(InputKey keyCode) {
        pressKey(keyCode);
        robot.delay(DELAY_TYPE);
        releaseKey(keyCode);
    }

    @Override
    public void pressKey(InputKey keyCode) {
        robot.keyPress(keyCode.code);
    }

    @Override
    public void releaseKey(InputKey keyCode) {
        robot.keyRelease(keyCode.code);
    }
}
