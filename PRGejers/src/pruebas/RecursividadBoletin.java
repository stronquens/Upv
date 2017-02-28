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
public class RecursividadBoletin {

    // Ejer 1
    public static boolean contieneCero(int[] a) {
        return contieneCero(a, 0);
    }

    private static boolean contieneCero(int[] a, int ini) {
        if (a.length - 1 < ini) {
            return false;
        }
        if (a[ini] == 0) {
            return true;
        } else {
            return contieneCero(a, ini + 1);
        }

    }

    // Ejer 2
    public static boolean dobles(int[] a) {
        return dobles(a, a.length - 1);
    }

    private static boolean dobles(int[] a, int fin) {
        if (fin < 1 || a[fin] != (a[fin - 1] * 2)) {
            return false;
        }
        if (fin == 1) {
            return true;
        } else {
            return dobles(a, fin - 1);
        }
    }

    // Ejer 3
    public static boolean paresOrdenados(int[] a) {
        return paresOrdenados(a, 1);
    }

    public static boolean paresOrdenados(int[] a, int ini) {
        if (ini > a.length - 1) {
            return true;
        }
        if (a[ini - 1] % 2 == 0 && a[ini] % 2 == 0 && a[ini - 1] <= a[ini]) {
            return paresOrdenados(a, ini + 1);
        } else {
            return false;
        }
    }

    // Ejer 4
    public static boolean prodAnt(int[] a) {
        return prodAnt(a, 2);
    }

    public static boolean prodAnt(int[] a, int ini) {
        if (ini > a.length - 1) {
            return true;
        } else if (a[ini] == (a[ini - 1] * a[ini - 2])) {
            return prodAnt(a, ini + 1);
        } else {
            return false;
        }
    }

    // Ejer 5
    public static int[] sust(int[] a, int p, int v) {
        /*if (v > a[p]) {
            a[p] = v;
            if (p - 1 >= 0) {
                a = sust(a, p - 1, v);
            }
            if (p + 1 <= a.length - 1) {
                a = sust(a, p + 1, v);
            }
        }*/
        if (p < 0 || p > a.length - 1) {
            return a;
        }
        if (v > a[p]) {
            a[p] = v;
            a = sust(a, p - 1, v);
            a = sust(a, p + 1, v);
        }
        return a;
    }

    // Ejer 6
    public static boolean iguales(int[] a, int[] b) {
        return iguales(a, b, 0);
    }

    private static boolean iguales(int[] a, int[] b, int c) {
        if (c == a.length || c == b.length) {
            return true;
        }
        if ((a.length != b.length) || (a[c] != b[c])) {
            return false;
        }
        return iguales(a, b, c + 1);
    }

    // Ejer 7
    public static int cuentaIguales(int[] a, int[] b) {
        return cuentaIguales(a, b, 0);
    }

    private static int cuentaIguales(int[] a, int[] b, int it) {
        if (it == a.length) {
            return 0;
        }
        if (a[it] == b[it]) {
            return 1 + cuentaIguales(a, b, it + 1);
        } else {
            return cuentaIguales(a, b, it + 1);
        }
    }

    // Ejer 8
    public static int cuentaChar(char[] a, char c) {
        return cuentaChar(a, c, 0);
    }

    private static int cuentaChar(char[] a, char c, int it) {
        if (it > a.length - 1) {
            return 0;
        } else if (a[it] == c) {
            return 1 + cuentaChar(a, c, it + 1);
        } else {
            return cuentaChar(a, c, it + 1);
        }
    }

    // Ejer 9
    public static boolean sonInversos(int[] a, int[] b) {
        return sonInversos(a, b, 0);
    }

    private static boolean sonInversos(int[] a, int[] b, int it) {
        if (it > a.length - 1) {
            return true;
        } else if (a[it] != b[b.length - 1 - it]) {
            return false;
        } else {
            return sonInversos(a, b, it + 1);
        }
    }

