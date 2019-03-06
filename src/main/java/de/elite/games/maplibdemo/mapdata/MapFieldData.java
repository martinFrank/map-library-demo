package de.elite.games.maplibdemo.mapdata;

public class MapFieldData {

    private boolean isPath = false;
    public void markAsPath(boolean isPath) {
        this.isPath = isPath;
    }

    public boolean isMarkedAsPath() {
        return isPath;
    }
}
