package de.elite.games.maplibdemo.map;

import de.elite.games.geolib.GeoPoint;
import de.elite.games.maplib.MapPartFactory;
import de.elite.games.maplib.MapStyle;

public class DemoMapPartFactory extends MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoWalker> {

    @Override
    public DemoMapPoint createMapPoint(int x, int y) {
        return new DemoMapPoint(x, y);
    }

    @Override
    public DemoMapEdge createMapEdge(DemoMapPoint a, DemoMapPoint b) {
        return new DemoMapEdge(a, b);
    }

    @Override
    public DemoMapField createMapField(GeoPoint index) {
        return new DemoMapField(index);
    }

    @Override
    public DemoMap createMap(int width, int height, MapStyle style) {
        return new DemoMap(width, height, style);
    }

    @Override
    public DemoWalker createWalker() {
        return new DemoWalker();
    }
}
