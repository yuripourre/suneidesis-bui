package com.harium.aal.core.action;

import com.harium.aal.core.engine.AALEngine;
import com.harium.aal.core.input.InputKey;

public class ActionExecutor {

    public static void execute(Action action, AALEngine engine) {
        if (MouseAction.MOUSE_MOVE.equals(action.action)) {
            MouseAction ma = (MouseAction) action;
            engine.mouseMove(ma.x, ma.y);
        } else if (MouseAction.MOUSE_DOWN.equals(action.action)) {
            MouseAction ma = (MouseAction) action;
            InputKey button = getButton(ma.button);
            engine.mousePress(button);
        } else if (MouseAction.MOUSE_UP.equals(action.action)) {
            MouseAction ma = (MouseAction) action;
            InputKey button = getButton(ma.button);
            engine.mouseRelease(button);
        }
    }

    private static InputKey getButton(int button) {
        if (button == 2) {
            return InputKey.MOUSE_RIGHT;
        } else if (button == 1) {
            return InputKey.MOUSE_MIDDLE;
        }

        return InputKey.MOUSE_LEFT;
    }

}
