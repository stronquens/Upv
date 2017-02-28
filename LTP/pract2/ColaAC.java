// package lineales.implementacionesDeModelos; 

import librerias.modelos.Cola;

public class ColaAC <T> implements Cola<T> { 
    //Definicion de los atributos necesarios:
    //elArray, una array de tipo generico \verb"T" para guardar los elementos de la cola
    private T[] elArray;
    // dos atributos primero y ultimo de tipo entero que mantienen una referencia a los indices donde estan situados el primer y ??ltimo elemento de la cola. 
    private int primero, ultimo, talla;
    // un atributo talla para representar la cantidad de elementos de la cola. 
    private static int MAX = 10;

    /**Constructor de Cola */
    //El compilador nos avisa (warning) de que el tipo puro correspondiente a T en (1) se aplicara
    //en tiempo de ejecucion. Con esta directiva le decimos que no nos muestre el aviso ya que la coercion es segura.
    @SuppressWarnings({"unchecked"})
    public ColaAC () {
        elArray = (T[]) (new Object [MAX]); //(1)
        //COMPLETAR
        this.primero = 0;
        this.ultimo = -1;
        this.talla = 0;
    }

    /** Metodo privado para ampliar el array si hace falta**/
    @SuppressWarnings({"unchecked"})
    private void ampliarElArray(){
        T[]  arrayAux = (T[]) (new Object [elArray.length*2]);
        int i = 0,
        tallaAux=talla;
        
        while(!this.esVacia()) {
            try {
                arrayAux [i++] = this.desencolar();
            } catch(Exception e) {
                System.out.println("Error al intentar ampliar una cola");
            }
        }
            
        elArray = arrayAux;
        this.primero = 0;
        this.ultimo = tallaAux-1;
        this.talla = tallaAux;
    }

    // Implementacion de las operaciones del TAD definido en la interfaz Pila <T>:
    // Metodos modificadores del estado de una cola:

    /** Inserta el Elemento e en una cola situandolo al final **/

    public void encolar(T e) {
        //COMPLETAR
        if(talla == elArray.length) {
            ampliarElArray();
        }
        
        talla++;
        ultimo = incrementar(ultimo);
        elArray[ultimo] = e;
    }

    /** Consulta y extrae el primer elemento, solo si la cola no esta vacia.**/
    public T desencolar(){
        //COMPLETAR
        if(talla == 0) return null;
        else {
            T aux = elArray[primero];
            primero = incrementar(primero);
            talla--;
            return aux;
        }   
    }

    // Metodos consultores del estado de la cola
    /** Devuelve la cantidad de elementos  de la cola **/
    public int talla(){
        //COMPLETAR
        return this.talla;
    }

    /** Solo si la cola no esta vacia, consulta el primer elemento en cabeza,
     * (el primero en orden de insercion) **/
    public T primero() {
        //COMPLETAR
        return this.elArray[primero];
    }

    /** Comprueba si una cola esta vacia **/
    public boolean esVacia(){
        //COMPLETAR
        return this.talla == 0;
    }//Fin del metodo boolean esVacia()

    /** Devuelve la siguiente posicion ocupada del array modulo MAX.
    Esta instruccion puede sustituirse por (i+1)%elArray.length**/
    private int incrementar (int i) {
        //COMPLETAR
        if(i == elArray.length -1){
            return 0;
        } else {
            return i+1;
        }
    }

    /** Devuelve el contenido de la cola con el formato 
    <-elem0<-elem1<-elem2<-...<-elemN<- donde N = talla()-1
    Cada elemi se devuelve con el formato que este definido para su tipo
     **/ 
    public String toString (){
        //COMPLETAR
        String res = "";
        for(int i=0; i<talla; i++) {
            res += "<- " + (elArray[primero+i]) +" ";
        }
        return res;
    }
}

