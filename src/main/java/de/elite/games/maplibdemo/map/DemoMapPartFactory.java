package de.elite.games.maplibdemo.map;

import de.elite.games.geolib.GeoPoint;
import de.elite.games.maplib.MapPartFactory;
import de.elite.games.maplib.MapStyle;
import de.elite.games.maplibdemo.mapdata.MapData;
import de.elite.games.maplibdemo.mapdata.MapEdgeData;
import de.elite.games.maplibdemo.mapdata.MapFieldData;
import de.elite.games.maplibdemo.mapdata.MapPointData;

public class DemoMapPartFactory extends MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoMapWalker> {

    @Override
    public DemoMapPoint createMapPoint(int x, int y) {
        return new DemoMapPoint(x, y, new MapPointData());
    }

    @Override
    public DemoMapEdge createMapEdge(DemoMapPoint a, DemoMapPoint b) {
        return new DemoMapEdge(a, b, new MapEdgeData());
    }

    @Override
    public DemoMapField createMapField(GeoPoint index) {
        return new DemoMapField(index, new MapFieldData());
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
