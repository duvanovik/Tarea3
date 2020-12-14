package test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import structures.GrafoLista;
import structures.GrafoMatriz;
import structures.NodoMatriz;

class testGrafoMatriz {
	
	
	private GrafoMatriz<String> graph;
	private void setup1() {

		graph=new GrafoMatriz<String>(false);		
	}
	
	private void setup2() {

		graph=new GrafoMatriz<String>(false);
		
		graph.agregarNodo("A");
		graph.agregarNodo("B");
		graph.agregarNodo("C");
		graph.agregarNodo("D");
		
		graph.agregarArista("A", "B", 2);
		graph.agregarArista("B", "C", 3);
		graph.agregarArista("C", "D", 2);
		graph.agregarArista("D", "A", 4);
		
	}
	
	
	@Test
	void testAgregarVertice() {

		//Case I
		setup1();
		int cantidadAntes=graph.getTotalnodos();
		graph.agregarNodo("B");
		int cantidadActual= graph.getTotalnodos();
		assertTrue(cantidadActual==(cantidadAntes+1));
		
		
		//Case II
		

		cantidadAntes=graph.getTotalnodos();
		graph.agregarNodo("C");
		cantidadActual= graph.getTotalnodos();
		assertTrue(cantidadActual==(cantidadAntes+1));
		
		
		//Case III
		
		cantidadAntes=graph.getTotalnodos();
		
		graph.agregarNodo("A");
		cantidadActual= graph.getTotalnodos();
		
		assertTrue(cantidadAntes+1==cantidadActual);

		
	}	
	
	@Test
	void testdjkstra() {

		//Case I
		setup2();
		double distanciaCorta = graph.distanciaEntreCiudades("A", "B");
		assertTrue(distanciaCorta == 2.0);
	
		//Case II
		double distanciaCorta2 = graph.distanciaEntreCiudades("A", "C");
		assertTrue(distanciaCorta2 == 5.0);
		
		//Case III
		double distanciaCorta3 = graph.distanciaEntreCiudades("A", "A");
		assertTrue(distanciaCorta3 == 0.0);
	}
	
	@Test
	void testBellman() {
		
		setup2();
		
		//Case I
		double distanciaCorta = graph.distanciaEntreCiudadesBellman("A", "B");
		assertTrue(distanciaCorta == 2.0);
		
		//Case II
		double distanciaCorta2 = graph.distanciaEntreCiudadesBellman("A", "C");
		assertTrue(distanciaCorta2 == 5.0);
		
		//Case III
		double distanciaCorta3 = graph.distanciaEntreCiudadesBellman("A", "A");
		assertTrue(distanciaCorta3 == 0.0);
		
	}

}
