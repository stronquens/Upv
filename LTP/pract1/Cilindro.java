
/**
 * Write a description of class Cilindro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cilindro extends Circulo{
    protected double a;

    Cilindro(double x, double y, double radio, double altura){
        super(x,y,radio);
        a= altura;
    }

    Cilindro(Circulo c, double altura)
    {
        this(c.x, c.y, c.r, altura);
    }

    public double volumen()
    {
        return super.area()*a;
    }

    public double area()
    {
        Rectangulo rec = new Rectangulo(0,0,(2*Math.PI*r),a);
        return (2*super.area() + rec.area());
    }
}
