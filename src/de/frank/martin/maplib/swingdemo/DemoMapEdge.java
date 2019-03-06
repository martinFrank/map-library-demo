package de.frank.martin.maplib.swingdemo;

import java.awt.Color;
import java.awt.Graphics2D;

import de.frank.martin.maplib.AbstractEdge;
import de.frank.martin.maplib.MapPoint;

public class DemoMapEdge extends AbstractEdge<EdgeData, PointData> {

	private EdgeData edgeData = new EdgeData();

	public DemoMapEdge(MapPoint<PointData> a, MapPoint<PointData> b) {
		super(a, b);
	}

	@Override
	public EdgeData getEdgeData() {
		return edgeData;
	}

	@Override
	public void setEdgeData(EdgeData v) {
		edgeData = v;
	}

	@Override
	public void draw(Object graphics, int xOff, int yOff) {
		// this time we're working with swing:
		Graphics2D gr = (Graphics2D) graphics;
		if(getEdgeData().isSelected()){
			gr.setColor(Color.PINK);
		}else{
			gr.setColor(Color.DARK_GRAY);
		}
		gr.drawLine(getA().getTransformedX(), getA().getTransformedY(), getB().getTransformedX(), getB().getTransformedY());		
		getA().draw(graphics, xOff, yOff);
		getB().draw(graphics, xOff, yOff);
	}

}
