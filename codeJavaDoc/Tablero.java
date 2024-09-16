public abstract class Tablero {

    protected int tamanio;

    public Tablero(int t){
        this.tamanio = t;
    }

    public int getTamanio(){
        return this.tamanio;
    }

    public abstract void mostrarTablero();

}
