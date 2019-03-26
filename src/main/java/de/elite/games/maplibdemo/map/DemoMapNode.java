package de.elite.games.maplibdemo.map;

import de.elite.games.drawlib.Point;
import de.elite.games.maplib.MapNode;
import de.elite.games.maplibdemo.mapdata.MapNodeData;
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
