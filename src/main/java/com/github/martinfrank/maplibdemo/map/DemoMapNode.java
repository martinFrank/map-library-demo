package com.github.martinfrank.maplibdemo.map;

import com.github.martinfrank.maplibdemo.mapdata.MapNodeData;
import com.github.martinfrank.drawlib.Point;
import com.github.martinfrank.maplib.MapNode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DemoMapNode extends MapNode<MapNodeData, DemoMapField, DemoMapEdge, DemoMapNode> {

    public DemoMapNode(MapNodeData mapNodeData) {
        super(mapNodeData);
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
