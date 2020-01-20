package com.github.martinfrank.maplibdemo.map;

import com.github.martinfrank.maplibdemo.mapdata.MapEdgeData;
import com.github.martinfrank.drawlib.Point;
import com.github.martinfrank.maplib.MapEdge;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapEdge extends MapEdge<MapEdgeData, DemoMapField, DemoMapEdge, DemoMapNode> {

    public DemoMapEdge(MapEdgeData mapEdgeData) {
        super(mapEdgeData);
    }

    @Override
    public void draw(Object drawContext) {
        GraphicsContext gc = (GraphicsContext) drawContext;

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(3);

        Point a = getLine().getTransformed().getA();
        Point b = getLine().getTransformed().getB();
        gc.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
    }
}
