/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Armando
 */
public class Recursividad1 {
    
    /*
        System.out.println("Resto: " + Recursividad1.modulo(15, 4));
        System.out.println("Division: " + Recursividad1.division(14, 3));
        System.out.println("Multiplicacion: " + Recursividad1.multiplicacion(3, 5));
        System.out.println("Nº Cifras: " + Recursividad1.numCifras(723));
        System.out.println("Suma Nº Cifras: " + Recursividad1.sumNumCifras(727));
        System.out.println("Entero reves: " + Recursividad1.enteroReves(256));
        System.out.println("Divisible9: " + Recursividad1.divisible9(657));
    */

    public static int modulo(int numerador, int denominador) {
        if (numerador >= denominador) {
            return modulo(numerador - denominador, denominador);
        } else {
            return numerador;
        }
    }

    public static int division(int num, int den) {
        if (num < den) {
            return 0;
        } else {
            return 1 + division(num - den, den);
        }
    }

    public static int multiplicacion(int a, int b) {
        if (b > 0) {
            return a + multiplicacion(a, b - 1);
        } else {
            return 0;
        }
    }

    public static int numCifras(int a) {
        if (a > 0) {
            return 1 + numCifras(a / 10);
        } else {
            return 0;
        }
    }

    public static int sumNumCifras(int a) {
        if (a > 10) {
            return (a % 10) + sumNumCifras(a / 10);
        } else {
            return a % 10;
        }
    }

    public static int enteroReves(int a) {
        if (a > 10) {
            return ((a % 10) * ((int) Math.pow(10, numCifras(a) - 1))) + enteroReves(a / 10);
        } else {
            return a % 10;
        }
    }

    public static boolean divisible9(int a) {
        int b = modulo(sumNumCifras(a), 9);
        if (b == 0) {
            return true;
        } else {
            return false;
        }
    }
}
