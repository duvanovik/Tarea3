package model;

import structures.GrafoLista;

public class Program {

	private GrafoLista g;
	
	
	public Program() {
		g=new GrafoLista(false);
		addCitys();
		addRoads();
	}
	
	
	/**
	 * 
	 */
	public void addCitys() {
        g.agregarVertice("Rioacha");
        g.agregarVertice("Barranquilla");
        g.agregarVertice("Cartagena");
        g.agregarVertice("Monteria");
        g.agregarVertice("Medellin");
        g.agregarVertice("Quibdo");
        g.agregarVertice("Cali");
        g.agregarVertice("Popayan");
        g.agregarVertice("Pasto");
        g.agregarVertice("Mocoa");
        g.agregarVertice("Bogota");
        g.agregarVertice("Manizales");
        g.agregarVertice("Bucaramanga");
        g.agregarVertice("Arauca");
        g.agregarVertice("Yopal");
        g.agregarVertice("Tunja");
        g.agregarVertice("Villavicencio");
        g.agregarVertice("Mitu");
        g.agregarVertice("Leticia");		
	}
	
	
	/**
	 * 
	 */
	public void addRoads() {
        g.agregarArista("Rioacha","Barranquilla",269);
        g.agregarArista("Barranquilla","Cartagena",119);
        g.agregarArista("Cartagena","Monteria",244);
        g.agregarArista("Monteria","Medellin",405);
        g.agregarArista("Monteria","Bucaramanga",613);
        g.agregarArista("Medellin","Quibdo",230);
        g.agregarArista("Medellin","Manizales",244);
        g.agregarArista("Medellin","Bucaramanga",390);
        g.agregarArista("Bucaramanga","Arauca",340);
        g.agregarArista("Bucaramanga","Tunja",282);
        g.agregarArista("Bucaramanga","Manizales",507);
        g.agregarArista("Quibdo","Cali",425);
        g.agregarArista("Manizales","Tunja",419);
        g.agregarArista("Manizales","Bogota",293);
        g.agregarArista("Manizales","Cali",259);
        g.agregarArista("Yopal","Arauca",285);
        g.agregarArista("Tunja","Yopal",202);
        g.agregarArista("Tunja","Bogota",139);
        g.agregarArista("Bogota","Cali",461);
        g.agregarArista("Bogota","Villavicencio",124);
        g.agregarArista("Yopal","Villavicencio",252);
        g.agregarArista("Cali","Popayan",140);
        g.agregarArista("Popayan","Pasto",246);
        g.agregarArista("Mocoa","Popayan",278);
        g.agregarArista("Mocoa","Pasto",105);
        g.agregarArista("Mocoa","Mitu",510);
        g.agregarArista("Mocoa","Leticia",670);
        g.agregarArista("Villavicencio","Mitu",613);
        g.agregarArista("Mitu","Leticia",523);
	}


	public GrafoLista getG() {
		return g;
	}


	public void setG(GrafoLista g) {
		this.g = g;
	}
	
	
	
	
	
}
