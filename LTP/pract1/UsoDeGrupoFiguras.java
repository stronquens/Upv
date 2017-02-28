
/**
 * Write a description of class d here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UsoDeGrupoFiguras{
    public static void main (String args[]){
        GrupoFiguras g = new GrupoFiguras();
        g.anyadeFigura(new Circulo(10,5,3.5));
        g.anyadeFigura(new Triangulo(10,5,6.5,32));
        g.anyadeFigura(new Circulo(11,6,4));
        g.anyadeFigura(new Triangulo(8,4,2.3,21));
        g.anyadeFigura(new Rectangulo(8,4,2.3,21));
        
        GrupoFiguras g1 = new GrupoFiguras();
        g1.anyadeFigura(new Circulo(10,5,3.5));
        g1.anyadeFigura(new Triangulo(10,5,6.5,32));
        g1.anyadeFigura(new Circulo(11,6,4));
        g1.anyadeFigura(new Triangulo(8,4,2.3,21));
        g1.anyadeFigura(new Triangulo(8,4,2.3,21));
        g1.anyadeFigura(new Rectangulo(8,4,2.3,21));
        
        
        System.out.println(g);
        System.out.println("Los grupos son iguales: "+g.equals(g1));
        System.out.println("Area Circulo: "+new Circulo(10,5,3.5).area());
        System.out.println("Area Triangulo: "+new Triangulo(8,4,2.3,21).area());
        System.out.println("Area Rectangulo: "+new Rectangulo(8,4,2.3,21).area());
        System.out.println("Suma areas grupo: "+g1.area());
        
        System.out.println("Area Cilindro: "+new Cilindro(0,0,5,10).area());
    }
}