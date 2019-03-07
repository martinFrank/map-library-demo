package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapFactory;
import de.elite.games.maplib.MapPartFactory;

public class DemoMapFactory extends MapFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoMapWalker> {

    public DemoMapFactory(MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoMapWalker> mapPartFactory) {
        super(mapPartFactory);
    }
}
