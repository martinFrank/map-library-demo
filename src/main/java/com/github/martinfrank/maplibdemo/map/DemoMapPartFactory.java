package com.github.martinfrank.maplibdemo.map;

import com.github.martinfrank.maplibdemo.mapdata.MapData;
import com.github.martinfrank.maplibdemo.mapdata.MapEdgeData;
import com.github.martinfrank.maplibdemo.mapdata.MapFieldData;
import com.github.martinfrank.maplibdemo.mapdata.MapNodeData;
import com.github.martinfrank.maplib.MapPartFactory;
import com.github.martinfrank.maplib.MapStyle;

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
    public DemoMap createMap(int columns, int rows, MapStyle style) {
        return new DemoMap(columns, rows, style, new MapData());
    }

    @Override
    public DemoMapWalker createWalker() {
        return new DemoMapWalker();
    }
}
