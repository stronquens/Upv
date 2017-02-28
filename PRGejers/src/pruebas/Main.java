/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.Arrays;

/**
 *
 * @author Armando
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 0};
        int[] b = {2, 4, 8, 16};
        int[] c = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] d1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] d2 = {1, 2, 3, 4, 5, 6, 7, 8, 8};

        System.out.println("ContieneCero: " + RecursividadBoletin.contieneCero(a));
        System.out.println("Dobles: " + RecursividadBoletin.dobles(b));
        System.out.println("Sust: " + Arrays.toString(RecursividadBoletin.sust(c, 3, 7)));
        System.out.println("Iguales: " + RecursividadBoletin.iguales(d1, d2));
        System.out.println("CentaIguales: " + RecursividadBoletin.cuentaIguales(d1, d2));
        System.out.println("======================  BOLETIN  =============================");

        // Ejer 3
        int[] paresOrd = {1, 4, 6, 8};
        System.out.println("Pares Ordenados:" + RecursividadBoletin.paresOrdenados(paresOrd));
        // Ejer 4
        int[] prodAnt = {1, 2, 2, 4, 8};
        System.out.println("Producto Anteriores:" + RecursividadBoletin.prodAnt(prodAnt));
        //Ejer 8
        char[] cuentachar = {'a', 'b', 'c'};
        System.out.println("Cuenta Char: " + RecursividadBoletin.cuentaChar(cuentachar, 'c'));

        // Ejer 9
        int[] inverso1 = {1, 2, 3};
        int[] inverso2 = {3, 2, 1};
        System.out.println("Son Inversos: " + RecursividadBoletin.sonInversos(inverso1, inverso2));

        // Ejer 10
        System.out.println("Sumatorio Producto: " + RecursividadBoletin.sumatorio10(inverso1, inverso2));

        //Ejer 11
        int[] sumaPares = {10, 7, 6};
        System.out.println("Suma Pares: " + RecursividadBoletin.sumaPares(sumaPares, 16));

        // Ejer 12
        int[] cuentaRango = {4, 2, 3, 4};
        System.out.println("Cuenta Rango: " + RecursividadBoletin.cuentaRango(cuentaRango, 0, 3, 5));

        // Ejer 14
        int[] invelem = {1, 2, 3, 4};
        invelem = RecursividadBoletin.invertirArray(invelem, 0);
        System.out.println("Invertir Array: " + invelem[0]+" "+invelem[1]+" "+invelem[2]+" "+invelem[3]);

        // Ejer 15
        int[] maximl = {1,4,3};
        System.out.println("Minimo Local: " + RecursividadBoletin.minimoLocal(maximl, 1));
        
        // Ejer 17
        int[] parimpar = {2, -2, 1, -1, 3, -3};
        System.out.println("Par Impar: " + RecursividadBoletin.parImpar(parimpar));

        // Ejer 18
        String nombre = "armando";
        System.out.println("Apariciones string: " + RecursividadBoletin.aparicionesString(nombre, 'a'));
        
        // Ejer 19
        String letters = "1234 arman 56";
        System.out.println("Letters string: " + RecursividadBoletin.stringLetters(letters));
        
        System.out.println("======================  CLASE  =============================");
        int[]integralArray = {1,2,3,4};
        //integralArray = RecursividadBoletin.integralArray(integralArray,0,0);
        //integralArray = RecursividadBoletin.integralArray2(integralArray,integralArray.length-1);
        RecursividadBoletin.integralArraySol(integralArray,1);
        System.out.println("Integral Array: " + integralArray[0]+" "+integralArray[1]+" "+integralArray[2]+" "+integralArray[3]);
    
        System.out.println("Son Inversos: " + RecursividadBoletin.inversos(inverso1,inverso2,0));
        
        System.out.println("Producto Escalar: " + RecursividadBoletin.prodEscalar(inverso1,inverso2,0));
    }

}
