package com.harium.suneidesis.bui.input;

import java.awt.event.KeyEvent;

public enum InputKey {

    PLUS("+", KeyEvent.VK_PLUS),
    F1("F1", KeyEvent.VK_F1),
    F2("F2", KeyEvent.VK_F2),
    F3("F3", KeyEvent.VK_F3),
    F4("F4", KeyEvent.VK_F4),

    F12("F12", KeyEvent.VK_F12);

    String label;
    int code;

    InputKey(String label, int code) {
        this.label = label;
        this.code = code;
    }

    public static InputKey findByLabel(String keyLabel) {
        for (InputKey key : values()) {
            if (key.label.equals(keyLabel)) {
                return key;
            }
        }
        return null;
    }
}
