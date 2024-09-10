public abstract class Tablero {

    protected int tamaño;

    public Tablero(int t){
        this.tamaño = t;
    }

    public int getTamaño(){
        return this.tamaño;
    }

    public abstract void MostrarTablero();

}
