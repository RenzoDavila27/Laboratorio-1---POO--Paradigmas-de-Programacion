
public abstract class Fichas implements Colocable{
    
    private char identificador;
    private int tamaño;

    
    public Fichas(int t, char id){
        this.tamaño = t;
        this.identificador =  id;
    }

    public int getTamaño(){
        return this.tamaño;
    }

    public char getId(){
        return this.identificador;
    }

    public void setId(char x){
        this.identificador = x;
    }

    public void disminuirTamaño(){
        this.tamaño--;
    }

    public void colocar(Jugador p1, Posicion position, int option){
    
    }
}