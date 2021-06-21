package com.harium.aal;

import com.harium.aal.engine.AALEngine;
import com.harium.aal.input.Action;
import com.harium.aal.input.Command;
import com.harium.aal.input.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseAAL implements AAL {

    private boolean hotkeyPrefered = true;

    public static final String START = "Start";

    protected AALEngine engine;

    public BaseAAL(AALEngine engine) {
        this.engine = engine;
    }

    protected Map<String, Command> commands = new HashMap<String, Command>();

    public void open() {
        Command start = commands.get(START);
        if (start != null) {
            execute(start);
        }
    }

    public void close() {
        engine.close();
    }

    public void execute(Action action) {
        if (action == null || action.inputs() == null) {
            return;
        }
        List<Input> inputs = action.inputs();
        for (Input input : inputs) {
            engine.execute(input);
        }
    }

    public void execute(Command command) {
        for (Command c : command.commands()) {
            execute(c);
        }
        if (onCommand(command)) {
            if (hotkeyPrefered && command.hotkey() != null) {
                execute(command.hotkey());
            } else {
                execute(command.action());
            }
        }
    }

    public int getX() {
        return engine.getX();
    }

    public int getY() {
        return engine.getY();
    }
}
