package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapWalker;

public class DemoMapWalker extends MapWalker<DemoMapField, DemoMapEdge, DemoMapPoint> {

    @Override
    public boolean canEnter(DemoMapField from, DemoMapField into) {
        return true;
    }

    @Override
    public int getEnterCosts(DemoMapField from, DemoMapField into) {
        return (int) into.getData().getWalkCostFactor() * 10;
    }
}
