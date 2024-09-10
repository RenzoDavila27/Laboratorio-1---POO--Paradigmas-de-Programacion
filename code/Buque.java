public class Buque extends Fichas implements Colocable{

    public Buque(){
        super(4, 'B');
    }

    public void colocar(Jugador j, Coordenadas position, int option){
        
        int equis = position.getX();
        int ye = position.getY();

        switch (option){
            case 1:
                for (int i = ye; i >= ye-3;i--){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 2:
                for (int i = ye; i <= ye+3;i++){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 3:
                for (int i = equis; i <= equis+3;i++){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
            case 4:
                for (int i = equis; i >= equis-3;i--){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
        }

    }
}
