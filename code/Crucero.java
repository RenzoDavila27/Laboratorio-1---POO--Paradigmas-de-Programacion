public class Crucero extends Fichas implements Barco{
    
    public Crucero(){
        super(3, 'S');
    }

    public void colocarBarco(Jugador j, Coordenadas position, int option){
        
        int ye = position.getY();
        int equis = position.getX();

        switch (option){
            case 1:
                for (int i = ye; i >= ye-1;i--){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 2:
                for (int i = ye; i <= ye+1;i++){
                    j.deffenseBoard.board[equis][i] = this;
                }
                break;
            case 3:
                for (int i = equis; i <= equis+1;i++){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
            case 4:
                for (int i = equis; i >= equis-1;i--){
                    j.deffenseBoard.board[i][ye] = this;
                }
                break;
        }

    }

}
