package com.harium.suneidesis.aal;

import com.harium.suneidesis.aal.input.Action;
import com.harium.suneidesis.aal.input.Command;

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
