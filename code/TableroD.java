public class TableroD extends Tablero{
    
    private Fichas[][] board;

    public TableroD(int t){
        super(t);
        this.board = new Fichas[t][t];
        for (int i=0;i<t;i++){
            for (int j=0;j<t;j++){
                Mar m = new Mar();
                Posicion a = new Posicion(i, j);
                m.colocar(this.board, a);
            }
        }
    }

    public Fichas[][] getBoard() {
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
                System.out.print(" " + board[i][j].getId() + " ");
            }
            System.out.println("]");
        }
    }
}
