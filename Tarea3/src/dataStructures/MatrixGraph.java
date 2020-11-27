package dataStructures;

import java.util.ArrayList;

public class MatrixGraph<T extends Comparable<T>, E extends Comparable<E>> implements IGraph<T, E> {

	private ArrayList<Edge<E>>[][] adjMatrix;
	private ArrayList<Vertex<T>> vertices;
	private ArrayList<Edge<E>> edges;
	private int numVertex;

	public MatrixGraph(int numVertex) {

		this.numVertex = numVertex;

		vertices = new ArrayList<Vertex<T>>();
		adjMatrix = new ArrayList[numVertex][numVertex];
		edges = new ArrayList<>();

		initMatrix();

	}

	private void initMatrix() {

		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < adjMatrix[0].length; j++) {

				adjMatrix[i][j] = new ArrayList<Edge<E>>();

			}

		}

	}

	public void setEdges(ArrayList<Edge<E>> edges) {
		this.edges = edges;
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
			adjMatrix[f][d].add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));

		} else {
			adjMatrix[f][d].add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			adjMatrix[d][f].add(new Edge<E>(new Vertex<T>(destination), new Vertex<T>(from), cost, directed, value));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			vertices.get(d).getEdges()
					.add(new Edge<E>(new Vertex<T>(destination), new Vertex<T>(from), cost, directed, value));
			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
		}
	}

	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {

		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);

		if (directed) {

			for (int i = 0; i < adjMatrix[f][d].size(); i++) {

				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);
			}
		} else {
			for (int i = 0; i < adjMatrix[f][d].size(); i++) {

				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);

				if (adjMatrix[d][f].get(i).getCost() == cost)
					adjMatrix[d][f].remove(i);
			}
		}
	}

	@Override
	public void addVertex(T valueVertex) {

		if (vertices.size() < numVertex)
			vertices.add(new Vertex<T>(valueVertex));

	}

	@Override
	public void removeVertex(T valueVertex) {

	}

	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {

		boolean is = false;
		int a = getIndexVertex(vertexA);
		int b = getIndexVertex(vertexB);

		if (adjMatrix[a][b].size() > 0 || adjMatrix[b][a].size() > 0) {

			is = true;

		}

		return is;

	}

	public ArrayList<Edge<E>> getEdgesOfVertex(T valueVertex) {

		int E = getIndexVertex(valueVertex);
		ArrayList<Edge<E>> edges = new ArrayList<>();

		for (int i = 0; i < adjMatrix[0].length; i++) {

			if (!adjMatrix[E][i].isEmpty()) {

				edges.addAll(adjMatrix[E][i]);

			}

		}

		return edges;

	}

	public int numEdgesOfVertex(T valueVertex) {

		return getEdgesOfVertex(valueVertex).size();

	}


	public ArrayList<Edge<E>> edgesBetween(T vertexA, T vertexB) {

		ArrayList<Edge<E>> edges = new ArrayList<>();

		int indexA = getIndexVertex(vertexA);
		int indexB = getIndexVertex(vertexB);
	
		edges = adjMatrix[indexA][indexB];
		

		return edges;

	}

	@Override
	public int getNumVertex() {

		return vertices.size();
	}

	public ArrayList<Edge<E>>[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(ArrayList<Edge<E>>[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	public String graphToString() {

		String g = "";

		for (int i = 0; i < adjMatrix.length; i++) {

			for (int j = 0; j < vertices.size(); j++) {

				if (!adjMatrix[i][j].isEmpty()) {
					for (int k = 0; k < adjMatrix[i][j].size(); k++) {

						if (adjMatrix[i][j].get(k).isDirected())
							g += vertices.get(i).toString() + " -- " + adjMatrix[i][j].get(k).toString() + " --> "
									+ vertices.get(j).toString() + "\n";
						else
							g += vertices.get(i).toString() + " <-- " + adjMatrix[i][j].get(k).toString() + " --> "
									+ vertices.get(j).toString() + "\n";

					}

				}
			}
			g += "\n";
		}

		return g;

	}

	public ArrayList<Edge<E>> getEdges() {
		return edges;
	}

}