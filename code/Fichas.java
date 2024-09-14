
public abstract class Fichas implements Colocable{
    
    private char identificador;
    private int tamano;

    
    public Fichas(int t, char id){
        this.tamano = t;
        this.identificador =  id;
    }

    public int getTamano(){
        return this.tamano;
    }

    public char getId(){
        return this.identificador;
    }

    public void setId(char x){
        this.identificador = x;
    }

    public void disminuirTamano(){
        this.tamano--;
    }

    public void colocar(Jugador p1, Posicion position, int option){
    
    }
}