package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapEdge;
import de.elite.games.maplibdemo.mapdata.MapEdgeData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapEdge extends MapEdge<MapEdgeData, DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMapEdge(DemoMapPoint a, DemoMapPoint b, MapEdgeData mapEdgeData) {
        super(a, b, mapEdgeData);
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);
        gc.strokeLine(getA().getTransformedX(),getA().getTransformedY(), getB().getTransformedX(),getB().getTransformedY());
    }
}
