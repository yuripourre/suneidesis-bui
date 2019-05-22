package com.harium.suneidesis.aal;

import com.harium.suneidesis.aal.engine.AALEngine;

public abstract class VectorAAL extends EditorAAL {

    public static final String ZOOM_MODE = "Zoom Mode";
    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";
    public static final String ZOOM_RESET = "Zoom Reset";
    public static final String ZOOM_FIT_DRAWING = "Zoom Fit Drawing";
    public static final String ZOOM_FIT_PAGE = "Zoom Fit Page";

    public static final String BEZIER_TOOL = "Bezier Tool";
    public static final String CLOSE_PATH = "Close Path";

    public VectorAAL(AALEngine engine) {
        super(engine);
    }

    public void zoomIn() {
        execute(commands.get(ZOOM_IN));
    }

    public void zoomOut() {
        execute(commands.get(ZOOM_OUT));
    }

    public void zoomReset() {
        execute(commands.get(ZOOM_RESET));
    }

    public void zoomFitDrawing() {
        execute(commands.get(ZOOM_FIT_DRAWING));
    }

    public void zoomFitPage() {
        execute(commands.get(ZOOM_FIT_PAGE));
    }

    public void bezierTool() {
        execute(commands.get(BEZIER_TOOL));
    }

    public void closePath() {
        execute(commands.get(CLOSE_PATH));
    }
}
