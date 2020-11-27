package dataStructures;

public interface IGraph<T extends Comparable<T>, E extends Comparable<E>> {

	void addEdge(T from, T destination, boolean directed, double cost, E value);

	void removeEdge(T from, T destination, boolean directed, double cost);

	void addVertex(T valueVertex);

	void removeVertex(T valueVertex);

	boolean isAdjacent(T vertexA, T vertexB);
	
	int getNumVertex();
}