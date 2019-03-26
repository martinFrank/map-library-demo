package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.Map;
import de.elite.games.maplib.MapStyle;
import de.elite.games.maplibdemo.mapdata.MapData;

public class DemoMap extends Map<MapData, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> {


    public DemoMap(int width, int height, MapStyle style, MapData mapData) {
        super(width, height, style, mapData);
    }

    @Override
    public void draw(Object drawContext) {
        getFields().forEach(f -> f.draw(drawContext));
    }

}
