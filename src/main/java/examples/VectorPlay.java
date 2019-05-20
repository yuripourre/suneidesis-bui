package examples;

import com.harium.suneidesis.bui.VectorBUI;
import com.harium.suneidesis.bui.engine.BUIEngine;
import com.harium.suneidesis.bui.engine.JavaRobotEngine;
import com.harium.suneidesis.bui.inkscape.InkscapeBUI;
import com.harium.suneidesis.bui.input.InputKey;

public class VectorPlay {

    public static void main(String[] args) {
        BUIEngine engine = new JavaRobotEngine();
        VectorBUI inkscape = new InkscapeBUI(engine);

        VectorRoutine routine = new VectorRoutine(inkscape);
        routine.open();
        routine.delay(2600);
        routine.zoomFitPage();
        routine.delay(800);
        routine.bezierTool();

        // Target page blob
        //routine.mouseMove(615,170);
        // TODO Move to draw SVG
        int sx = 800;
        int sy = 670;
        // Click
        // First Point
        routine.mouseMove(sx, sy);
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.mouseRelease(InputKey.MOUSE_LEFT);

        // Second Point
        routine.mouseMove(sx + 100, sy + 100);
        routine.delay(200);
        // Control Point
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.delay(300);
        routine.mouseMove(sx + 200, sy + 100);
        routine.delay(300);
        routine.mouseRelease(InputKey.MOUSE_LEFT);

        // Third Point
        routine.mouseMove(sx + 200, sy);
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.mouseRelease(InputKey.MOUSE_LEFT);
        routine.delay(500);

        routine.closePath();

        routine.delay(2500);
        routine.close();
    }

}
