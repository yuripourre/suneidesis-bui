package examples;

import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.engine.JavaRobotEngine;
import com.harium.suneidesis.bui.input.Input;
import com.harium.suneidesis.bui.input.InputAction;

public class MoveExample {

    private static BUIEngine engine;

    public static void main(String[] args) {
        engine = new JavaRobotEngine();
        engine.execute(new Input(InputAction.MOUSE_MOVE, 20, 40));
    }

}
