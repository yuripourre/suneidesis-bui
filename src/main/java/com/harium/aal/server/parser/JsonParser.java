package com.harium.aal.server.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harium.aal.core.action.Action;
import com.harium.aal.core.action.ActionParser;
import com.harium.aal.core.action.MouseAction;

public class JsonParser implements ActionParser {

    private static final String FIELD_ACTION = "action";
    private static final String FIELD_BUTTON = "button";
    private static final String FIELD_X = "x";
    private static final String FIELD_Y = "y";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Action parse(byte[] data) {
        String json = new String(data);

        try {
            JsonNode obj = objectMapper.readTree(json);
            return parseAction(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Action parseAction(JsonNode obj) {
        String action = obj.get(FIELD_ACTION).asText();
        if (MouseAction.MOUSE_MOVE.equals(action)) {
            int x = obj.get(FIELD_X).asInt();
            int y = obj.get(FIELD_Y).asInt();
            return MouseAction.mouseMove(x, y);
        } else if (MouseAction.MOUSE_DOWN.equals(action)) {
            int x = obj.get(FIELD_X).asInt();
            int y = obj.get(FIELD_Y).asInt();
            int button = obj.get(FIELD_BUTTON).asInt();
            return MouseAction.mouseDown(x, y, button);
        } else if (MouseAction.MOUSE_UP.equals(action)) {
            int button = obj.get(FIELD_BUTTON).asInt();
            return MouseAction.mouseUp(button);
        }
        return null;
    }
}
