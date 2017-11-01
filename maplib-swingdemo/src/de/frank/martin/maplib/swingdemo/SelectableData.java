package de.frank.martin.maplib.swingdemo;

public class SelectableData {
	
	private boolean isSelected;
	
	public boolean isSelected(){
		return isSelected;
	}
	
	public void toggleSelect(){
		isSelected = !isSelected;
	}

}
