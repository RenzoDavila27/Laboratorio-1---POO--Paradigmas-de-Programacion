public class Isla1x2 extends Isla{
    
    public Isla1x2(){
        super(2);
    }

    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        j.deffenseBoard.getBoard()[fila][columna] = this;
        j.deffenseBoard.getBoard()[fila][columna+1] = this;

    }
}
