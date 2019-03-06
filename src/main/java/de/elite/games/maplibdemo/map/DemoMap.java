package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.AbstractMap;

public class DemoMap extends AbstractMap<DemoMapField, DemoMapEdge, DemoMapPoint> {

    public DemoMap(int width, int height) {
        super(width, height,null);
    }

    @Override
    public void draw(Object drawContext) {
        getFields().forEach(f -> f.draw(drawContext));
    }

}
