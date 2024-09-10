public class TableroA extends Tablero{
    private int tamaño;
    private char[][] board;

    public TableroA(int t){
        super(t);
        this.board = new char[t][t];
        for (int i=0;i<t;i++){
            for (int j=0;j<t;j++){
                this.board[i][j] = 'M';
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }
    public void MostrarTablero(){

        System.out.print("   ");
        for (int p = 0; p <= tamaño; p++){
            System.out.print(p + " ");
        }

        for (int i=0;i<tamaño;i++){
            System.out.print("1 [");
            for (int j=0;j<tamaño;j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println("]");
        }
    
    }

}
