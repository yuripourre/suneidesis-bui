package com.harium.suneidesis.bui.routine;

import com.harium.suneidesis.bui.BUI;
import com.harium.suneidesis.bui.input.Action;
import com.harium.suneidesis.bui.input.Command;
import com.harium.suneidesis.bui.input.InputKey;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    protected BUI bui;
    protected List<Command> commands = new ArrayList<Command>();

    public Routine(BUI bui) {
        this.bui = bui;
    }

    public Routine command(Command command) {
        this.commands.add(command);
        return this;
    }

    public void open() {
        bui.open();
    }

    public void delay(long time) {
        bui.execute(new Action().delay(time));
    }

    public void close() {
        bui.close();
    }

    public void mouseMove(int x, int y) {
        bui.execute(new Action().mouseMove(x, y));
    }

    public void mouseMoveRelative(int x, int y) {
        bui.execute(new Action().mouseMove(bui.getX()+x, bui.getY()+y));
    }

    public void press(String label) {
        bui.execute(new Action().press(label));
    }

    public void release(String label) {
        bui.execute(new Action().release(label));
    }

    public void type(String label) {
        bui.execute(new Action().type(label));
    }

    public void mousePress(String label) {
        bui.execute(new Action().mousePress(label));
    }

    public void mouseRelease(String label) {
        bui.execute(new Action().mouseRelease(label));
    }

    public void mousePress(InputKey key) {
        bui.execute(new Action().mousePress(key));
    }

    public void mouseRelease(InputKey key) {
        bui.execute(new Action().mouseRelease(key));
    }
}
