package dataStructures;

import java.util.ArrayList;

public class Path<T extends Comparable<T>, E extends Comparable<E>> implements Comparable<Path<T, E>> {

	private ListGraph<T, E> list;

	private MatrixGraph<T, E> matrix;

	private ArrayList<Vertex<T>> vertices;

	private int[] path;

	public Path(ListGraph<T, E> list, MatrixGraph<T, E> matrix, int[] path) {

		this.list = list;
		this.matrix = matrix;
		this.path = path;
		vertices = new ArrayList<>();

	}

	public int[] getPath() {
		return path;
	}


	public void setPath(int[] path) {
		this.path = path;
	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	@Override
	public int compareTo(Path<T, E> o) {
		return 0;
	}


	public ArrayList<Vertex<T>> creatingPath(Vertex<T> from, Vertex<T> destination) {

		ArrayList<Vertex<T>> verticesDef = new ArrayList<>();
		ArrayList<Vertex<T>> r = new ArrayList<>();

		if (list != null) {

			int destIndex = list.getIndexVertex(destination.getValue());

			verticesDef.add(destination);

			while (path[destIndex] != -1) {

				verticesDef.add(list.getVertices().get(path[destIndex]));

				destIndex = path[destIndex];

			}

		}

		if (matrix != null) {

			int destIndex = matrix.getIndexVertex(destination.getValue());

			verticesDef.add(destination);

			while (path[destIndex] != -1) {

				verticesDef.add(matrix.getVertices().get(path[destIndex]));

				destIndex = path[destIndex];

			}

		}

		for (int i = verticesDef.size() - 1; i >= 0; i--) {

			r.add(verticesDef.get(i));

		}

		this.vertices = r;

		return r;

	}

	@Override

	public String toString() {

		String path = "";

		if (matrix == null) {

			for (int i = 0; i < vertices.size() - 1; i++) {

				Vertex<T> a = vertices.get(i);
				Vertex<T> b = vertices.get(i + 1);

				path += a.toString() + " -- " + list.edgesBetween(a.getValue(), b.getValue()) + "--> " + b.toString()
						+ "\n";

			}
		} else {

			for (int i = 0; i < vertices.size() - 1; i++) {

				Vertex<T> a = vertices.get(i);
				Vertex<T> b = vertices.get(i + 1);

				path += a.toString() + " -- " + matrix.edgesBetween(a.getValue(), b.getValue()) + "--> " + b.toString()
						+ "\n";

			}

		}

		return path;

	}

}