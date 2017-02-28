
/**
 * Write a description of class GrupoFiguras here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GrupoFiguras {

    static final int MAX_NUM_FIGURAS = 10;
    private Figura [] listaFiguras = new Figura [MAX_NUM_FIGURAS];
    private int numF=0;

    public void anyadeFigura(Figura f) {
        listaFiguras[numF++]= f;

    }

    public String toString(){
        String s= "Crculos:";
        for(int i = 0;i < numF; i++)
            if (listaFiguras[i] instanceof Circulo) s+="\n"+listaFiguras[i];
        s+= "\nTriangulos:";
        for(int i = 0;i < numF; i++)
            if (listaFiguras[i] instanceof Triangulo)s+="\n"+listaFiguras[i];
        return s;
    }

    public boolean equals(Object fig) {
        if(!(fig instanceof GrupoFiguras)) {
            return false;
        }
        GrupoFiguras aux = (GrupoFiguras) fig;
        for(int i=0; i<numF; i++) {
            if(!aux.busqueda(listaFiguras[i])){
                return false;
            }
        } 
        int auxNum = aux.numF;
        Object [] auxArray = aux.listaFiguras;
        for(int j=0; j<auxNum; j++) {
            if(!this.busqueda(auxArray[j])){
                return false;
            }
        } 
        return true;
    }

    public boolean busqueda(Object r) {
        for(int i=0; i<numF; i++) {
            if(listaFiguras[i].equals(r)) {
                return true;
            }
        }
        return false;
    }

    public double area(){
        double suma = 0.0;
        for (int i=0; i<numF; i++){
            suma += listaFiguras[i].area();
        }
        return suma;
    }
}

