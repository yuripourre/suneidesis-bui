package com.harium.aal.core.action;

public class MouseAction extends Action {

    public static final String MOUSE_MOVE = "mouse move";
    public static final String MOUSE_UP = "mouse up";
    public static final String MOUSE_DOWN = "mouse down";

    public int x;
    public int y;
    public int button;

    public static MouseAction mouseDown(int x, int y, int button) {
        MouseAction action = new MouseAction();
        action.action = MOUSE_DOWN;
        action.x = x;
        action.y = y;
        action.button = button;

        return action;
    }

    public static MouseAction mouseUp(int button) {
        MouseAction action = new MouseAction();
        action.action = MOUSE_UP;
        action.button = button;

        return action;
    }

    public static MouseAction mouseMove(int x, int y) {
        MouseAction action = new MouseAction();
        action.action = MOUSE_MOVE;
        action.x = x;
        action.y = y;

        return action;
    }
}
