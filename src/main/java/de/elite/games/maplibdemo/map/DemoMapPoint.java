package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapPoint;
import de.elite.games.maplibdemo.mapdata.MapPointData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapPoint extends MapPoint<MapPointData, DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMapPoint(int x, int y, MapPointData mapPointData) {
        super(x, y, mapPointData);
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
