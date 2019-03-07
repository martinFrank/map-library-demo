package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.AbstractField;
import de.elite.games.maplib.MapPoint;
import de.elite.games.maplibdemo.mapdata.MapFieldData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapField extends AbstractField<MapFieldData, DemoMapEdge, DemoMapPoint> {

    private MapFieldData mapFieldData = new MapFieldData();


    public DemoMapField() {
        super();
    }

    @Override
    public MapFieldData getFieldData() {
        return mapFieldData;
    }

    @Override
    public void setFieldData(MapFieldData mapFieldData) {
        this.mapFieldData = mapFieldData;
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setFill(Color.GRAY);
        if (getFieldData().getWalkCostFactor() >= 1) {
            gc.setFill(Color.LIGHTGRAY);
        }
        if (getFieldData().getWalkCostFactor() >= 3) {
            gc.setFill(Color.DARKGRAY);
        }
        if (getFieldData().getWalkCostFactor() >= 6) {
            gc.setFill(Color.BLACK);
        }
        if (getFieldData().isMarkedAsPath()){
            gc.setFill(Color.YELLOW);
        }
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(1);

        double[] xs = getPoints().stream().mapToDouble(MapPoint::getTransformedX).toArray();
        double[] ys = getPoints().stream().mapToDouble(MapPoint::getTransformedY).toArray();
        int amount = getPoints().size();
        gc.fillPolygon(xs,ys, amount);

        getEdges().forEach(e -> e.draw(drawContext));
        getPoints().forEach(p -> p.draw(drawContext));
    }
}
