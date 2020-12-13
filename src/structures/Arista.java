package structures;

import java.io.Serializable;



public class Arista<T> implements Comparable<Arista<T>>, Serializable {
	
	private NodoMatriz<T> origen;
	private NodoMatriz<T> destino;
	private int peso;

	public Arista(NodoMatriz<T> ori,NodoMatriz<T> dest,int peso) {
		origen=ori;
		destino = dest;
		this.peso=peso;
	}
	@Override
	public int compareTo(Arista<T> o) {
		// TODO Auto-generated method stub
		return  Double.compare(peso, o.peso);
	}

}
