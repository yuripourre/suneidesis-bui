package com.harium.suneidesis.bui;

import com.harium.suneidesis.bui.engine.BUIEngine;

public abstract class VectorBUI extends BaseBUI {

    public static final String ZOOM_MODE = "Zoom Mode";
    public static final String ZOOM_IN = "Zoom In";
    public static final String ZOOM_OUT = "Zoom Out";
    public static final String ZOOM_RESET = "Zoom Reset";

    public VectorBUI(BUIEngine engine) {
        super(engine);
    }
}
