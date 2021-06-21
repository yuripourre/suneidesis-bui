package com.harium.aal.input;

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

    public String description() {
        return description;
    }

    public Action action() {
        return action;
    }

    public Action hotkey() {
        return hotkey;
    }

    public List<Command> commands() {
        return commands;
    }
}
