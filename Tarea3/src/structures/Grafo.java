package structures;

import java.util.HashMap;

import model.Road;

import java.util.ArrayList;
import java.util.*;
public class Grafo{
    private HashMap<String, ArrayList<Nodo>> grafo;
    private boolean dirigido;
    public Grafo(boolean dir){
        grafo = new HashMap<String, ArrayList<Nodo>>();
        dirigido = dir;
    }

    public void agregarArista(String orig, String dest, int costo){
        crearArista(orig,dest, costo);
        if(!dirigido){
            crearArista(dest,orig, costo);
        }
    }

    private void crearArista(String ori, String dest, int costo){
        if(!grafo.containsKey(ori)){
            grafo.put(ori, new ArrayList<Nodo>());
        }
        grafo.get(ori).add(new Nodo(dest,costo));
    }

    public void eliminarArista(String ori, String dest){
        elimArista(ori,dest);
        if(!dirigido){
            elimArista(dest,ori);
        }
    }

    public void elimArista(String ori, String dest){
        ArrayList<Nodo> lista= grafo.get(ori);
        boolean bb = false;
        if(lista != null){
            for(int i=0; i<lista.size() && !bb; i++){
                Nodo ac = lista.get(i);
                if(ac.getVertice().equals(dest)){
                    lista.remove(i);
                    bb = true;
                }
            }
        }
    }

    public void eliminarVertice(String v){
        ArrayList<Nodo> lista = grafo.get(v);
        ArrayList<String> destinos = new ArrayList<>();
        for(Nodo n : lista){
            destinos.add(n.getVertice());
        }
        grafo.remove(v);
        for(String s : destinos){
            eliminarArista(s, v);
        }
    }

    public void agregarVertice(String v){
        grafo.put(v, new ArrayList<Nodo>());
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

    public ArrayList<ArrayList<String>> caminos(String vo, String vd){
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
     * @param orig
     * @param dest
     * @return
     */
    public int distanciaEntreCiudades(String orig, String dest) {
    	int distancia=0;
    	
    	HashMap<String, Integer> caminocorto =dijkstra(orig);
    	distancia=caminocorto.get(dest);
    	
    	return distancia;
    }
    
    
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
    
    
    public String dijkstraCaminoCorto(String orig,String dest){
        HashMap<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> cola = new PriorityQueue<>();
        for(String k : grafo.keySet()){
            dist.put(k, Integer.MAX_VALUE/2);
        }
        dist.put(orig,0);
        cola.add(orig);
        boolean finCamino=false;
        String camino=orig;
    	String ultimo=orig;

        
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
                        
                        if(finCamino==false) {
                        	
                        	if(!ultimo.equals(getKeyFromValue(dist, dist.get(ac))+"")) {
                        	camino+=","+getKeyFromValue(dist, dist.get(ac))+"";
                        	ultimo=getKeyFromValue(dist, dist.get(ac))+"";
                        	}
                        	
                        	if(vertSig==dest) {
                            	camino+=","+vertSig;
                        		finCamino=true;
                        	}
                        }
                    }
                }
            }
        }
    	int distancia = distancia=dist.get(dest);

        
        return distancia+","+camino;
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
          if (hm.get(o).equals(value)) {
            return o;
          }
        }
        return null;
      }
    
    
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

}

