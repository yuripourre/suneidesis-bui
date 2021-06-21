package com.harium.aal.engine;

import com.harium.aal.input.Input;

public interface AALEngine {

    void execute(Input input);

    void close();

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
