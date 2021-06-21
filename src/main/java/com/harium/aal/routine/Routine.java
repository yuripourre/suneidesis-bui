package com.harium.aal.routine;

import com.harium.aal.AAL;
import com.harium.aal.input.Action;
import com.harium.aal.input.Command;
import com.harium.aal.input.InputKey;

import java.util.ArrayList;
import java.util.List;

public class Routine {

    protected AAL aal;
    protected List<Command> commands = new ArrayList<Command>();

    public Routine(AAL aal) {
        this.aal = aal;
    }

    public Routine command(Command command) {
        this.commands.add(command);
        return this;
    }

    public void open() {
        aal.open();
    }

    public void delay(long time) {
        aal.execute(new Action().delay(time));
    }

    public void close() {
        aal.close();
    }

    public void mouseMove(int x, int y) {
        aal.execute(new Action().mouseMove(x, y));
    }

    public void mouseMoveRelative(int x, int y) {
        aal.execute(new Action().mouseMoveRelative(x, y));
    }

    public void press(String label) {
        aal.execute(new Action().press(label));
    }

    public void release(String label) {
        aal.execute(new Action().release(label));
    }

    public void type(String label) {
        aal.execute(new Action().type(label));
    }

    public void mousePress(String label) {
        aal.execute(new Action().mousePress(label));
    }

    public void mouseRelease(String label) {
        aal.execute(new Action().mouseRelease(label));
    }

    public void mousePress(InputKey key) {
        aal.execute(new Action().mousePress(key));
    }

    public void mouseRelease(InputKey key) {
        aal.execute(new Action().mouseRelease(key));
    }
}
