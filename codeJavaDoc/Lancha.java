/**
 * La clase Lancha representa un barco de tipo lancha que extiende la clase Fichas.
 */
public class Lancha extends Fichas{
     /**
     * Constructor que crea una Lancha con tamanio 1 y un identificador 'L'.
     */
    public Lancha(){
        super(1, 'L');

    }
    /**
     * Coloca la lancha en el tablero de defensa del jugador en la posición dada.
     * La lancha ocupa solo una posición en el tablero.
     * 
     * @param j El jugador al que pertenece el tablero donde se colocará la lancha.
     * @param position La posición donde se quiere colocar la lancha (especificando fila y columna).
     * @param option La opción de colocación, que en este caso no afecta ya que la lancha 
     * siempre ocupa solo una posición.
     */
    public void colocar(Jugador j, Posicion position, int option){
        
        j.deffenseBoard.getBoard()[position.getFila()][position.getColumna()] = this;

    }
}