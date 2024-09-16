/**
 * La clase Mar representa el oceano en el juego que extiende la clase Fichas.
 * El Mar no pueden moverse ni atacar, pero ocupan espacio en el tablero.
 */

public class Mar extends Fichas{
    /**
     * Construir que crea Mar con tamanio 1 e identificado 'M'
     */
    public Mar(){
        super(1,'M');
    }
    /**
     * Coloca la ficha en el tablero especificado en la posición dada.
     * @param board Tablero Defensor al cual se le colocando el objeto Mar
     * @param position Posicion donde se quiere colocar el Mar
     */

    public void colocar(Fichas[][] board, Posicion position){
        
        board[position.getFila()][position.getColumna()] = this;
        
        
    }

}
