package de.frank.martin.maplib.swingdemo;

import de.frank.martin.maplib.Map;
import de.frank.martin.maplib.MapFactory;
import de.frank.martin.maplib.MapField;

public class DemoMap extends Map<FieldData, EdgeData, PointData>{

	public DemoMap(int width, int height, MapFactory<FieldData, EdgeData, PointData> factory) {
		super(width, height, factory);
	}

	@Override
	public void draw(Object graphics, int xOff, int yOff) {
		// even if we know we're working with swing, we can just delegate draw to the map's children (fields)
		for(MapField<FieldData, EdgeData, PointData> field: getFields() ){
			field.draw(graphics, xOff, yOff);
		}
	}

}
