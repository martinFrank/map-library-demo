package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapPartFactory;

public class DemoMapPartFactory implements MapPartFactory<DemoMap, DemoMapField, DemoMapEdge, DemoMapPoint> {

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

}
