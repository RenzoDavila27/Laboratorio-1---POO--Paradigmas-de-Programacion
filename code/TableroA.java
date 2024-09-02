public class TableroA implements Tablero{
    int tamaño;
    char[][] board;
    public TableroA(int t){
        this.tamaño = t;
        this.board = new char[t][t];
        for (int i=0;i<t;i++){
            for (int j=0;j<t;j++){
                this.board[i][j] = 'M';
            }
        }
    }
    
}
