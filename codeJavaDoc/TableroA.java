public class TableroA extends Tablero{

    private char[][] board;

    public TableroA(int t){
        super(t);
        this.board = new char[t][t];
        for (int i=0;i<t;i++){
            for (int j=0;j<t;j++){
                this.board[i][j] = '?';
            }
        }
    }

    public char[][] getBoard() {
        return this.board;
    }
    public void mostrarTablero(){

        System.out.print("    ");
        for (int p = 0; p < tamanio; p++){
            System.out.print(p + "  ");
        }
        System.out.println("");

        for (int i=0;i<tamanio;i++){
            System.out.print(i + " [");
            for (int j=0;j<tamanio;j++){
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println("]");
        }
    
    }

}
