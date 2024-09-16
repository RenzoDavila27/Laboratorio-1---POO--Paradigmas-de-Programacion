/**
 * Representa una isla de tamaño 2x2 que extiende la clase Isla.
 */
public class Isla2x2 extends Isla{
    /**
     * Constructor que crea una Isla 2x2, con tamaño 4 
     */
    public Isla2x2(){
        super(4);
    }
    /**
     * Coloca la isla de tamaño 2x2 en el tablero de defensa del jugador, comenzando
     * desde la posición dada.
     * @param j El jugador al que pertenece el tablero donde se colocará la isla.
     * @param position La posición inicial donde se quiere colocar la isla.
     * @see Jugador
     * @see Posicion
     * @see getFila
     * @see getColumna
     * @see getBoard
     */
    
    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        for (int i=0;i<=1;i++){
            for (int n=0;n<=1;n++){
                j.deffenseBoard.getBoard()[fila+i][columna+n] = this;
            }   
        
        }

    }

}
