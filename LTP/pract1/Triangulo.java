
/**
 * Write a description of class Triangulo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Triangulo extends Figura{
    private double base,altura;

    public Triangulo(double x,double y,double base, double altura){
        super(x,y);
        this.base= base;
        this.altura=altura;
    }

    public String toString(){ 
        return "Triangulo:\n\t"+
        "Posicion: ("+x+","+y+
        ")\n\tBase: "+base+
        "\n\tAltura: "+altura;
    }

    public boolean equals(Object tri) {
        if((tri instanceof Triangulo)) {
            Triangulo t = (Triangulo) tri;
            return (x==t.x && y == t.y && base==t.base && altura==t.altura);
        }
        else {
            return false;
        }
    }

    public double area (){
        return base * altura / 2;
    }
}