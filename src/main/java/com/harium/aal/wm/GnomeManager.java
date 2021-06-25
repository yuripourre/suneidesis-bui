package com.harium.aal.wm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harium.aal.engine.AALEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GnomeManager implements WindowManager {

    protected final AALEngine engine;

    public GnomeManager(AALEngine engine) {
        this.engine = engine;
    }

    @Override
    public List<Window> getWindows() {
        // https://unix.stackexchange.com/a/635740
        String[] command = new String[]{
            "gdbus","call","--session","--dest", "org.gnome.Shell","--object-path","/org/gnome/Shell","--method","org.gnome.Shell.Eval",
                "\"global.get_window_actors()"
                        + ".map(a=>a.meta_window)"
                        + ".map(w=>({class: w.get_wm_class(), title: w.get_title(), active: w.has_focus()}))\""
        };

        Process process = engine.run(command);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Read the output from the command
        StringBuilder builder = new StringBuilder();
        String s = null;
        while (true) {
            try {
                if ((s = stdInput.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
            builder.append(s);
        }

        String data = builder.toString();
        return parseWindows(data);
    }

    private List<Window> parseWindows(String data) {
                try {
            String json = data.substring(data.indexOf("["), data.lastIndexOf("]")+1);
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            JsonNode node = objectMapper.readTree(json);

            List<Window> windows = new ArrayList<>();
            for(JsonNode n:node) {
                Window window = new Window();
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
