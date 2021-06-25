package com.harium.aal.wm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harium.aal.engine.AALEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gdbus Manager
 * https://gjs-docs.gnome.org/
 * https://gjs-docs.gnome.org/meta8~8_api/meta.window
 */
public class GnomeManager implements WindowManager {

    protected final AALEngine engine;

    public GnomeManager(AALEngine engine) {
        this.engine = engine;
    }

    /**
     * https://unix.stackexchange.com/a/635740
     * @return
     */
    @Override
    public List<Window> listWindows() {
        String[] command = new String[]{
            "gdbus","call","--session","--dest", "org.gnome.Shell","--object-path","/org/gnome/Shell","--method","org.gnome.Shell.Eval",
                "\"global.get_window_actors()"
                        + ".map(a=>a.meta_window)"
                        + ".map(w=>({"
                        + "id: w.get_id(),"
                        + "class: w.get_wm_class(),"
                        + "title: w.get_title(),"
                        + "active: w.has_focus(),"
                        + "pid: w.get_pid(),"
                        + "}))\""
        };

        String output = engine.runOutput(command);
        return parseWindows(output);
    }

    @Override
    public void activateWindow(Window window) {
        long id = window.id;

        String[] command = new String[]{
                "gdbus","call","--session","--dest", "org.gnome.Shell","--object-path","/org/gnome/Shell","--method","org.gnome.Shell.Eval",
                "\"global.get_window_actors()"
                        + ".map(a=>a.meta_window)"
                        + ".find(w=>w.get_id() == " + id+ ").activate(0)\""
        };

        engine.run(command);
    }

    @Override
    public void closeWindow(Window window) {
        long id = window.id;

        String[] command = new String[]{
                "gdbus","call","--session","--dest", "org.gnome.Shell","--object-path","/org/gnome/Shell","--method","org.gnome.Shell.Eval",
                "\"global.get_window_actors()"
                        + ".map(a=>a.meta_window)"
                        + ".find(w=>w.get_id() == " + id+ ").kill()\""
        };

        engine.run(command);
    }

    @Override
    public void restart() {
        String[] command = new String[] { "shutdown", "-r", "0" };
        engine.run(command);
    }

    @Override
    public void shutdown() {
        String[] command = new String[] { "shutdown", "-h", "0" };
        engine.run(command);
    }

    private List<Window> parseWindows(String data) {
        try {
            String json = data.substring(data.indexOf("["), data.lastIndexOf("]") + 1);
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            JsonNode node = objectMapper.readTree(json);

            List<Window> windows = new ArrayList<>();
            for (JsonNode n : node) {
                Window window = new Window();
                window.id = n.get("id").asLong();
                window.pid = n.get("pid").asLong();
                window.active = n.get("active").asBoolean();
                window.app = n.get("class").asText();
                window.title = n.get("title").asText();
                windows.add(window);
            }

            return windows;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
