package examples;

import com.harium.suneidesis.aal.engine.AALEngine;
import com.harium.suneidesis.aal.engine.JavaRobotEngine;
import com.harium.suneidesis.aal.input.Input;
import com.harium.suneidesis.aal.input.InputAction;

public class MoveExample {

    private static AALEngine engine;

    public static void main(String[] args) {
        engine = new JavaRobotEngine();
        engine.execute(new Input(InputAction.MOUSE_MOVE, 20, 40));
    }

}
