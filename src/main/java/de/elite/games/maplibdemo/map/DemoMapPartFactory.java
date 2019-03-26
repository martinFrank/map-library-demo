package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapPartFactory;
import de.elite.games.maplib.MapStyle;
import de.elite.games.maplibdemo.mapdata.MapData;
import de.elite.games.maplibdemo.mapdata.MapEdgeData;
import de.elite.games.maplibdemo.mapdata.MapFieldData;
import de.elite.games.maplibdemo.mapdata.MapNodeData;

public class DemoMapPartFactory extends MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> {

    @Override
    public DemoMapNode createMapNode() {
        return new DemoMapNode(new MapNodeData());
    }

    @Override
    public DemoMapEdge createMapEdge() {
        return new DemoMapEdge(new MapEdgeData());
    }

    @Override
    public DemoMapField createMapField() {
        return new DemoMapField(new MapFieldData());
    }

    @Override
    public DemoMap createMap(int width, int height, MapStyle style) {
        return new DemoMap(width, height, style, new MapData());
    }

    @Override
    public DemoMapWalker createWalker() {
        return new DemoMapWalker();
    }
}
