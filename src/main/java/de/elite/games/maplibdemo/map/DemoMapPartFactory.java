package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapPartFactory;
import de.elite.games.maplib.MapStyle;
import de.elite.games.maplibdemo.DemoWalker;

public class DemoMapPartFactory implements MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint, DemoWalker> {

    @Override
    public DemoMapPoint createPoint(int x, int y) {
        return new DemoMapPoint (x,y);
    }

    @Override
    public DemoMapField createField() {
        return new DemoMapField();
    }

    @Override
    public DemoMapEdge createEdge(DemoMapPoint a, DemoMapPoint b) {
        return new DemoMapEdge(a,b);
    }

    @Override
    public DemoMap createMap(int width, int height) {
        return new DemoMap (width, height);
    }

    @Override
    public DemoWalker createWalker(MapStyle style) {
        return new DemoWalker(style);
    }
}
