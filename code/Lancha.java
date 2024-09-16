
public class Lancha extends Fichas{

    public Lancha(){
        super(1, 'L');

    }
    
    public void colocar(Jugador j, Posicion position){
        
        j.deffenseBoard.getBoard()[position.getFila()][position.getColumna()] = this;

    }
}