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
	public void borrarArista(T x, T y) {

		if (buscarNodo(x)!=null && buscarNodo(y)!=null) {
			borrarArista(buscarNodo(x), buscarNodo(y));
		}
	}

	private void borrarArista(NodoMatriz<T> initial, NodoMatriz<T> destination) {
		matrizDeAdyacencia.get(obtenerIndice(initial)).set(obtenerIndice(destination), 0);
		matrizDePesos.get(obtenerIndice(initial)).set(obtenerIndice(destination), Double.MAX_VALUE);

		if (!isDirigido()) {

			matrizDeAdyacencia.get(obtenerIndice(destination)).set(obtenerIndice(initial), 0);
			matrizDePesos.get(obtenerIndice(destination)).set(obtenerIndice(initial), Double.MAX_VALUE);
		}
		totalAristas--;
	}


	public ArrayList<NodoMatriz<T>> getVecinos(NodoMatriz<T> x) {
		ArrayList<NodoMatriz<T>> adjVertices = new ArrayList<>();
		int index = obtenerIndice(x);
		for (int i = 0; i < matrizDeAdyacencia.get(index).size(); i++) {
			if (matrizDeAdyacencia.get(index).get(i) == 1.0) {
				adjVertices.add(nodos.get(i));
			}
		}
		return adjVertices;
	}


	public ArrayList<NodoMatriz<T>> bfs(NodoMatriz<T> v){
		ArrayList<NodoMatriz<T>> orden = new ArrayList<>();
		ArrayList<NodoMatriz<T>> marcado = new ArrayList<>();
		Queue<NodoMatriz<T>> cola = new LinkedList<>();
		marcado.add(v);
		cola.add(v);
		while(!cola.isEmpty()){
			NodoMatriz<T> ac = cola.poll();
			orden.add(ac);
			ArrayList<NodoMatriz<T>> vecinos = getVecinos(ac);
			if(vecinos != null){
				for(NodoMatriz<T> n : vecinos){
					NodoMatriz<T> destino = n;
					if(!marcado.contains(destino)){
						marcado.add(destino);
						cola.offer(destino);                                                                         
					}
				}
			}
		}
		return orden;
	}
	
    public double distanciaEntreCiudades(T orig, T dest) {
    	double distancia=0;
    	
    	
    	HashMap<T, Double> caminocorto =dijkstra(orig);
    	if(caminocorto.containsKey(orig)&&caminocorto.containsKey(dest)) {
    	distancia=caminocorto.get(dest);
    	}else {
    		return 0;
    	}
    	
    	return distancia;
    }
    public HashMap<T, Double> dijkstra(T vo){
        HashMap<T, Double> dist = new HashMap<>();
        PriorityQueue<T> cola = new PriorityQueue<>();
        for(T k : grafo.keySet()){
            dist.put(k, Double.MAX_VALUE/2);
        }
        dist.put(vo,0.0);
        cola.add(vo);
        while(!cola.isEmpty()){
            T ac1 = cola.poll();
//            System.out.println(ac1);
            NodoMatriz<T> ac= buscarNodo(ac1);
            ArrayList<NodoMatriz<T>> vecinos = getVecinos(ac);
           
            if(vecinos != null){
                for(NodoMatriz<T> n : vecinos){
                    T vertSig = n.getValue();
//                    System.out.println(vertSig);
                    double costo =getPesosArista(ac,n);
//                    System.out.println(dist.get(ac1)+costo);
//                    System.out.println(dist.get(vertSig));
                    if(dist.get(ac1)+costo < dist.get(vertSig)){
                        dist.put(vertSig,dist.get(ac1)+costo);
                        cola.offer(vertSig);

                    }
                }
            }
        }
        return dist;
    }
	public double getPesosArista(NodoMatriz<T> nodo1, NodoMatriz<T> nodo2) {
		double peso = 0;
		int indX = obtenerIndice(nodo1);
		int indY = obtenerIndice(nodo2);
		if (buscarNodo(nodo1.getValue())!=null && buscarNodo(nodo2.getValue())!=null) {
			peso = matrizDePesos.get(indX).get(indY);
		}
		return peso;
	}
	
    public HashMap<T, Double> bellman(T vo){
        HashMap<T, Double> dist = new HashMap<>();
        for(T k : grafo.keySet()){
            dist.put(k, Double.MAX_VALUE/2);
        }
        dist.put(vo,0.0);

        for(int i=0; i<grafo.size()-1; i++){
            for(T ac1 : grafo.keySet()){
            	NodoMatriz<T> ac= buscarNodo(ac1);
            	ArrayList<NodoMatriz<T>> vecinos = getVecinos(ac);
                if(vecinos != null){
                    for(NodoMatriz<T> n : vecinos){
                        T vertSig = n.getValue();
                        double costo =getPesosArista(ac,n);
                        if(dist.get(ac1)+costo < dist.get(vertSig)){
                            dist.put(vertSig,dist.get(ac1)+costo);
                        }
                    }
                }
            }
        }
        
        return dist;
    }
    public double distanciaEntreCiudadesBellman(T orig, T dest) {
    	double distancia=0;
    	
    	
    	HashMap<T, Double> caminocorto =bellman(orig);
    	if(caminocorto.containsKey(orig)&&caminocorto.containsKey(dest)) {
    	distancia=caminocorto.get(dest);
    	}else {
    		return 0;
    	}
    	
    	return distancia;
    }
	
}
