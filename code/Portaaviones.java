public class Portaaviones extends Fichas {
    
    public Portaaviones(){
        super(5, 'P');
    }

    public void colocar(Jugador j, Coordenadas position, int option){
        
        int equis = position.getX();
        int ye = position.getY();

        switch (option){
            case 1:
                for (int i = ye; i >= ye-4;i--){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 2:
                for (int i = ye; i <= ye+4;i++){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 3:
                for (int i = equis; i <= equis+4;i++){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
            case 4:
                for (int i = equis; i >= equis-4;i--){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
        }

    }
}
