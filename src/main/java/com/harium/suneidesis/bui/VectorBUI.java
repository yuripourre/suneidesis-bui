package com.harium.suneidesis.bui;

import com.harium.suneidesis.bui.engine.BUIEngine;

public abstract class VectorBUI extends BaseBUI {

    public static final String ZOOM_MODE = "Zoom Mode";
    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";
    public static final String ZOOM_RESET = "Zoom Reset";
    public static final String ZOOM_FIT_DRAWING = "Zoom Fit Drawing";
    public static final String ZOOM_FIT_PAGE = "Zoom Fit Page";

    public static final String BEZIER_TOOL = "Bezier Tool";

    public VectorBUI(BUIEngine engine) {
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
}
