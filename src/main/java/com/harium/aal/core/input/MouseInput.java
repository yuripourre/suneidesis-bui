package com.harium.aal.core.input;

public interface MouseInput {

    int getMouseX();

    int getMouseY();

    void mouseMove(int x, int y);

    void mouseMoveRelative(int dx, int dy);

    void mousePress(InputKey mouseLeft);

    void mouseRelease(InputKey mouseLeft);

}
