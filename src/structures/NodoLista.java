package structures;

public class NodoLista{  
    private String vertice;
    private int costo;
    public NodoLista(String ver, int costo){
        vertice = ver;
        this.costo = costo;
    }
    public String getVertice(){
        return vertice;
    }
    public int getCosto(){
        return costo;
    }
}
