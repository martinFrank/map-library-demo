package de.elite.games.maplibdemo.map;

import de.elite.games.geolib.GeoPoint;
import de.elite.games.maplib.MapField;
import de.elite.games.maplib.MapPoint;
import de.elite.games.maplibdemo.mapdata.MapFieldData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapField extends MapField<MapFieldData, DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMapField(GeoPoint index, MapFieldData mapFieldData) {
        super(index, mapFieldData);
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setFill(Color.GRAY);
        if (getData().getWalkCostFactor() >= 1) {
            gc.setFill(Color.LIGHTGRAY);
        }
        if (getData().getWalkCostFactor() >= 3) {
            gc.setFill(Color.DARKGRAY);
        }
        if (getData().getWalkCostFactor() >= 6) {
            gc.setFill(Color.BLACK);
        }
        if (getData().isMarkedAsPath()) {
            gc.setFill(Color.YELLOW);
        }
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(1);

        double[] xs = getPointsOrdered().stream().mapToDouble(MapPoint::getTransformedX).toArray();
        double[] ys = getPointsOrdered().stream().mapToDouble(MapPoint::getTransformedY).toArray();
        int amount = getPoints().size();
        gc.fillPolygon(xs,ys, amount);

        getEdges().forEach(e -> e.draw(drawContext));
        getPoints().forEach(p -> p.draw(drawContext));
    }

}
