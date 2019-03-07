package de.elite.games.maplibdemo.mapdata;

public class MapFieldData {

    private boolean isPath = false;
    private double walkCostFactor = 1;
    public void markAsPath(boolean isPath) {
        this.isPath = isPath;
    }

    public boolean isMarkedAsPath() {
        return isPath;
    }

    public double getWalkCostFactor() {
        return walkCostFactor;
    }

    public void setWalkCostFactor(double walkCostFactor) {
        this.walkCostFactor = walkCostFactor;
    }

}
