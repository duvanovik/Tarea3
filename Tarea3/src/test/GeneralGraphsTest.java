package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import dataStructures.GeneralGraphs;
import dataStructures.MatrixGraph;
import dataStructures.Vertex;
import model.City;

class GeneralGraphsTest {


	private GeneralGraphs graph; 
	private MatrixGraph mGraph;
	
	
	private void setup1() {

		graph=new GeneralGraphs<>();
		mGraph=new MatrixGraph<>(5);
		
	}
	
	
	
	
	
	private void setup2() {

		graph=new GeneralGraphs<>();		
	}
	
	@Test
	void testDFS() {
		setup1();

		City city= new City("Cali");
		Vertex v = new Vertex((Comparable) city);
		graph.DFS(mGraph, v);
		
	}


}
