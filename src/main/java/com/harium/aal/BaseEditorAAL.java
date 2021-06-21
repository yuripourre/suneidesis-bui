package com.harium.aal;

import com.harium.aal.input.Action;
import com.harium.aal.input.InputKey;
import com.harium.aal.engine.AALEngine;
import com.harium.aal.input.Command;

public abstract class BaseEditorAAL extends BaseAAL implements Editor {

    public static final String COPY = "copy";
    public static final String PASTE = "paste";
    public static final String UNDO = "undo";

    public BaseEditorAAL(AALEngine engine) {
        super(engine);
        initCommands();
    }

    private void initCommands() {
        Command copy = new Command(COPY).action(new Action().press(InputKey.CTRL).type(InputKey.C).release(InputKey.CTRL));
        commands.put(COPY, copy);

        Command paste = new Command(PASTE).action(new Action().press(InputKey.CTRL).type(InputKey.V).release(InputKey.CTRL));
        commands.put(PASTE, paste);

        Command undo = new Command(UNDO).action(new Action().press(InputKey.CTRL).type(InputKey.Z).release(InputKey.CTRL));
        commands.put(PASTE, undo);
    }

    public void copy() {
        execute(commands.get(COPY));
    }

    public void paste() {
        execute(commands.get(PASTE));
    }

}
