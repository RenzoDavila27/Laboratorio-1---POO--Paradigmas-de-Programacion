/**
 * La clase Lancha representa un barco de tipo lancha que extiende la clase Fichas.
 */
public class Lancha extends Fichas{
     /**
     * Constructor que crea una Lancha con tamaño 1 y un identificador 'L'.
     */
    public Lancha(){
        super(1, 'L');

    }
    /**
     * 
     */
    public void colocar(Jugador j, Posicion position, int option){
        
        j.deffenseBoard.getBoard()[position.getFila()][position.getColumna()] = this;

    }
}