package com.harium.suneidesis.aal.inkscape;

import com.harium.suneidesis.aal.VectorAAL;
import com.harium.suneidesis.aal.engine.AALEngine;
import com.harium.suneidesis.aal.input.Action;
import com.harium.suneidesis.aal.input.Command;

public class InkscapeAAL extends VectorAAL {

    private boolean zoomMode = false;

    public InkscapeAAL(AALEngine engine) {
        super(engine);
        init();
    }

    // TODO replace by file description
    private void init() {
        initOpen();
        initZoom();
        initTools();
    }

    private void initOpen() {
        add(new Command(START).action(new Action().run("inkscape")));
    }

    private void initZoom() {
        Command zoomMode = new Command(ZOOM_MODE).action(new Action().type("F3"));

        add(zoomMode);
        add(new Command(ZOOM_IN).command(zoomMode).action(new Action().type("+")));
        add(new Command(ZOOM_OUT).command(zoomMode).action(new Action().type("-")));
        add(new Command(ZOOM_RESET).command(zoomMode).action(new Action().type("1")));
        add(new Command(ZOOM_FIT_DRAWING).command(zoomMode).action(new Action().type("4")));
        add(new Command(ZOOM_FIT_PAGE).command(zoomMode).action(new Action().type("5")));
    }

    private void initTools() {
        add(new Command(BEZIER_TOOL).action(new Action().press("shift").type("F6").release("shift")));

        Command closePath = new Command(CLOSE_PATH);
        closePath.command(new Command().action(new Action().mouseMoveRelative(0, 10)));
        closePath.action(new Action().press("shift").type("enter").release("shift"));
        add(closePath);
    }

    private void add(Command command) {
        commands.put(command.description(), command);
    }

    public void onAction(Action action) {

    }

    public boolean onCommand(Command command) {
        // Log description
        System.out.println(command.description());

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
