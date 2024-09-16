/**
 * Representa una isla en forma de "L" de tamanio 3x2 que extiende la clase Isla.
 * La isla ocupa 4 posiciones en el tablero: tres en una columna y una más a la derecha en la última fila.
 */
public class IslaL extends Isla{
    /**
     * Constructor que crea una IslaL, con tamanio 4.
     */
    public IslaL(){
        super(4);
    }
    /**
     * Coloca la isla en forma de "L" en el tablero de defensa del jugador, comenzando desde la posición dada. 
     * @param j  El jugador al que pertenece el tablero donde se colocará la isla.
     * @param position La posición inicial donde se quiere colocar la isla.
     * @see Jugador
     * @see Posicion
     * @see getFila
     * @see getColumna
     * @see getBoard
     */
    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        for (int i=0;i<=2;i++){
            j.deffenseBoard.getBoard()[fila+i][columna] = this;
        }

        j.deffenseBoard.getBoard()[fila+2][columna+1] = this;

    }
}
