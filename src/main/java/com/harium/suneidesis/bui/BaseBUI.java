package com.harium.suneidesis.bui;

import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.input.Action;
import com.harium.suneidesis.bui.input.Command;
import com.harium.suneidesis.bui.input.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseBUI implements BUI {

    public static final String START = "Start";

    private BUIEngine engine;

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
        List<Input> inputs = action.inputs();
        for (Input input : inputs) {
            engine.execute(input);
        }
    }

    public void execute(Command command) {
        Action hotkey = command.hotkey();
        if (hotkey != null) {
            execute(hotkey);
        } else {
            execute(command.action());
        }
    }
}
