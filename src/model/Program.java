package model;

import structures.GrafoLista;
import structures.GrafoMatriz;

public class Program {

	private GrafoLista g;
	private GrafoMatriz<String> gm;
	
	

	/**
	 * 
	 * @param matriz
	 */
	public Program() {
		
	}
	
	public void crearGrafoLista() {
		g=new GrafoLista(false);
		addCitysList();
		addRoadList();
		
	}
	
	
	public void crearGrafoMatriz() {
		gm= new GrafoMatriz<String>(false);
		addCitysMatriz();
		addRoadMatriz();
	}
	
	
	private void addCitysMatriz() {
        gm.agregarNodo("Rioacha");
        gm.agregarNodo("Barranquilla");
        gm.agregarNodo("Cartagena");
        gm.agregarNodo("Monteria");
        gm.agregarNodo("Medellin");
        gm.agregarNodo("Quibdo");
        gm.agregarNodo("Cali");
        gm.agregarNodo("Popayan");
        gm.agregarNodo("Pasto");
        gm.agregarNodo("Mocoa");
        gm.agregarNodo("Bogota");
        gm.agregarNodo("Manizales");
        gm.agregarNodo("Bucaramanga");
        gm.agregarNodo("Arauca");
        gm.agregarNodo("Yopal");
        gm.agregarNodo("Tunja");
        gm.agregarNodo("Villavicencio");
        gm.agregarNodo("Mitu");
        gm.agregarNodo("Leticia");			
	}


	private void addRoadMatriz() {
        gm.agregarArista("Rioacha","Barranquilla",269);
        gm.agregarArista("Barranquilla","Cartagena",119);
        gm.agregarArista("Cartagena","Monteria",244);
        gm.agregarArista("Monteria","Medellin",405);
        gm.agregarArista("Monteria","Bucaramanga",613);
        gm.agregarArista("Medellin","Quibdo",230);
        gm.agregarArista("Medellin","Manizales",244);
        gm.agregarArista("Medellin","Bucaramanga",390);
        gm.agregarArista("Bucaramanga","Arauca",340);
        gm.agregarArista("Bucaramanga","Tunja",282);
        gm.agregarArista("Bucaramanga","Manizales",507);
        gm.agregarArista("Quibdo","Cali",425);
        gm.agregarArista("Manizales","Tunja",419);
        gm.agregarArista("Manizales","Bogota",293);
        gm.agregarArista("Manizales","Cali",259);
        gm.agregarArista("Yopal","Arauca",285);
        gm.agregarArista("Tunja","Yopal",202);
        gm.agregarArista("Tunja","Bogota",139);
        gm.agregarArista("Bogota","Cali",461);
        gm.agregarArista("Bogota","Villavicencio",124);
        gm.agregarArista("Yopal","Villavicencio",252);
        gm.agregarArista("Cali","Popayan",140);
        gm.agregarArista("Popayan","Pasto",246);
        gm.agregarArista("Mocoa","Popayan",278);
        gm.agregarArista("Mocoa","Pasto",105);
        gm.agregarArista("Mocoa","Mitu",510);
        gm.agregarArista("Mocoa","Leticia",670);
        gm.agregarArista("Villavicencio","Mitu",613);
        gm.agregarArista("Mitu","Leticia",523);		
	}


	/**
	 * 
	 */
	public void addCitysList() {
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
	public void addRoadList() {
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

	public GrafoMatriz<String> getGm() {
		return gm;
	}

	public void setGm(GrafoMatriz<String> gm) {
		this.gm = gm;
	}
	
	
	
	
	
}
