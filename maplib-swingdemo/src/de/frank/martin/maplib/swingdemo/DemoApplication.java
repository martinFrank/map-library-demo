package de.frank.martin.maplib.swingdemo;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import de.frank.martin.maplib.Map;
import de.frank.martin.maplib.MapEdge;
import de.frank.martin.maplib.MapField;
import de.frank.martin.maplib.MapPoint;

public class DemoApplication{

	public static void main(String[] args) {		
		new DemoApplication().start();
	}
	
	private Map<FieldData, EdgeData, PointData> map;
	private DemoMapPanel mapPanel;
	
	private void start() {
		map = new DemoMap(10, 10, new DemoMapFactory());
		map.scale(22f);		
		JFrame frame = new JFrame();
		mapPanel = new DemoMapPanel(map);
		mapPanel.addMouseListener(createMouseAdapter() );
		JScrollPane scroller = new JScrollPane(mapPanel);
		scroller.setPreferredSize(new Dimension(150,100));
		frame.add(scroller);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}

	private MouseListener createMouseAdapter() {
		return new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				MapField<FieldData, EdgeData, PointData> field = map.getField(e.getX(), e.getY());
				MapEdge<EdgeData, PointData> edge =  map.getEdge(e.getX(), e.getY());
				MapPoint<PointData> point =  map.getPoint(e.getX(), e.getY());
				
				if (field != null){
					field.getFieldData().toggleSelect();
				}
				if(edge != null){
					edge.getEdgeData().toggleSelect();				
				}
				if(point != null){
					point.getPointData().toggleSelect();					
				}
				mapPanel.repaint();				
			}
			
		};
	}


}
