package com.harium.suneidesis.bui.engine;

import com.harium.suneidesis.bui.input.Input;

public interface BUIEngine {

    void execute(Input input);

    void close();

    int getX();

    int getY();

    int getWidth();

    int getHeight();
}
