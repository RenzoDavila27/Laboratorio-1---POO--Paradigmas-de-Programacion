/**
 * La clase Posicion tendra las coordenadas de un posicion del tablero (x,y)
 */
public class Posicion {
    private int fila,columna; 
    
    /**
     * Constructor que crea una posición con la fila y la columna especificadas.
     * 
     * @param a La fila de la posición en el tablero.
     * @param b La columna de la posición en el tablero.
     */
    public Posicion(int a,int b){
        this.fila = a;
        this.columna = b;
    }
    /**
     * Obtiene la fila de la posicion
     * @return La fila de la posicion
     */
    public int getFila(){
        return this.fila;
    }
    /**
     * Obtiene la fila de la posicion
     * @return La columna de la posicion
     */
    public int getColumna(){
        return this.columna;
    }
}
