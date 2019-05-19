package com.harium.suneidesis.bui.engine;

import com.harium.suneidesis.bui.input.Input;

public interface BUIEngine {

    void execute(Input input);

    void close();
}
