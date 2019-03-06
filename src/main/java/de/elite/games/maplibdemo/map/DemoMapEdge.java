package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.AbstractEdge;
import de.elite.games.maplibdemo.mapdata.MapEdgeData;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapEdge extends AbstractEdge<MapEdgeData, DemoMapPoint> {

    private MapEdgeData mapEdgeData;

    public DemoMapEdge(DemoMapPoint a, DemoMapPoint b) {
        super(a, b);
    }

    @Override
    public MapEdgeData getEdgeData() {
        return mapEdgeData;
    }

    @Override
    public void setEdgeData(MapEdgeData mapEdgeData) {
        this.mapEdgeData = mapEdgeData;
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
