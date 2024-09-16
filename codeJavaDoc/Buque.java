/**
 * La clase Buque representa un barco de tipo buque que extiende la clase Fichas.
 */
public class Buque extends Fichas{
    /**
     * Constructor que crea un Buque con tamaño 4 y un identificador 'B'.
     */
    public Buque(){
        super(4, 'B');
    }
    /**
    * Coloca el buque en el tablero de defensa del jugador en la posición dada
    * y en una dirección específica, según la opción seleccionada.
    * 
    * @param j El jugador al que pertenece el tablero donde se colocará el buque.
    * @param position La posición inicial donde se quiere colocar el buque.
    * @param option   La dirección en la que se colocará el buque
    * @see getColumna
    * @see getFila
    * @see getBoard
    */
    public void colocar(Jugador j, Posicion position, int option){
        
        int fila = position.getFila();
        int columna = position.getColumna();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-3;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+3;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+3;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-3;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }
}
/**
 * Descripcion de metodo o clase

 */