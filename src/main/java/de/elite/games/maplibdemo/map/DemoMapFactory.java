package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapFactory;
import de.elite.games.maplib.MapPartFactory;

public class DemoMapFactory extends MapFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> {

    public DemoMapFactory(MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> mapPartFactory) {
        super(mapPartFactory);
    }
}
