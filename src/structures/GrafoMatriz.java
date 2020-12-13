package structures;
import java.util.*;


public class GrafoMatriz<T> {

	private HashMap<T, NodoMatriz<T>> grafo;
	private int totalnodos;
	private int totalAristas;
	private ArrayList<NodoMatriz<T>> nodos;
	private List<ArrayList<Integer>> matrizDeAdyacencia;
	private List<ArrayList<Double>> matrizDePesos;
	private boolean dirigido;

	public GrafoMatriz(boolean dir) {
		nodos = new ArrayList<NodoMatriz<T>>();
		matrizDeAdyacencia= new ArrayList<ArrayList<Integer>>();
		matrizDePesos= new ArrayList<ArrayList<Double>>();
		grafo = new HashMap<>(); 
		dirigido =dir;
	}


	public HashMap<T, NodoMatriz<T>> getGrafo() {
		return grafo;
	}

	public int getTotalnodos() {
		return totalnodos;
	}

	public int getTotalAristas() {
		return totalAristas;
	}

	public ArrayList<NodoMatriz<T>> getNodos() {
		return nodos;
	}

	public List<ArrayList<Integer>> getMatrizDeAdyacencia() {
		return matrizDeAdyacencia;
	}

	public List<ArrayList<Double>> getMatrizDePesos() {
		return matrizDePesos;
	}

	public boolean isDirigido() {
		return dirigido;
	}

	public void setGrafo(HashMap<T, NodoMatriz<T>> grafo) {
		this.grafo = grafo;
	}

	public void setTotalnodos(int totalnodos) {
		this.totalnodos = totalnodos;
	}

	public void setTotalAristas(int totalAristas) {
		this.totalAristas = totalAristas;
	}

	public void setNodos(ArrayList<NodoMatriz<T>> nodos) {
		this.nodos = nodos;
	}

	public void setMatrizDeAdyacencia(List<ArrayList<Integer>> matrizDeAdyacencia) {
		this.matrizDeAdyacencia = matrizDeAdyacencia;
	}

	public void setMatrizDePesos(List<ArrayList<Double>> matrizDePesos) {
		this.matrizDePesos = matrizDePesos;
	}

	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}


	public void agregarNodo(T value) {
		NodoMatriz<T> vertex = new NodoMatriz<T>(value);
		grafo.put(value, vertex);
		nodos.add(vertex);
		ArrayList<Integer> adj = new ArrayList<>();
		ArrayList<Double> weights = new ArrayList<>();
		for (int i = 0; i < matrizDeAdyacencia.size(); i++) {
			matrizDeAdyacencia.get(i).add(0);
			matrizDePesos.get(i).add(Double.MAX_VALUE);
		}
		for (int i = 0; i < nodos.size(); i++) {
			adj.add(0);
			weights.add(Double.MAX_VALUE);
		}
		weights.set(weights.size() - 1, 0.0);
		matrizDeAdyacencia.add(adj);
		matrizDePesos.add(weights);
		totalnodos++;
	}


	public NodoMatriz<T> buscarNodo(T value) {
		return grafo.get(value);
	}

	public int obtenerIndice(NodoMatriz<T> v) {
		int index = -1;
		boolean searching = true;
		for (int i = 0; i < nodos.size() && searching; i++) {
			if (nodos.get(i) == v) {
				index = i;
				searching = false;
			}
		}
		return index;
	}


	public void borrarNodos(T v) {
		if (buscarNodo(v)!= null) {
			borrarNodos(buscarNodo(v));
		}
	}


	private void borrarNodos(NodoMatriz<T> v) {
		int index = obtenerIndice(v);
		for (int i = 0; i < matrizDeAdyacencia.size(); i++) {
			
			matrizDeAdyacencia.get(i).remove(index);
			matrizDePesos.get(i).remove(index);
		}
		
		matrizDeAdyacencia.remove(index);
		matrizDePesos.remove(index);
		nodos.remove(v);
		grafo.remove(v.getValue());
		totalnodos--;
	}

	public void AgregarArista(T x, T y, double w) {

		NodoMatriz<T> initial = buscarNodo(x);
		NodoMatriz<T> destination = buscarNodo(y);
		
		AgregarArista(initial, destination, w);

	}

	private void AgregarArista(NodoMatriz<T> origen, NodoMatriz<T> destino, double peso) {

		matrizDeAdyacencia.get(obtenerIndice(origen)).set(obtenerIndice(destino), 1);
		matrizDePesos.get(obtenerIndice(origen)).set(obtenerIndice(destino),
				Math.min(peso, matrizDePesos.get(obtenerIndice(origen)).get(obtenerIndice(destino))));
		
		if (!isDirigido()) {
			
			matrizDeAdyacencia.get(obtenerIndice(destino)).set(obtenerIndice(origen), 1);
			matrizDePesos.get(obtenerIndice(destino)).set(obtenerIndice(origen),
					Math.min(peso, matrizDePesos.get(obtenerIndice(destino)).get(obtenerIndice(origen))));
		}
		totalAristas++;	
	}
	public void deleteEdge(T x, T y) {
		
		if (buscarNodo(x)!=null && buscarNodo(y)!=null) {
			deleteEdge(buscarNodo(x), buscarNodo(y));
		}
	}

	private void deleteEdge(NodoMatriz<T> initial, NodoMatriz<T> destination) {
		matrizDeAdyacencia.get(obtenerIndice(initial)).set(obtenerIndice(destination), 0);
		matrizDePesos.get(obtenerIndice(initial)).set(obtenerIndice(destination), Double.MAX_VALUE);
		
		if (!isDirigido()) {
			
			matrizDeAdyacencia.get(obtenerIndice(destination)).set(obtenerIndice(initial), 0);
			matrizDePesos.get(obtenerIndice(destination)).set(obtenerIndice(initial), Double.MAX_VALUE);
		}
		totalAristas--;
	}
	
}
