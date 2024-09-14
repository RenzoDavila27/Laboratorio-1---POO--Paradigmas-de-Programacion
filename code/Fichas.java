
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

    public void colocar(Jugador p1, Posicion position, int option){
    
    }
}