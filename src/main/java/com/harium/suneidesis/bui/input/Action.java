package com.harium.suneidesis.bui.input;

import java.util.ArrayList;
import java.util.List;

import static com.harium.suneidesis.bui.input.InputAction.PRESS;
import static com.harium.suneidesis.bui.input.InputAction.RUN_COMMAND;

/**
 * Play to dispatch input commands
 */
public class Action {

    private int delay = 50;

    private List<Input> inputs = new ArrayList<Input>();

    /*public void execute() {
        for (Input input : inputs) {
            execute(input);
        }
    }

    private void execute(Input input) {

    }*/

    public Action press(String keyLabel) {
        InputKey key = InputKey.findByLabel(keyLabel);
        inputs.add(new Input(PRESS, key));
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
