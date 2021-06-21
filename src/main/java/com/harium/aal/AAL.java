package com.harium.aal;

import com.harium.aal.input.Action;
import com.harium.aal.input.Command;

public interface AAL {

    void onAction(Action action);

    boolean onCommand(Command command);

    void execute(Action action);

    void execute(Command command);

    void open();

    void close();

    int getX();

    int getY();
}
