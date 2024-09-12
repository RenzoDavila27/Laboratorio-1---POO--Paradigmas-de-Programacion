public class Isla2x2 extends Isla{
    
    public Isla2x2(){
        super(4);
    }

    public void colocar(Jugador j, Posicion position){
        
        int fila = position.getFila(), columna = position.getColumna();

        for (int i=0;i<=1;i++){
            for (int n=0;n<=1;n++){
                j.deffenseBoard.getBoard()[fila+i][columna+n] = this;
            }   
        
        }

    }

}
