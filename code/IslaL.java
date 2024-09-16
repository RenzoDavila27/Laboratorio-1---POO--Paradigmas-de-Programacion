public class IslaL extends Isla{

    public IslaL(){
        super(4);
    }

    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        for (int i=0;i<=2;i++){
            j.deffenseBoard.getBoard()[fila+i][columna] = this;
        }

        j.deffenseBoard.getBoard()[fila+2][columna+1] = this;

    }
}
