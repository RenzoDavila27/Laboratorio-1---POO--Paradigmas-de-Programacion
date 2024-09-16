/**
 * La clase Fichas reprenseta los Barcos en el juego e implementa Colocable
 */
public abstract class Fichas implements Colocable{
    
    private char identificador; // Caracter que identifica a la nave
    private int tamanio; // Tamaño de la ficha (Barco)

    /**
     * Constructor de Fichas 
     * @param t Tamaño de la ficha
     * @param id Caracter que identifica al barco
     */
    public Fichas(int t, char id){
        this.tamanio = t;
        this.identificador =  id;
    }
    /**
     * Obtiene el tamaño de la Ficha
     * @return El tamaño de la ficha
     */
    public int getTamanio(){
        return this.tamanio;
    }
    /**
     * Obtiene el identificador de la ficha
     * @return Identificador de la ficha
     */
    public char getId(){
        return this.identificador;
    }
    /**
     * Le asigna un caracter al identificador de la ficha
     * @param x Caracter que se le asignara a la ficha
     */
    public void setId(char x){
        this.identificador = x;
    }
    /**
     * Disminuye el tamaño de la ficha en 1
     */
    public void disminuirTamanio(){
        this.tamanio--;
    }
    /**
     * Metodo implementado de 
     */
    public void colocar(Jugador p1, Posicion position, int option){
    
    }
}