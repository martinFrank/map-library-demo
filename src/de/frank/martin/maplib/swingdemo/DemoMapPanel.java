package de.frank.martin.maplib.swingdemo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.security.InvalidParameterException;

import javax.swing.JPanel;

import de.frank.martin.maplib.Map;

@SuppressWarnings("serial")
public class DemoMapPanel extends JPanel {

	private final transient Map<FieldData, EdgeData, PointData> map;
	public DemoMapPanel(Map<FieldData, EdgeData, PointData> map){
		if(map == null){
			throw new InvalidParameterException("map must be set");
		}
		this.map = map;
		setPreferredSize(new Dimension(map.getScaledWidth(), map.getScaledHeight()));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		map.draw(g, 0, 0);
	}
}
