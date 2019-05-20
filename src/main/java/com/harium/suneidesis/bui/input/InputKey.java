package com.harium.suneidesis.bui.input;

import java.awt.event.KeyEvent;

public enum InputKey {

    MINUS("-", KeyEvent.VK_MINUS),
    PLUS("+", KeyEvent.VK_PLUS),
    A("A", KeyEvent.VK_A),
    ALT("alt", KeyEvent.VK_ALT),
    CTRL("ctrl", KeyEvent.VK_CONTROL),
    SHIFT("shift", KeyEvent.VK_SHIFT),
    KEY_1("1", KeyEvent.VK_1),
    KEY_2("2", KeyEvent.VK_2),
    KEY_3("3", KeyEvent.VK_3),
    KEY_4("4", KeyEvent.VK_4),
    KEY_5("5", KeyEvent.VK_5),
    KEY_6("6", KeyEvent.VK_6),
    KEY_7("7", KeyEvent.VK_7),
    KEY_8("8", KeyEvent.VK_8),
    KEY_9("9", KeyEvent.VK_9),
    KEY_0("0", KeyEvent.VK_0),
    F1("F1", KeyEvent.VK_F1),
    F2("F2", KeyEvent.VK_F2),
    F3("F3", KeyEvent.VK_F3),
    F4("F4", KeyEvent.VK_F4),
    F5("F5", KeyEvent.VK_F5),
    F6("F6", KeyEvent.VK_F6),
    F7("F7", KeyEvent.VK_F7),
    F8("F8", KeyEvent.VK_F8),
    F9("F9", KeyEvent.VK_F9),
    F10("F10", KeyEvent.VK_F10),
    F11("F11", KeyEvent.VK_F11),
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

        System.err.println("Key: " + keyLabel + " not found.");
        return null;
    }
}
