package com.harium.aal;

import com.harium.aal.engine.AALEngine;
import com.harium.aal.input.InputKey;

public abstract class BaseEditorApp extends BaseApp implements Editor {

    public BaseEditorApp(AALEngine engine) {
        super(engine);
    }

    @Override
    public void copy() {
        engine.pressKey(InputKey.CTRL);
        engine.typeKey(InputKey.C);
        engine.releaseKey(InputKey.CTRL);
    }

    @Override
    public void paste() {
        engine.pressKey(InputKey.CTRL);
        engine.typeKey(InputKey.V);
        engine.releaseKey(InputKey.CTRL);
    }

    @Override
    public void undo() {
        engine.pressKey(InputKey.CTRL);
        engine.typeKey(InputKey.Z);
        engine.releaseKey(InputKey.CTRL);
    }
}
