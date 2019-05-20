package com.harium.suneidesis.bui.input;

import java.util.ArrayList;
import java.util.List;

import static com.harium.suneidesis.bui.input.InputAction.*;

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

    public Action release(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(RELEASE, key));
        return this;
    }

    public Action type(String command) {
        press(command);
        delay(delay);
        release(command);
        return this;
    }

    public List<Input> inputs() {
        return inputs;
    }

    public Action run(String command) {
        inputs.add(new Input(RUN_COMMAND, command));
        return this;
    }
}
