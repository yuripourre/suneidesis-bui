package examples;

import com.harium.aal.engine.JavaRobotEngine;
import com.harium.aal.wm.GnomeManager;
import com.harium.aal.wm.Window;

import java.util.List;

public class WindowManipulation {

    public static void main(String[] args) {
        GnomeManager manager = new GnomeManager(new JavaRobotEngine());
        List<Window> windows = manager.getWindows();

        System.out.println(windows.size());
    }

}
