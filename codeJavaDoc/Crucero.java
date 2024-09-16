
/**
 * La clase Crucero representa un barco de tipo crucero que extiende la clase Fichas.
 */
public class Crucero extends Fichas{
    
    
    /**
     *Constructor que crea un Crucero con tamanio 2 y un identificador 'C'
     */
    public Crucero(){
        super(2, 'C');
    }
    /**
     *Coloca el crucero en el tablero de defensa del jugador en la posición dada y en una dirección específica, según la opción seleccionada.
     * @param j        El jugador al que pertenece el tablero donde se colocará el crucero.
     * @param position La posición inicial donde se quiere colocar el crucero.
     * @param option   La dirección en la que se colocará el crucero:
     * @see getColumna
     * @see getFila
     * @see getBoard
     */
    public void colocar(Jugador j, Posicion position, int option){
        
        int columna = position.getColumna();
        int fila = position.getFila();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-1;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+1;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+1;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-1;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }

}
