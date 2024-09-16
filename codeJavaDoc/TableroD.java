import java.util.InputMismatchException;
import java.util.Scanner;


/**
* Clase donde se define el tablero defensor de cada jugador
*/

public class TableroD extends Tablero{
    

    /**
    * Matriz donde se almacenaran las fichas colocadas por el jugador
    */
    private Fichas[][] board;

    /**
    * Constructor donde se crea el tablero con un tamanio y se inicializa con objetos del tipo Mar
    * @param t Tamanio del tablero
    */
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
    
    /**
    * Metodo que devuelve el tablero
    *@return El tablero
    */
    public Fichas[][] getBoard() {
        return this.board;
    }

    /**
    * Metodo que muestra el tablero por pantalla
    *@see getId
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
                System.out.print(" " + board[i][j].getId() + " ");
            }
            System.out.println("]");
        }
    }

    /**
    * Metodo que verifica si una ficha de cualquier tipo, puede ser colocada en el tablero
    *@param position Posicion inicial donde se coloca la pieza
    *@param pieza Tipo de ficha que se busca colocar en el tablero
    *@see getFila
    *@see getColumna
    *@see getTamanio
    *@see verificarAdyacente
    *@throws InputMismatchException
    *@return Opcion elegida por el usuario para la direccion hacia la que quiera colocar la pieza, 0 en caso de que no pueda colocarse
    */
    public int verificarMapa(Posicion position, Fichas pieza) {
        int option = 0;
        int h = pieza.getTamanio(), fila = position.getFila(), columna = position.getColumna();
        Scanner scanner4 = new Scanner(System.in);

        if (this.board[fila][columna].getId() != 'M'){
            return 0;
        }

        if (pieza.getId() == 'L'){
            if (!verificarAdyacentes(fila, columna)){
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
                        if (!verificarAdyacentes(i, columna)){
                            return 0;
                        }
                    }
                    break;
                case 2:
                    for (int i = fila; i<=fila+h-1; i++){
                        if (!verificarAdyacentes(i, columna)){
                            return 0;
                        }
                    }   
                    break;
                case 3:
                    for (int i = columna; i<=columna+h-1; i++){
                        if (!verificarAdyacentes(fila, i)){
                            return 0;
                        }
                    }
                    break;
                case 4:
                    for (int i = columna; i>=columna-h+1; i--){
                        if (!verificarAdyacentes(fila, i)){
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
    /**
    *Metodo que verifica si una posicion es apropiada para la colocacion de un Barco sobre ella
    *@param i Fila de la posicion a analizar
    *@param j Columna de la posicion a analizar
    *@return EL valor de verdad de si la posicion es apta para la colocacion de un barco
    */
    private boolean verificarAdyacentes(int i, int j) {
        int filas = this.tamanio;
        int columnas = this.tamanio;

        if (i < 0 || i >= filas || j < 0 || j >= columnas){
            return false;
        }

        if (this.board[i][j].getId() !='M'){
            return false;
        }

        if (i - 1 >= 0) {
            if (this.board[i-1][j].getId() != 'M' && this.board[i-1][j].getId() != 'I' ){
                return false;
            }
        }

        if (i + 1 < filas) {
            if (this.board[i+1][j].getId() != 'M' && this.board[i+1][j].getId() != 'I' ){
                return false;
            }
        }

        if (j - 1 >= 0) {
            if (this.board[i][j-1].getId() != 'M' && this.board[i][j-1].getId() != 'I' ){
                return false;
            }
        }

        if (j + 1 < columnas) {
            if (this.board[i][j+1].getId() != 'M' && this.board[i][j+1].getId() != 'I' ){
                return false;
            }
        }

        return true;
    }
}
