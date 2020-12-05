package structures;

public class Nodo{  
    private String vertice;
    private int costo;
    public Nodo(String ver, int costo){
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
