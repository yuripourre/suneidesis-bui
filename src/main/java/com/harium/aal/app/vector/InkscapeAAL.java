package com.harium.aal.app.vector;

import com.harium.aal.BaseEditorApp;
import com.harium.aal.engine.AALEngine;
import com.harium.aal.input.InputKey;

public class InkscapeAAL extends BaseEditorApp implements VectorEditorAAL {

    private boolean zoomMode = false;

    public InkscapeAAL(AALEngine engine) {
        super(engine);
    }

    @Override
    public void open() {
        run("inkscape");
    }

    private void enableZoomMode() {
        if (!zoomMode) {
            engine.typeKey(InputKey.F3);
            zoomMode = true;
        }
    }

    @Override
    public void zoomIn() {
        enableZoomMode();
        engine.typeKey(InputKey.PLUS);
    }

    @Override
    public void zoomOut() {
        enableZoomMode();
        engine.typeKey(InputKey.MINUS);
    }

    @Override
    public void zoomReset() {
        enableZoomMode();
        engine.typeKey(InputKey.KEY_1);
    }

    @Override
    public void zoomFitDrawing() {
        enableZoomMode();
        engine.typeKey(InputKey.KEY_4);
    }

    @Override
    public void zoomFitPage() {
        enableZoomMode();
        engine.typeKey(InputKey.KEY_5);
    }

    @Override
    public void bezierTool() {
        zoomMode = false;
        engine.pressKey(InputKey.SHIFT);
        engine.typeKey(InputKey.F6);
        engine.releaseKey(InputKey.SHIFT);
    }

    @Override
    public void closePath() {
        zoomMode = false;
        engine.pressKey(InputKey.SHIFT);
        engine.typeKey(InputKey.ENTER);
        engine.releaseKey(InputKey.SHIFT);
    }

}
