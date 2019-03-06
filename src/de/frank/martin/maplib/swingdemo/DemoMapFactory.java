package de.frank.martin.maplib.swingdemo;

import de.frank.martin.maplib.MapEdge;
import de.frank.martin.maplib.MapFactory;
import de.frank.martin.maplib.MapField;
import de.frank.martin.maplib.MapPoint;
import de.frank.martin.maplib.MapStyle;

public class DemoMapFactory implements MapFactory<FieldData, EdgeData, PointData> {

	@Override
	public MapPoint<PointData> createPoint(int x, int y) {		
		return new DemoMapPoint(x,y);
	}

	@Override
	public MapField<FieldData, EdgeData, PointData> createField(MapPoint<PointData> center) {
		return new DemoMapField(center, this);
	}

	@Override
	public MapEdge<EdgeData, PointData> createEdge(MapPoint<PointData> f, MapPoint<PointData> t) {
		return new DemoMapEdge(f,t);
		
	}

	@Override
	public MapStyle getStyle() {
		return MapStyle.HEX_HORIZONTAL;
	}

}
