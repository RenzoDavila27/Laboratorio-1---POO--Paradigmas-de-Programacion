public class Mar extends Fichas{
    
    public Mar(){
        super(1,'M');
    }

    public void colocar(Fichas[][] board, Coordenadas position){
        
        board[position.getX()][position.getY()] = this;
        
        
    }

}
