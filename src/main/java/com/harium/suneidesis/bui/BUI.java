package com.harium.suneidesis.bui;

import com.harium.suneidesis.bui.input.Action;
import com.harium.suneidesis.bui.input.Command;

public interface BUI {

    void onAction(Action action);

    boolean onCommand(Command command);

    void execute(Action action);

    void execute(Command command);

    void open();

    void close();
}