    // Ejer 10
    public static int sumatorio10(int[] a1, int[] a2) {
        return sumatorio10(a1, a2, 0);
    }

    private static int sumatorio10(int[] a1, int[] a2, int it) {
        if (it > a1.length - 1) {
            return 0;
        } else {
            return (a1[it] * a2[it]) + sumatorio10(a1, a2, it + 1);
        }
    }

    // Ejer 11
    public static boolean sumaPares(int[] a, int v) {
        return sumaPares(a, 0, v);
    }

    private static boolean sumaPares(int[] a, int it, int v) {
        if (it > a.length - 1 - it) {
            return true;
        } else if ((a[it] + a[a.length - 1 - it]) != v) {
            return false;
        } else {
            return sumaPares(a, it + 1, v);
        }
    }

    // Ejer 12 
    public static int cuentaRango(int[] a, int it, int min, int max) {
        if (it > a.length - 1) {
            return 0;
        } else if (a[it] >= min && a[it] <= max) {
            return 1 + cuentaRango(a, it + 1, min, max);
        } else {
            return cuentaRango(a, it + 1, min, max);
        }
    }

    // Ejer 14 
    public static int[] invertirArray(int[] a, int it) {
        if (it == a.length - 1) {
            return a;
        } else {
            int aux = a[it];
            a[it] = a[a.length - 1 - it];
            a[a.length - 1 - it] = aux;
            return invertirArray(a, it + 1);
        }
    }

    // Ejer 15
    public static int minimoLocal(int[] a, int it) {
        if (((it - 1) < 0 || ((it + 1)) > (a.length - 1))) {
            return -1;
        }
        if ((a[it - 1] < a[it]) && (a[it] > a[it + 1])) {
            return it;
        }
        return -1;
    }

    // Ejer 17
    public static boolean parImpar(int[] a) {
        return parImpar(a, 0);
    }

    private static boolean parImpar(int[] a, int it) {
        if (it > a.length - 1) {
            return true;
        }
        if (((((it % 2) == 0) || (it == 0)) && a[it] < 0)
                || (((it % 2) != 0) && a[it] > 0)) {
            return false;
        } else {
            return parImpar(a, it + 1);
        }
    }

    // Ejer 18
    public static int aparicionesString(String s, char c) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == c) {
            return 1 + aparicionesString(s.substring(1), c);
        } else {
            return aparicionesString(s.substring(1), c);
        }
    }

    // Ejer 19
    public static int stringLetters(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (Character.isLetter(s.charAt(0))) {
            return 1 + stringLetters(s.substring(1));
        } else {
            return stringLetters(s.substring(1));
        }
    }

    /*-------------- De clase */
    public static int[] integralArray(int[] a, int it, int sum) {
        if (it > a.length - 1) {
            return a;
        } else {
            sum += a[it];
            a[it] = sum;
            return a = integralArray(a, it + 1, sum);
        }
    }

    // it = a.length-1
    public static int[] integralArray2(int[] a, int it) {
        if ((a.length - 1 - it) == a.length - 1) {
            return a;
        } else {
            a[it] = a[it] + integralArray2(a, it - 1)[it - 1];
            return a;
        }
    }

    // it=1
    public static void integralArraySol(int[] a, int it) {
        if (it < a.length) {
            a[it] = a[it] + a[it - 1];
            integralArraySol(a, it + 1);
        }
    }

    public static boolean inversos(int[] a1, int[] a2, int it) {
        if (it > (a1.length - 1)) {
            return true;
        }
        if (a1[it] != a2[(a2.length - 1 - it)]) {
            return false;
        } else {
            return inversos(a1, a2, it + 1);
        }
    }

    public static int prodEscalar(int[] a1, int[] a2, int it) {
        if (it > (a1.length - 1)) {
            return 0;
        } else {
            return (a1[it] * a2[it]) + prodEscalar(a1, a2, it + 1);
        }
    }

}
