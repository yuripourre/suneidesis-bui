package com.harium.aal;

import com.harium.aal.core.engine.AALEngine;
import com.harium.aal.core.input.InputKey;

public abstract class BaseApp implements App {

    protected final AALEngine engine;

    protected Process process;

    public BaseApp(AALEngine engine) {
        this.engine = engine;
    }

    public abstract void open();

    public void close() {
        if (process != null) {
            process.destroy();
            process = null;
        } else {
            // Check if is open and than alt+f4?
        }
    }

    protected void run(final String ... command) {
        new Thread(new Runnable() {
            public void run() {
                process = engine.run(command);
            }
        }).start();
    }

    protected void input(InputKey key) {
        engine.typeKey(key);
    }

}
