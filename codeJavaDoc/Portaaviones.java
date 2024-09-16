/**
 * La clase Portaaviones representa un barco de tipo crucero que extiende la clase Fichas.
 */
public class Portaaviones extends Fichas {
    
     /**
     *Constructor que crea un Portaaviones con tamanio 5 y un identificador 'P'
     */
    public Portaaviones(){
        super(5, 'P');
    }
    /**
     *Coloca el Portaaviones en el tablero de defensa del jugador en la posición dada y en una dirección específica, según la opción seleccionada.
     * @param j El jugador al que pertenece el tablero donde se colocará el Portaaviones.
     * @param position La posición inicial donde se quiere colocar el Portaaviones.
     * @param option La dirección en la que se colocará el Portaaviones:
     * @see getColumna
     * @see getFila
     * @see getBoard
     */
    public void colocar(Jugador j, Posicion position, int option){
        
        int fila = position.getFila();
        int columna = position.getColumna();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-4;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+4;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+4;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-4;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }
}
