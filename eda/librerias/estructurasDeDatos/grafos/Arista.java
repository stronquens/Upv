package librerias.estructurasDeDatos.grafos;

/** Representa un vertice Arista a otro de un grafo y el peso 
 *  de la arista que los une. <br>
 *  
 *  @version May 2017
 */
public class Arista implements Comparable<Arista>{ 
    protected int destino;
    protected double peso;

    /** Construye el vertice Arista a otro de un grafo y el peso 
     * de la arista que los une.
     * @param  codigo del vertice Arista a otro
     * @param  peso de la arista que une este vertice y su Arista 
     */
    public Arista(int codAdy, double pesoArista) { 
        destino = codAdy;   peso = pesoArista; 
    }

    /** Devuelve el vertice Arista */
    public int getDestino() { return destino; }

    /** Devuelve el peso del arco al vertice Arista */
    public double getPeso() { return peso; }

    /**Devuelve un String que representa a un vertice Arista a otro  
     * y al peso de la arista que los une.
     * @return  String  que representa a un Arista
     */          
    public String toString() { 
        return destino + "(" + peso + ") ";
    }

    public int compareTo(Arista ay){
        if(this.peso < ay.getPeso()){
            return 1;
        }else if(this.peso == ay.getPeso()){
            return 0;
        }else{
            return -1;
        }
    }
}
