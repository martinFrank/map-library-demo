package de.elite.games.maplibdemo.map;

import de.elite.games.maplibdemo.mapdata.MapPointData;
import de.elite.games.maplib.AbstractPoint;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapPoint extends AbstractPoint<MapPointData> {

    private MapPointData mapPointData;

    /**
     * A Point at a certain location
     *
     * @param x location
     * @param y
     */
    public DemoMapPoint(int x, int y) {
        super(x, y);
    }

    @Override
    public MapPointData getPointData() {
        return mapPointData;
    }

    @Override
    public void setPointData(MapPointData mapPointData) {
        this.mapPointData = mapPointData;
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(getTransformedX(),getTransformedY(),getTransformedX(),getTransformedY());
    }
}
