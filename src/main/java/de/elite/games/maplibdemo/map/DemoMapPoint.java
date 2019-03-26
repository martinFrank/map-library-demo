package de.elite.games.maplibdemo.map;

import de.elite.games.drawlib.Point;
import de.elite.games.maplib.MapNode;
import de.elite.games.maplibdemo.mapdata.MapPointData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapPoint extends MapNode<MapPointData, DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMapPoint(MapPointData mapPointData) {
        super(mapPointData);
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setStroke(Color.RED);
        gc.setLineWidth(5);
        Point point = getPoint().getTransformed();
        gc.strokeLine(point.getX(), point.getY(), point.getX(), point.getY());
    }
}
