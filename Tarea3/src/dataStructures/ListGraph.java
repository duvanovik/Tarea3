package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ListGraph<T extends Comparable<T>, E extends Comparable<E>> implements IGraph<T, E> {


	private ArrayList<ArrayList<Vertex<T>>> adjList;

	private ArrayList<Vertex<T>> vertices;

	private ArrayList<Edge<E>> edges;

	public ListGraph(int numVertex) {

		adjList = new ArrayList<ArrayList<Vertex<T>>>(numVertex);
		vertices = new ArrayList<>(numVertex);
		edges = new ArrayList<>();

	}

	public int getIndexVertex(T valueVertex) {

		int index = -1;

		for (int i = 0; i < vertices.size(); i++) {

			if (vertices.get(i).getValue().equals(valueVertex))

				index = i;

		}

		return index;

	}

	@Override
	public void addEdge(T from, T destination, boolean directed, double cost, E value) {

		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);

		if (directed) {

			adjList.get(f).add(new Vertex<T>(destination));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));

			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));

		} else {

			adjList.get(f).add(new Vertex<T>(destination));
			adjList.get(d).add(new Vertex<T>(from));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			vertices.get(d).getEdges()
					.add(new Edge<E>(new Vertex<T>(destination), new Vertex<T>(from), cost, directed, value));
			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));

		}

	}

	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {

	}

	@Override
	public void addVertex(T valueVertex) {

		vertices.add(new Vertex<T>(valueVertex));
		adjList.add(new ArrayList<Vertex<T>>());

	}

	@Override
	public void removeVertex(T valueVertex) {

	}

	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {

		boolean is = false;
		int index = getIndexVertex(vertexA);

		for (int i = 0; i < adjList.get(index).size(); i++) {

			if (adjList.get(index).get(i).getValue().equals(vertexB)) {

				is = true;

			}

		}

		return is;

	}

	@Override
	public int getNumVertex() {

		return adjList.size();
	}


	public ArrayList<ArrayList<Vertex<T>>> getAdjList() {
		return adjList;
	}

	public void setAdjList(ArrayList<ArrayList<Vertex<T>>> adjList) {
		this.adjList = adjList;
	}

	public ArrayList<Edge<E>> edgesBetween(T vertexA, T vertexB) {

		ArrayList<Edge<E>> edgesBetween = new ArrayList<>();

		int indexAux = getIndexVertex(vertexA);

		for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {

			if (vertices.get(indexAux).getEdges().get(i).getFrom().getValue() == vertexA
					&& vertices.get(indexAux).getEdges().get(i).getDestination().getValue() == vertexB) {

				edgesBetween.add((Edge<E>) vertices.get(indexAux).getEdges().get(i));

			}

		}

		return edgesBetween;

	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Edge<E>> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge<E>> edges) {
		this.edges = edges;
	}

	public ArrayList<Edge<?>> getEdgesOfVertex(T vertex) {

		int index = getIndexVertex(vertex);

		return vertices.get(index).getEdges();

	}


	public int numEdgesOfVertex(T vertex) {

		int index = getIndexVertex(vertex);

		return vertices.get(index).getEdges().size();

	}

	public String graphToString() {

		String g = "";

		for (int i = 0; i < edges.size(); i++) {

			if (edges.get(i).isDirected()) {

				g += edges.get(i).getFrom().getValue().toString() + " -- " + edges.get(i).toString() + " --> "
						+ edges.get(i).getDestination().getValue().toString();

			} else {

				g += edges.get(i).getFrom().getValue().toString() + " <-- " + edges.get(i).toString() + " --> "
						+ edges.get(i).getDestination().getValue().toString();

			}

			g += "\n";

		}

		return g;

	}

}