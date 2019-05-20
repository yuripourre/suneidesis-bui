package examples;

import com.harium.suneidesis.bui.VectorBUI;
import com.harium.suneidesis.bui.routine.Routine;

public class VectorRoutine extends Routine {

    private VectorBUI bui;

    public VectorRoutine(VectorBUI bui) {
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
}
