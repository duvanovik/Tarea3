package structures;

import java.util.HashMap;

import model.Road;

import java.util.ArrayList;
import java.util.*;
public class Grafo{
    private HashMap<String, ArrayList<Nodo>> grafo;
    private boolean dirigido;
    private int cantidadVertices;
    private int cantidadAristas;
    
    public Grafo(boolean dir){
        grafo = new HashMap<String, ArrayList<Nodo>>();
        dirigido = dir;
        cantidadAristas=0;
        cantidadVertices=0;
    }

    /**
     * Metodo encargado de agregar la arista al grafo.
     * @param orig - Vertice tipo String de origen.
     * @param dest - Vertice tipo String de destino.
     * @param costo - Costo de recorrer la arista.
     */
    public boolean agregarArista(String orig, String dest, int costo){
    	
        if(grafo.containsKey(orig)){        
        grafo.get(orig).add(new Nodo(dest,costo));
        }
        
        if(!dirigido){
            if(grafo.containsKey(dest)){        
                grafo.get(dest).add(new Nodo(orig,costo));
                cantidadAristas++;
                }  
        }
        
        if(grafo.containsKey(orig)&&grafo.containsKey(dest)) {
        	
        if(grafo.get(orig).contains(dest)||grafo.get(dest).contains(orig)) {
        	return false;
        }else {
        	return true;
        }
        }else {
        	return true;
        }
    }


    
    /**
     * Metodo encargado de eliminar una arista.
     * @param ori
     * @param dest
     */
    public boolean eliminarArista(String ori, String dest){
        
    	boolean eliminado=elimArista(ori,dest);
        if(!dirigido){
            return elimArista(dest,ori);
        }
        
        return eliminado;
    }

