public class Restos extends Fichas {
    
    public Restos(char identificador){
        super(1, identificador);
    }

    public void colocar(Fichas[][] board, Posicion position){
        
        board[position.getFila()][position.getColumna()] = this;
        
    }

}
