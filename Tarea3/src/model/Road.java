package model;

import java.util.ArrayList;

public class Road {

	private ArrayList<String> roads;
	private ArrayList<String> citys;
	
	public Road(ArrayList<String> camino) {
		
		citys=camino;
		roads=new ArrayList<String>();
		convertirCamino(camino);
	}

	private void convertirCamino(ArrayList<String> camino) {
		
		for(int i=0;i<camino.size()-1;i++) {
			String ruta=camino.get(i)+"_"+camino.get(i+1);
			roads.add(ruta);
		}		
	}

	public ArrayList<String> getRoads() {
		return roads;
	}

	public void setRoads(ArrayList<String> roads) {
		this.roads = roads;
	}

	public ArrayList<String> getCitys() {
		return citys;
	}

	public void setCitys(ArrayList<String> citys) {
		this.citys = citys;
	}
	
	
	
	
}
