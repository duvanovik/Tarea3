package dataStructures;
import java.util.ArrayList;


public interface IGraph<V,E extends Comparable<E>> {
    void insertVertex(V value);
    void insertEdge(int position1, int position2, E conection);
    void deleteVertex(int positionVertex);
    void deleteEdge(int position1, int position2, E conection);
    void deleteAllEdge(int position1, int position2);
    ArrayList<VertexL<V, E>> getVerticesL();
    ArrayList<VertexM<V>> getVertexM();

    ArrayList<Integer> DFS(int startPosition);
    ArrayList<ArrayList<Integer>> DFS();

    ArrayList<Integer> Kruskal(int startPosition);
    ArrayList<Double> Dijsktra(int startPosition);
    double[][] Floyd_Warshal();
}
