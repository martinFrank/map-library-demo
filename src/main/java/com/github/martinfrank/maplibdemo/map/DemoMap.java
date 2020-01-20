package com.github.martinfrank.maplibdemo.map;

import com.github.martinfrank.maplibdemo.mapdata.MapData;
import com.github.martinfrank.maplib.Map;
import com.github.martinfrank.maplib.MapStyle;

public class DemoMap extends Map<MapData, DemoMapField, DemoMapEdge, DemoMapNode, DemoMapWalker> {


    public DemoMap(int width, int height, MapStyle style, MapData mapData) {
        super(width, height, style, mapData);
    }

    @Override
    public void draw(Object drawContext) {
        getFields().forEach(f -> f.draw(drawContext));
    }

}
