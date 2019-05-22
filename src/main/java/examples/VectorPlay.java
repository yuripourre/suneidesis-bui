package examples;

import com.harium.suneidesis.aal.VectorAAL;
import com.harium.suneidesis.aal.engine.AALEngine;
import com.harium.suneidesis.aal.engine.JavaRobotEngine;
import com.harium.suneidesis.aal.inkscape.InkscapeAAL;
import com.harium.suneidesis.aal.input.InputKey;

public class VectorPlay {

    public static void main(String[] args) {
        AALEngine engine = new JavaRobotEngine();
        VectorAAL inkscape = new InkscapeAAL(engine);

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
        int sy = 470;
        // Click
        // First Point
        routine.mouseMove(sx, sy);
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.mouseRelease(InputKey.MOUSE_LEFT);

        // Second Point
        routine.mouseMoveRelative(100, 100);
        routine.delay(200);
        // Control Point
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.delay(300);
        routine.mouseMoveRelative(100, 0);
        routine.delay(300);
        routine.mouseRelease(InputKey.MOUSE_LEFT);

        // Third Point
        routine.mouseMoveRelative(0, -100);
        routine.mousePress(InputKey.MOUSE_LEFT);
        routine.mouseRelease(InputKey.MOUSE_LEFT);
        routine.delay(500);

        routine.closePath();

        routine.delay(2500);
        routine.close();
    }

}
