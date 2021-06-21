package com.harium.aal.input;

import java.util.ArrayList;
import java.util.List;

import static com.harium.aal.input.InputAction.*;

/**
 * Play to dispatch input commands
 */
public class Action {

    private long delay = 100;
    private List<Input> inputs = new ArrayList<Input>();

    public Action delay(long delay) {
        inputs.add(new Input(WAIT, delay));
        return this;
    }

    public Action press(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(PRESS, key));
        return this;
    }

    public Action press(InputKey key) {
        inputs.add(new Input(PRESS, key));
        return this;
    }

    public Action release(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(RELEASE, key));
        return this;
    }

    public Action release(InputKey key) {
        inputs.add(new Input(RELEASE, key));
        return this;
    }

    public Action type(String command) {
        press(command);
        delay(delay);
        release(command);
        return this;
    }

    public Action type(InputKey key) {
        press(key);
        delay(delay);
        release(key);
        return this;
    }

    public List<Input> inputs() {
        return inputs;
    }

    public Action run(String command) {
        inputs.add(new Input(RUN_COMMAND, command));
        return this;
    }

    public Action mouseMove(int x, int y) {
        inputs.add(new Input(MOUSE_MOVE, x, y));
        return this;
    }

    public Action mousePress(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(MOUSE_PRESSED, key));
        return this;
    }

    public Action mousePress(InputKey key) {
        inputs.add(new Input(MOUSE_PRESSED, key));
        return this;
    }

    public Action mouseRelease(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(MOUSE_RELEASED, key));
        return this;
    }

    public Action mouseRelease(InputKey key) {
        inputs.add(new Input(MOUSE_RELEASED, key));
        return this;
    }

    public Action mouseMoveRelative(int dx, int dy) {
        inputs.add(new Input(MOUSE_MOVE_RELATIVE, dx, dy));
        return this;
    }

}
