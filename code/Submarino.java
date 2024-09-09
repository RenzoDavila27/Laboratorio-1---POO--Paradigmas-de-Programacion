public class Submarino extends Fichas implements Barco{
    
    public Submarino(){
        super(3, 'S');
    }

    public void colocarBarco(Jugador j, Coordenadas position, int option){
        
        int equis = position.getX();
        int ye = position.getY();

        switch (option){
            case 1:
                for (int i = ye; i >= ye-2;i--){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 2:
                for (int i = ye; i <= ye+2;i++){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 3:
                for (int i = equis; i <= equis+2;i++){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
            case 4:
                for (int i = equis; i >= equis-2;i--){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
        }

    }

}
