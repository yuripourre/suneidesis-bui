package examples;

import com.harium.aal.BaseVectorAAL;
import com.harium.aal.routine.Routine;

public class VectorEditor extends Routine {

    private BaseVectorAAL bui;

    public VectorEditor(BaseVectorAAL bui) {
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
