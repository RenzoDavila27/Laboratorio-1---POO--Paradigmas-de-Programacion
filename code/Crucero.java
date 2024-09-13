public class Crucero extends Fichas{
    
    

    public Crucero(){
        super(2, 'C');
    }

    public void colocar(Jugador j, Posicion position, int option){
        
        int columna = position.getColumna();
        int fila = position.getFila();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-1;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+1;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+1;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-1;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }

}
