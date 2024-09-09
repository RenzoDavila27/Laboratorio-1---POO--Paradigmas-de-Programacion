
public class Lancha extends Fichas implements Barco{

    public Lancha(){
        super(1, 'L');

    }
    
    public void colocarBarco(Jugador j, Coordenadas position, int option){
        
        j.deffenseBoard.board[position.x][position.y] = this;

    }
}