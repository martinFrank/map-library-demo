package de.elite.games.maplibdemo;

import de.elite.games.maplib.MapStyle;
import de.elite.games.maplib.Walker;
import de.elite.games.maplibdemo.map.DemoMapField;

public class DemoWalker extends Walker<DemoMapField> {

    public DemoWalker(MapStyle style) {
        super(style);
    }

    @Override
    public int getEnterCosts(DemoMapField from, DemoMapField into) {
        int costs = super.getEnterCosts(from, into);
        double fieldModifier = into.getFieldData().getWalkCostFactor();
        return (int) (costs * fieldModifier);
    }

    @Override
    public boolean canEnter(DemoMapField from, DemoMapField into) {
        return true;

    }
}
