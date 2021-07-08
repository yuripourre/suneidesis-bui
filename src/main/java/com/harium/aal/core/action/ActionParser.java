package com.harium.aal.core.action;

import com.harium.aal.core.action.Action;

public interface ActionParser {

    Action parse(byte[] data);

}
