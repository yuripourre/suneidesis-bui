package com.harium.suneidesis.aal.engine;

import com.harium.suneidesis.aal.input.Input;

public interface AALEngine {

    void execute(Input input);

    void close();

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
