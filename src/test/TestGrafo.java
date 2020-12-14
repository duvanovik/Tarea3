package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import structures.GrafoLista;
import structures.NodoLista;
import structures.NodoMatriz;

class TestGrafo {

private GrafoLista graph;
	
	
	private void setup1() {

		graph=new GrafoLista(false);		
	}
	
	private void setup2() {

		graph=new GrafoLista(false);
		
		graph.agregarVertice("A");
		graph.agregarVertice("B");
		graph.agregarVertice("C");
		graph.agregarVertice("D");
		
		graph.agregarArista("A", "B", 2);
		graph.agregarArista("B", "C", 3);
		graph.agregarArista("C", "D", 2);
		graph.agregarArista("D", "A", 4);
		
	}
	
	private void setup3() {

		graph=new GrafoLista(false);
		
		graph.agregarVertice("A");

	}
	
	
	
	private void setup4() {

		graph=new GrafoLista(false);
		
		graph.agregarVertice("A");
		graph.agregarVertice("B");
		graph.agregarVertice("C");
		graph.agregarVertice("D");
		graph.agregarVertice("E");
		graph.agregarVertice("F");
		graph.agregarVertice("G");
		
		graph.agregarArista("A", "B", 2);
		graph.agregarArista("B", "C", 3);
		graph.agregarArista("C", "D", 2);
		graph.agregarArista("D", "A", 4);
		graph.agregarArista("B", "E", 4);
		graph.agregarArista("E", "G", 2);
		graph.agregarArista("C", "G", 1);
		graph.agregarArista("C", "F", 4);
		graph.agregarArista("F", "G", 4);

		
	}
	
	@Test
	void testAgregarArista() {
		setup1();

		
		//Case I
		graph.agregarArista("A","B", 30);
		boolean eliminado=graph.eliminarArista("A","B");
		assertTrue(eliminado==false);
		
		
		//Case II
		setup2();
		graph.agregarArista("A", "C", 7);
		eliminado=graph.eliminarArista("A","C");
		assertTrue(eliminado==true);
		
		//CASE III
		setup2();
		boolean agregada=graph.agregarArista("A", "B", 2);
		assertTrue(agregada==true);
		
	}	
	
	@Test
	void testEliminarArista() {
		setup1();

		
		//Case I
		int cantidadAristasAntes=graph.getCantidadAristas();
		graph.elimArista("A","B");
		int cantidadAristasAhora=graph.getCantidadAristas();
		assertTrue(cantidadAristasAntes==cantidadAristasAhora);
		
		
		//Case II
		setup2();
		cantidadAristasAntes=graph.getCantidadAristas();
		graph.elimArista("A","B");
		cantidadAristasAhora=graph.getCantidadAristas();
		assertTrue((cantidadAristasAntes-1)==cantidadAristasAhora);
		
		//CASE III
		cantidadAristasAntes=graph.getCantidadAristas();
		graph.elimArista("A","H");
		cantidadAristasAhora=graph.getCantidadAristas();
		assertTrue(cantidadAristasAntes==cantidadAristasAhora);
		
		
	}	
	
	
	@Test
	void testAgregarVertice() {

		//Case I
		setup1();
		int cantidadAntes=graph.getCantidadVertices();
		graph.agregarVertice("B");
		int cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadActual==(cantidadAntes+1));
		
		
		//Case II
		setup3();

		cantidadAntes=graph.getCantidadVertices();
		graph.agregarVertice("B");
		cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadActual==(cantidadAntes+1));
		
		
		//Case III
		setup2();
		cantidadAntes=graph.getCantidadVertices();
		graph.agregarVertice("A");
		cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadAntes==cantidadActual);

		
	}	

	
	@Test
	void testEliminarVertice() {

		//Case I
		setup1();
		int cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("B");
		int cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadActual==cantidadAntes);
		
		
		//Case II
		setup4();

		cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("B");
		cantidadActual= graph.getCantidadVertices();
		assertTrue((cantidadActual)==(cantidadAntes-1));
		
		
		//Case III
		setup2();
		cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("H");
		cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadAntes==cantidadActual);

		
	}	
	
	

	
	/**
	 * Usa el djkstra.
	 */
	@Test
	void testdjkstra() {

		//Case I
		setup1();
		int distanciaCorta=graph.distanciaEntreCiudades("A", "B");
		assertTrue(distanciaCorta==0);
		
		
		//Case II
		setup2();

		distanciaCorta=graph.distanciaEntreCiudades("A", "C");
		assertTrue(distanciaCorta==5); //Hay dos caminos, uno cuesta 6 y otro cuesta 5
		
		//Case III
		setup4();

		distanciaCorta=graph.distanciaEntreCiudades("A", "G");
		assertTrue(distanciaCorta==6); //Hay mas de dos caminos, el menor cuesta 6.
		
		
	}	

	
	@Test
	void testBellman() {

		//Case I
		setup1();
		int cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("B");
		int cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadActual==cantidadAntes);
		
		
		//Case II
		setup4();

		cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("B");
		cantidadActual= graph.getCantidadVertices();
		assertTrue((cantidadActual)==(cantidadAntes-1));
		
		
		//Case III
		setup2();
		cantidadAntes=graph.getCantidadVertices();
		graph.eliminarVertice("H");
		cantidadActual= graph.getCantidadVertices();
		assertTrue(cantidadAntes==cantidadActual);

		
	}	
	

	

}
