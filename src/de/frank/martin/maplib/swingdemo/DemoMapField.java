package de.frank.martin.maplib.swingdemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import de.frank.martin.maplib.AbstractField;
import de.frank.martin.maplib.MapFactory;
import de.frank.martin.maplib.MapPoint;

public class DemoMapField extends AbstractField<FieldData, EdgeData, PointData> {

	private FieldData fieldData = new FieldData();
	
	public DemoMapField(MapPoint<PointData> c, MapFactory<FieldData, EdgeData, PointData> f) {
		super(c, f);
	}

	@Override
	public FieldData getFieldData() {
		return fieldData;
	}

	@Override
	public void setFieldData(FieldData t) {
		fieldData = t;
	}

	@Override
	public void draw(Object graphics, int xOff, int yOff) {
		// this time we're working with swing:
		Graphics2D gr = (Graphics2D) graphics;
		
		//first we draw the field
		int[] xs = getPoints().stream().mapToInt(MapPoint::getTransformedX).toArray();
		int[] ys = getPoints().stream().mapToInt(MapPoint::getTransformedY).toArray();
		int size = xs.length;
		if(getFieldData().isSelected()){
			gr.setColor(Color.GRAY);
		}else{
			gr.setColor(Color.WHITE);
		}
		gr.fill(new Polygon(xs, ys, size));
		
		//then we draw the edges
		getEdges().forEach(e -> e.draw(graphics, xOff, yOff));

	}

}
