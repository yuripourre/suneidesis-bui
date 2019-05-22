package com.harium.suneidesis.aal.input;

import java.awt.event.KeyEvent;

public enum InputKey {

    MINUS("-", KeyEvent.VK_MINUS),
    PLUS("+", KeyEvent.VK_PLUS),
    A("a", KeyEvent.VK_A),
    B("b", KeyEvent.VK_B),
    C("c", KeyEvent.VK_C),
    D("d", KeyEvent.VK_D),
    E("e", KeyEvent.VK_E),
    F("f", KeyEvent.VK_F),
    G("g", KeyEvent.VK_G),
    H("h", KeyEvent.VK_H),
    I("i", KeyEvent.VK_I),
    J("j", KeyEvent.VK_J),
    K("k", KeyEvent.VK_K),
    L("l", KeyEvent.VK_L),
    M("m", KeyEvent.VK_M),
    N("n", KeyEvent.VK_N),
    O("o", KeyEvent.VK_O),
    P("p", KeyEvent.VK_P),
    Q("q", KeyEvent.VK_Q),
    R("r", KeyEvent.VK_R),
    S("s", KeyEvent.VK_S),
    T("t", KeyEvent.VK_T),
    U("u", KeyEvent.VK_U),
    V("v", KeyEvent.VK_V),
    W("w", KeyEvent.VK_W),
    X("x", KeyEvent.VK_X),
    Y("y", KeyEvent.VK_Y),
    Z("z", KeyEvent.VK_Z),
    ALT("alt", KeyEvent.VK_ALT),
    CTRL("ctrl", KeyEvent.VK_CONTROL),
    SHIFT("shift", KeyEvent.VK_SHIFT),
    MOUSE_LEFT("mouse left", 10001),
    MOUSE_RIGHT("mouse right", 10002),
    MOUSE_MIDDLE("mouse middle", 10003),
    ENTER("enter", KeyEvent.VK_ENTER),
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

    public int code() {
        return code;
    }
}