    /**
     * Metodo auxiliar para eliminar una arista del grafo.
     * @param ori
     * @param dest
     */
    public boolean elimArista(String ori, String dest){
        ArrayList<Nodo> lista= grafo.get(ori);
        boolean bb = false;
        if(lista != null){
            for(int i=0; i<lista.size() && !bb; i++){
                Nodo ac = lista.get(i);
                if(ac.getVertice().equals(dest)){
                    lista.remove(i);
                    bb = true;
                    cantidadAristas--;
                    return true;
                }
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de eliminar un vertice.
     * @param v - El vertice de tipo String
     */
    public void eliminarVertice(String v){
        ArrayList<Nodo> lista = grafo.get(v);
        ArrayList<String> destinos = new ArrayList<>();
        if(lista!=null) {
        for(Nodo n : lista){
            destinos.add(n.getVertice());
        }
        grafo.remove(v);
        cantidadVertices--;
        for(String s : destinos){
            eliminarArista(s, v);
        }
        }
    }

    
    /**
     * Metodo encargado de agregar un vertice al grafo.
     * @param v
     */
    public boolean agregarVertice(String v){
    	
    	if(!grafo.containsKey(v)) {
        grafo.put(v, new ArrayList<Nodo>());
        cantidadVertices++;
        return true;
    	}else {
    		return false;
    	}
    }

    public ArrayList<String> bfs(String v){
        ArrayList<String> orden = new ArrayList<>();
        ArrayList<String> marcado = new ArrayList<>();
        Queue<String> cola = new LinkedList<>();
        marcado.add(v);
        cola.add(v);
        while(!cola.isEmpty()){
            String ac = cola.poll();
            orden.add(ac);
            ArrayList<Nodo> vecinos = grafo.get(ac);
            if(vecinos != null){
                for(Nodo n : vecinos){
                    String destino = n.getVertice();
                    if(!marcado.contains(destino)){
                        marcado.add(destino);
                        cola.offer(destino);                                                                         
                    }
                }
            }
        }
        return orden;
    }

    public ArrayList<String> dfs(String v){
        ArrayList<String> orden = new ArrayList<>();
        ArrayList<String> marcado = new ArrayList<>();
        Stack<String> pila = new Stack<>();
        marcado.add(v);
        pila.add(v);
        while(!pila.isEmpty()){
            String ac = pila.pop();
            orden.add(ac);
            ArrayList<Nodo> vecinos = grafo.get(ac);
            if(vecinos != null){
                for(Nodo n : vecinos){
                    String destino = n.getVertice();
                    if(!marcado.contains(destino)){
                        marcado.add(destino);
                        pila.push(destino);
                    }
                }
            }
        }
        return orden;
    }

    /**
     * Metodo encargado de devolver una Road con las ciudades del camino más corto entre el origen y el destino.
     * @param orig - Ciudad de origen
     * @param dest - Ciudad de destino
     * @return Road con el camino.
     */
    public Road caminoMasCorto(String orig, String dest) {
    	
        ArrayList<ArrayList<String>> cam = caminos(orig,dest);
        int ultimoCamino=Integer.MAX_VALUE;
        ArrayList<String> camino=new ArrayList<String>();
		for(ArrayList<String> n:cam) {
			if(n.size()<ultimoCamino) {
				ultimoCamino=n.size();
				camino=n;
			}
			
		}
    	Road road=new Road(camino);
		
    	return road;
    }
    
    
    /**
     * Metodo auxiliar de caminoMasCorto.
     * @param vo - Ciudad origen
     * @param vd - Ciudad destino
     * @return
     */
    private ArrayList<ArrayList<String>> caminos(String vo, String vd){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> camino = new ArrayList<>();
        camino.add(vo);
        ArrayList<Nodo> vecinos = grafo.get(vo);
        for(Nodo n : vecinos){
            String act = n.getVertice();
            ArrayList<String> copia = (ArrayList<String>)camino.clone();
            copia.add(act);
            caminos(act, vd, copia, res);
        }
        return res;
    }
    

    

    /**
     * Metodo auxiliar de caminos.
     * @param vo
     * @param vd
     * @param camino
     * @param res
     */
    private void caminos(String vo, String vd, ArrayList<String> camino, ArrayList<ArrayList<String>> res){
        if(vo.equals(vd)){
        	
            res.add(camino);
        }else{
            ArrayList<Nodo> vecinos = grafo.get(vo);
            if(vecinos!=null){
                for(Nodo n : vecinos){
                    String act = n.getVertice();
                    ArrayList<String> copia = (ArrayList<String>)camino.clone();
                    if(!copia.contains(act)){
                        copia.add(act);
                        caminos(act, vd, copia, res);
                    }
                }
            }

        }
    }
    
    

    
    /**
     * Este método se encarga de calcular la distancia entre dos ciudades
     * @param orig- Ciudad origen
     * @param dest- Ciudad destino
     * @return distancia en kilometros entre las ciudades.
     */
    public int distanciaEntreCiudades(String orig, String dest) {
    	int distancia=0;
    	
    	
    	HashMap<String, Integer> caminocorto =dijkstra(orig);
    	if(caminocorto.containsKey(orig)&&caminocorto.containsKey(dest)) {
    	distancia=caminocorto.get(dest);
    	}else {
    		return 0;
    	}
    	
    	return distancia;
    }
    
    

    
    
    /**
     * Metodo dijkstra
     * @param vo - Ciudad de origen
     * @return   HashMap con la distancia desde la ciudad de origen hasta las demás.
     */
    public HashMap<String, Integer> dijkstra(String vo){
        HashMap<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>();
        for(String k : grafo.keySet()){
            dist.put(k, Integer.MAX_VALUE/2);
        }
        dist.put(vo,0);
        cola.add(vo);
        while(!cola.isEmpty()){
            String ac = cola.poll();
            ArrayList<Nodo> vecinos = grafo.get(ac);
            if(vecinos != null){
                for(Nodo n : vecinos){
                    String vertSig = n.getVertice();
                    int costo = n.getCosto();
                    if(dist.get(ac)+costo < dist.get(vertSig)){
                        dist.put(vertSig,dist.get(ac)+costo);
                        cola.offer(vertSig);

                    }
                }
            }
        }
        return dist;
    }
    
    

    /**
     * Metodo bellman
     * @param ciudad de origen.
     * @return  HashMap con la distancia desde la ciudad de origen hasta las demás.
     */
    public HashMap<String, Integer> bellman(String vo){
        HashMap<String, Integer> dist = new HashMap<>();
        for(String k : grafo.keySet()){
            dist.put(k, Integer.MAX_VALUE/2);
        }
        dist.put(vo,0);

        for(int i=0; i<grafo.size()-1; i++){
            for(String ac : grafo.keySet()){
                ArrayList<Nodo> vecinos = grafo.get(ac);
                if(vecinos != null){
                    for(Nodo n : vecinos){
                        String vertSig = n.getVertice();
                        int costo = n.getCosto();
                        if(dist.get(ac)+costo < dist.get(vertSig)){
                            dist.put(vertSig,dist.get(ac)+costo);
                        }
                    }
                }
            }
        }
        
        return dist;
    }

	public HashMap<String, ArrayList<Nodo>> getGrafo() {
		return grafo;
	}

	public void setGrafo(HashMap<String, ArrayList<Nodo>> grafo) {
		this.grafo = grafo;
	}

	public boolean isDirigido() {
		return dirigido;
	}

	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}

	public int getCantidadVertices() {
		return cantidadVertices;
	}

	public void setCantidadVertices(int cantidadVertices) {
		this.cantidadVertices = cantidadVertices;
	}

	public int getCantidadAristas() {
		return cantidadAristas;
	}

	public void setCantidadAristas(int cantidadAristas) {
		this.cantidadAristas = cantidadAristas;
	}

    
    
    
}

