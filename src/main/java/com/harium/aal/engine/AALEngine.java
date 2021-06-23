package com.harium.aal.engine;

import com.harium.aal.input.InputKey;

public interface AALEngine {

    void typeKey(InputKey key);

    void pressKey(InputKey key);

    void releaseKey(InputKey key);

    void delay(int ms);

    void mouseMove(int x, int y);

    void mouseMoveRelative(int i, int i1);

    void mousePress(InputKey mouseLeft);

    void mouseRelease(InputKey mouseLeft);

    Process run(String ... command);

    int getMouseX();

    int getMouseY();

    int getWidth();

    int getHeight();
}
