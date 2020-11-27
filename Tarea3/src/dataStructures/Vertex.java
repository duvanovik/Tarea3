package dataStructures;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

	private T value;

	private ArrayList<Edge<?>> edges;

	public Vertex(T value) {

		this.value = value;
		edges = new ArrayList<>();

	}

	public ArrayList<Edge<?>> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge<?>> edges) {
		this.edges = edges;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return value.toString();

	}

	public boolean equals(Vertex<T> v) {

		return this.value == v.value;
	}

	@Override
	public int compareTo(Vertex<T> o) {

		if (this.equals(o))
			return 0;

		else
			return -1;

	}

}