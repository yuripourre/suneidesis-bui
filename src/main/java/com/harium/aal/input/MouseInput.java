package com.harium.aal.input;

public interface MouseInput {

    int getMouseX();

    int getMouseY();

    void mouseMove(int x, int y);

    void mouseMoveRelative(int i, int i1);

    void mousePress(InputKey mouseLeft);

    void mouseRelease(InputKey mouseLeft);

}
