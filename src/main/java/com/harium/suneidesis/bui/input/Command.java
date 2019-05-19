package com.harium.suneidesis.bui.input;

import com.harium.suneidesis.bui.BUI;

import java.util.ArrayList;
import java.util.List;

public class Command {

    long id;
    String description;
    Action action;
    Action hotkey;

    List<Command> commands = new ArrayList<Command>();

    public Command() {
    }

    public Command(String description) {
        this.description = description;
    }

    public Command action(Action action) {
        this.action = action;
        return this;
    }

    public Command hotkey(Action hotkey) {
        this.hotkey = hotkey;
        return this;
    }

    public Command command(Command command) {
        this.commands.add(command);
        return this;
    }

    public void execute(BUI bui) {
        if (bui.onCommand(this)) {
            for (Command command : commands) {
                command.execute(bui);
            }

            if (hotkey != null) {
                bui.execute(hotkey);
            } else {
                bui.execute(action);
            }
        }
    }

    public String description() {
        return description;
    }

    public Action action() {
        return action;
    }

    public Action hotkey() {
        return hotkey;
    }
}
