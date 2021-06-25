package examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harium.aal.engine.JavaRobotEngine;
import com.harium.aal.wm.GnomeManager;
import com.harium.aal.wm.Window;

import java.util.List;

public class WindowManipulation {

    public static void main(String[] args) throws JsonProcessingException {
        GnomeManager manager = new GnomeManager(new JavaRobotEngine());
        List<Window> windows = manager.listWindows();

        ObjectMapper mapper = new ObjectMapper();

        for (Window window : windows) {
            String json = mapper.writeValueAsString(window);
            System.out.println(json);
        }

        manager.activateWindow(windows.get(0));

    }

}
