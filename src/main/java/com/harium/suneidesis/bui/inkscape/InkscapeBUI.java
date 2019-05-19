package com.harium.suneidesis.bui.inkscape;

import com.harium.suneidesis.bui.input.Action;
import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.input.Command;
import com.harium.suneidesis.bui.VectorBUI;

public class InkscapeBUI extends VectorBUI {

    private boolean zoomMode = false;

    public InkscapeBUI(BUIEngine engine) {
        super(engine);
        init();
    }

    // TODO replace by file description
    private void init() {
        initOpen();
        initZoom();
    }

    private void initOpen() {
        add(new Command(START).action(new Action().run("inkscape")));
    }

    private void initZoom() {
        Command zoomMode = new Command(ZOOM_MODE).action(new Action().press("F3"));

        add(zoomMode);
        add(new Command(ZOOM_IN).command(zoomMode).action(new Action().press("+")));
        add(new Command(ZOOM_OUT).command(zoomMode).action(new Action().press("-")));
        add(new Command(ZOOM_RESET).command(zoomMode).action(new Action().press("1")));
    }

    private void add(Command command) {
        commands.put(command.description(), command);
    }

    public void onAction(Action action) {

    }

    public boolean onCommand(Command command) {
        if (ZOOM_MODE.equals(command.description())) {
            if (!zoomMode) {
                zoomMode = true;
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

}
