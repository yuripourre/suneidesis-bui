package com.harium.aal.input;

public class Input {

    private InputAction inputAction;
    private InputKey key;

    private int x;
    private int y;

    private String command;
    private long delay;

    public Input(InputAction inputAction, InputKey key) {
        this.inputAction = inputAction;
        this.key = key;
    }

    public Input(InputAction inputAction, int x, int y) {
        this.inputAction = inputAction;
        this.x = x;
        this.y = y;
    }

    public Input(InputAction action, String command) {
        this.inputAction = action;
        this.command = command;
    }

    public Input(InputAction action, long delay) {
        this.inputAction = action;
        this.delay = delay;
    }

    public InputAction action() {
        return inputAction;
    }

    public int key() {
        return key.code;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Input command(String command) {
        this.command = command;
        return this;
    }

    public String command() {
        return command;
    }

    public long delay() {
        return delay;
    }
}
