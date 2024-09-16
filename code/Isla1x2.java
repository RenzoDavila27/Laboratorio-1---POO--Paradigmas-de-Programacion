import com.ibm.security.krb5.internal.crypto.j;

/**
 * Representa una isla de tamaño 1x2 que extiende la clase Isla, que ocupa 2 posiciones en el tablero.
 */
public class Isla1x2 extends Isla{
    /**
     * Constructor que crea una Isla1x2, con tamaño 2.
     */
    public Isla1x2(){
        super(2);
    }
    /** 
    * Coloca la isla de tamaño 1x2 en el tablero de defensa del jugador
    * comenzando en la posición dada. La isla se coloca horizontalmente en dos posiciones consecutivas.
    * 
    * @param j        El jugador al que pertenece el tablero donde se colocará la isla.
    * @param position La posición inicial donde se quiere colocar la isla (en la fila y columna dadas).
    * @see getBoard
    * @see getFila
    * @see getColumna
    * @see Jugador
    * @see Posicion
    */

    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        j.deffenseBoard.getBoard()[fila][columna] = this;
        j.deffenseBoard.getBoard()[fila][columna+1] = this;

    }
}
