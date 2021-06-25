package com.harium.aal.input;

public interface KeyboardInput {

    void typeKey(String keyLabel);

    void typeKey(InputKey keyCode);

    void pressKey(InputKey keyCode);

    void releaseKey(InputKey keyCode);

}
