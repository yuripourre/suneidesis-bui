package examples;

import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.engine.JavaRobotEngine;
import com.harium.suneidesis.bui.VectorBUI;
import com.harium.suneidesis.bui.inkscape.InkscapeBUI;

public class VectorPlay {

    public static void main(String[] args) {
        BUIEngine engine = new JavaRobotEngine();
        VectorBUI inkscape = new InkscapeBUI(engine);

        VectorRoutine routine = new VectorRoutine(inkscape);
        routine.open();
        routine.delay(5000);
        routine.close();
    }

}
