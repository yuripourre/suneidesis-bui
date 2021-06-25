package com.harium.aal.wm;

import java.util.List;

public interface WindowManager {

    List<Window> listWindows();

    void activateWindow(Window window);

    void closeWindow(Window window);

    void restart();

    void shutdown();

}
