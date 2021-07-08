package examples;

import com.harium.aal.app.vector.InkscapeAAL;
import com.harium.aal.core.engine.AALEngine;
import com.harium.aal.core.engine.JavaRobotEngine;
import com.harium.aal.core.input.InputKey;

public class VectorRecordPlay {

    public static void main(String[] args) {
        AALEngine engine = new JavaRobotEngine();
        InkscapeAAL inkscape = new InkscapeAAL(engine);

        inkscape.open();
        engine.delay(2600);
        inkscape.zoomFitPage();
        engine.delay(800);
        inkscape.bezierTool();

        // Target page blob
        //routine.mouseMove(615,170);
        // TODO Move to draw SVG
        int sx = 800;
        int sy = 470;
        // Click
        // First Point
        engine.mouseMove(sx, sy);
        engine.mousePress(InputKey.MOUSE_LEFT);
        engine.mouseRelease(InputKey.MOUSE_LEFT);

        // Second Point
        engine.mouseMoveRelative(100, 100);
        engine.delay(200);
        // Control Point
        engine.mousePress(InputKey.MOUSE_LEFT);
        engine.delay(300);
        engine.mouseMoveRelative(100, 0);
        engine.delay(300);
        engine.mouseRelease(InputKey.MOUSE_LEFT);

        // Third Point
        engine.mouseMoveRelative(0, -100);
        engine.mousePress(InputKey.MOUSE_LEFT);
        engine.mouseRelease(InputKey.MOUSE_LEFT);
        engine.delay(500);

        inkscape.closePath();

        engine.delay(2500);
        inkscape.close();
    }

}
