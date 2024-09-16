/**
* Clase donde se define el tablero atacado de cada jugador
*/
public class TableroA extends Tablero{
    /**
    * Matriz donde se almacenaran los disparos del jugador enemigo
    */
    private char[][] board;

    /**
    * Constructor del tablero atacado, donde se creara el tablero y se inicializara con caracteres '?'
    *@param t Tamanio del tablero
    */
    public TableroA(int t){
        super(t);
        this.board = new char[t][t];
        for (int i=0;i<t;i++){
            for (int j=0;j<t;j++){
                this.board[i][j] = '?';
            }
        }
    }

    /**
    * Metodo para devolver el tablero
    *@return El tablero
    */
    public char[][] getBoard() {
        return this.board;
    }
    /**
    * Metodo para mostrar el tablero por pantalla
    */
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
