package de.elite.games.maplibdemo.map;

import de.elite.games.maplib.MapWalker;

import java.util.List;

public class DemoMapWalker extends MapWalker<DemoMapField, DemoMapEdge, DemoMapNode> {

    @Override
    public boolean canEnter(DemoMapField from, DemoMapField into) {
        return true;
    }

    @Override
    public int getEnterCosts(DemoMapField from, DemoMapField into) {
        return (int) into.getData().getWalkCostFactor() * 10;
    }

    @Override
    public List<DemoMapField> getNeighbours(DemoMapField field) {
        return getNeighboursFromEdges(field);
    }
}
