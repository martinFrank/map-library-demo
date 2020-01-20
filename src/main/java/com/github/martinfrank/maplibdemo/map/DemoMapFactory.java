package com.github.martinfrank.maplibdemo.map;

import com.github.martinfrank.maplib.MapFactory;
import com.github.martinfrank.maplib.MapPartFactory;

public class DemoMapFactory extends MapFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> {

    public DemoMapFactory(MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> mapPartFactory) {
        super(mapPartFactory);
    }
}
