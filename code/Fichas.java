
public abstract class Fichas implements Colocable{
    
    private char identificador;
    private int tamanio;

    
    public Fichas(int t, char id){
        this.tamanio = t;
        this.identificador =  id;
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public char getId(){
        return this.identificador;
    }

    public void setId(char x){
        this.identificador = x;
    }

    public void disminuirTamanio(){
        this.tamanio--;
    }

    public void colocar(Jugador j, Posicion position, int option){
        
        int columna = position.getColumna();
        int fila = position.getFila();

        switch (option){
            case 1:
                for (int i = fila; i >= fila-tamanio+1;i--){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 2:
                for (int i = fila; i <= fila+tamanio-1;i++){
                    j.deffenseBoard.getBoard()[i][columna] = this;
                }
                break;
            case 3:
                for (int i = columna; i <= columna+tamanio-1;i++){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
            case 4:
                for (int i = columna; i >= columna-tamanio+1;i--){
                    j.deffenseBoard.getBoard()[fila][i] = this;
                }
                break;
        }

    }
}