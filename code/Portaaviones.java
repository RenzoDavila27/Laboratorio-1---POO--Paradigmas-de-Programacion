public class Portaaviones extends Fichas {
    
    public Portaaviones(){
        super(5, 'P');
    }

    public void colocar(Jugador j, Posicion position, int option){
        
        int fila = position.getFila();
        int columna = position.getColumna();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-4;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+4;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+4;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-4;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }
}
