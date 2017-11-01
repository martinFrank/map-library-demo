package de.frank.martin.maplib.swingdemo;

import java.awt.Color;
import java.awt.Graphics2D;

import de.frank.martin.maplib.AbstractPoint;

public class DemoMapPoint<T> extends AbstractPoint<PointData> {

	private PointData pointData = new PointData();

	public DemoMapPoint(int x, int y) {
		super(x, y);
	}

	@Override
	public PointData getPointData() {
		return pointData;
	}

	@Override
	public void setPointData(PointData u) {
		pointData = u;
	}

	
	private static final int RADIUS = 5;
	@Override
	public void draw(Object graphics, int xOff, int yOff) {
		// this time we're working with swing:
		// we only draw Points when they're selected
		if (getPointData().isSelected()) {			
			Graphics2D gr = (Graphics2D) graphics;
			gr.setColor(Color.BLACK);
			gr.fillOval(getTransformedX()-RADIUS, getTransformedY()-RADIUS, 2*RADIUS, 2*RADIUS);			
		}
	}

}
