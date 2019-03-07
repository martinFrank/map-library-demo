package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.Map;
import de.elite.games.maplib.MapData;
import de.elite.games.maplib.MapStyle;

public class DemoMap extends Map<MapData, DemoMapField, DemoMapEdge, DemoMapPoint, DemoWalker> {


    public DemoMap(int width, int height, MapStyle style) {
        super(width, height, style);
    }

    @Override
    public void draw(Object drawContext) {
        getFields().forEach(f -> f.draw(drawContext));
    }


    @Override
    public MapData getData() {
        return null;
    }

    @Override
    public void setData(MapData o) {

    }
}
