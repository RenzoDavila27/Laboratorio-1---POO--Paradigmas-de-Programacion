public class Mar extends Fichas{
    
    public Mar(){
        super(1,'M');
    }

    public void colocar(Fichas[][] board, Posicion position){
        
        board[position.getFila()][position.getColumna()] = this;
        
    }

}
