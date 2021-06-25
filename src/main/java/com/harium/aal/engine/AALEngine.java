package com.harium.aal.engine;

import com.harium.aal.input.KeyboardInput;
import com.harium.aal.input.MouseInput;

public interface AALEngine extends KeyboardInput, MouseInput {

    void delay(int ms);

    Process run(String ... command);

    String runOutput(String ... command);

    int getWidth();

    int getHeight();
}
