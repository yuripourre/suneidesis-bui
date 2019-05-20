package com.harium.suneidesis.bui;

import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.input.Action;
import com.harium.suneidesis.bui.input.Command;
import com.harium.suneidesis.bui.input.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseBUI implements BUI {

    private boolean hotkeyPrefered = true;

    public static final String START = "Start";

    protected BUIEngine engine;

    public BaseBUI(BUIEngine engine) {
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
