
/**
 * Write a description of class Rectangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangulo extends Figura {
    private double base,altura;

    public Rectangulo(double x, double y, double base, double altura) {
        super(x,y);
        this.base = base;
        this.altura=altura;
    }

    public String toString (){
        return "Rectangulo:\n\t"+
        "Posicion: ("+x+","+y+
        ")\n\tBase: "+base+
        "\n\tAltura: "+altura;
    }

    public boolean equals(Object rec) {
        if((rec instanceof Rectangulo)) {
            Rectangulo rc = (Rectangulo) rec;
            return (x==rc.x && y == rc.y && base==rc.base && altura==rc.altura);
        }
        else {
            return false;
        }
    }

    public double area (){
        return base * altura;
    }
}
