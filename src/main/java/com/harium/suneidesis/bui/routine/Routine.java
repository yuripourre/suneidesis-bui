package com.harium.suneidesis.bui.routine;

import com.harium.suneidesis.bui.BUI;
import com.harium.suneidesis.bui.input.Command;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    protected BUI bui;
    protected List<Command> commands = new ArrayList<Command>();

    public Routine command(Command command) {
        this.commands.add(command);
        return this;
    }

    public void open() {
        bui.open();
    }

    public void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        bui.close();
    }
}
