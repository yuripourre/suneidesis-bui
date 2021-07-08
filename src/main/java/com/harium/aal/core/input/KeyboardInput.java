package com.harium.aal.core.input;

public interface KeyboardInput {

    void typeKey(String keyLabel);

    void typeKey(InputKey keyCode);

    void pressKey(InputKey keyCode);

    void releaseKey(InputKey keyCode);

}
