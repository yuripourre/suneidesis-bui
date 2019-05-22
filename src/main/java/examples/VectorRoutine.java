package examples;

import com.harium.suneidesis.aal.VectorAAL;
import com.harium.suneidesis.aal.routine.Routine;

public class VectorRoutine extends Routine {

    private VectorAAL bui;

    public VectorRoutine(VectorAAL bui) {
        super(bui);
        this.bui = bui;
    }

    public void zoomIn() {
        bui.zoomIn();
    }

    public void zoomOut() {
        bui.zoomOut();
    }

    public void zoomReset() {
        bui.zoomReset();
    }

    public void zoomFitDrawing() {
        bui.zoomFitDrawing();
    }

    public void zoomFitPage() {
        bui.zoomFitPage();
    }

    public void bezierTool() {
        bui.bezierTool();
    }

    public void closePath() {
        bui.closePath();
    }
}
