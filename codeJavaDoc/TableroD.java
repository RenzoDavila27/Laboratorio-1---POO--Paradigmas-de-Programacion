import java.util.InputMismatchException;
import java.util.Scanner;

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

    public int verificarMapa(Posicion position, Fichas pieza) {
        int option = 0;
        int h = pieza.getTamanio(), fila = position.getFila(), columna = position.getColumna();
        Scanner scanner4 = new Scanner(System.in);

        if (this.board[fila][columna].getId() != 'M'){
            return 0;
        }

        if (pieza.getId() == 'L'){
            if (!verificarAdyacentes(this.board, fila, columna)){
                return 0;
            }else{
                return 1;
            }
        }

        do {
            System.out.println("Opciones para colacar su barco: \n1. Hacia arriba\n2. Hacia abajo\n3. Hacia la derecha\n4. Hacia la izquierda");
            try{
                option = scanner4.nextInt();
            }catch(InputMismatchException e){
                scanner4.next();
            }
            switch (option) {
                case 1:
                    for (int i = fila; i>=fila-h+1; i--){
                        if (!verificarAdyacentes(this.board, i, columna)){
                            return 0;
                        }
                    }
                    break;
                case 2:
                    for (int i = fila; i<=fila+h-1; i++){
                        if (!verificarAdyacentes(this.board, i, columna)){
                            return 0;
                        }
                    }   
                    break;
                case 3:
                    for (int i = columna; i<=columna+h-1; i++){
                        if (!verificarAdyacentes(this.board, fila, i)){
                            return 0;
                        }
                    }
                    break;
                case 4:
                    for (int i = columna; i>=columna-h+1; i--){
                        if (!verificarAdyacentes(this.board, fila, i)){
                            return 0;
                        }
                    }
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option < 1 || option > 4);

        return option;

    }
    
    public static boolean verificarAdyacentes(Fichas[][] board, int i, int j) {
        int filas = board.length;
        int columnas = board.length;

        if (i < 0 || i >= filas || j < 0 || j >= columnas){
            return false;
        }

        if (board[i][j].getId() !='M'){
            return false;
        }

        if (i - 1 >= 0) {
            if (board[i-1][j].getId() != 'M' && board[i-1][j].getId() != 'I' ){
                return false;
            }
        }

        if (i + 1 < filas) {
            if (board[i+1][j].getId() != 'M' && board[i+1][j].getId() != 'I' ){
                return false;
            }
        }

        if (j - 1 >= 0) {
            if (board[i][j-1].getId() != 'M' && board[i][j-1].getId() != 'I' ){
                return false;
            }
        }

        if (j + 1 < columnas) {
            if (board[i][j+1].getId() != 'M' && board[i][j+1].getId() != 'I' ){
                return false;
            }
        }

        return true;
    }
}
