
public class Lancha extends Fichas{

    public Lancha(){
        super(1, 'L');

    }
    
    public void colocar(Jugador j, Coordenadas position, int option){
        
        j.deffenseBoard.board[position.getX()][position.getY()] = this;

    }
}