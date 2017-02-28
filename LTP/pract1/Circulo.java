
/**
 * Write a description of class Circulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Circulo extends Figura{
    protected double r;
    Circulo(double a, double b,double c){
        super(a,b);
        r=c;
    }

    public String toString (){
        return "Crculo:\n\t"+
        "Posicion: ("+x+","+y+
        ")\n\tRadio: "+r;
    }

    public boolean equals(Object cir) {
        if((cir instanceof Circulo)) {
            Circulo c = (Circulo) cir;
            return (x==c.x && y == c.y && r == c.r);
        }
        else {
            return false;
        }
    }

    public double area (){
        return Math.pow(r,2)*Math.PI;
    }
}

