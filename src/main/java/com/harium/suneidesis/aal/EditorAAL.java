package com.harium.suneidesis.aal;

import com.harium.suneidesis.aal.engine.AALEngine;
import com.harium.suneidesis.aal.input.Action;
import com.harium.suneidesis.aal.input.Command;
import com.harium.suneidesis.aal.input.InputKey;

public abstract class EditorAAL extends BaseAAL {

    public static final String COPY = "copy";
    public static final String PASTE = "paste";
    public static final String UNDO = "undo";

    public EditorAAL(AALEngine engine) {
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


}
