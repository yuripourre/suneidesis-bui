package com.harium.aal.core.engine;

import com.harium.aal.core.input.KeyboardInput;
import com.harium.aal.core.input.MouseInput;

public interface AALEngine extends KeyboardInput, MouseInput {

    void delay(int ms);

    Process run(String ... command);

    String runOutput(String ... command);

    int getWidth();

    int getHeight();
}
