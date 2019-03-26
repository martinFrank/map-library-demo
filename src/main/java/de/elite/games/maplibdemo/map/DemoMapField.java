package de.elite.games.maplibdemo.map;

import de.elite.games.drawlib.Point;
import de.elite.games.drawlib.Shape;
import de.elite.games.maplib.MapField;
import de.elite.games.maplibdemo.mapdata.MapFieldData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapField extends MapField<MapFieldData, DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMapField(MapFieldData mapFieldData) {
        super(mapFieldData);
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

        Shape shape = getShape().getTransformed();
        double[] xs = shape.getPoints().stream().mapToDouble(Point::getX).toArray();
        double[] ys = shape.getPoints().stream().mapToDouble(Point::getY).toArray();
        int amount = xs.length;
        gc.fillPolygon(xs,ys, amount);

        getEdges().forEach(e -> e.draw(drawContext));
        getNodes().forEach(p -> p.draw(drawContext));
    }

}
