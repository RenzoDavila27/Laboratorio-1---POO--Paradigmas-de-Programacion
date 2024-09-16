/**
 * La clase abstracta Isla representa una isla en el juego que extiende la clase Fichas.
 * Las islas no pueden moverse ni atacar, pero ocupan espacio en el tablero y pueden tener diferentes tamanios.
 */

public abstract class Isla extends Fichas {
      /**
     * Constructor que crea una isla con el tamanio especificado.
     * El identificador de una isla es 'I'.
     * 
     * @param t El tamanio de la isla 
     */
    public Isla(int t){
        super(t,'I');
    }

}
