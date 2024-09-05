public class Jugador {
    public String nombre;
    public int cantBarcos;
    public TableroA attackBoard;
    public TableroD deffenseBoard;
    
    public Jugador(String n, int t, int b){
        this.nombre = n;
        this.cantBarcos = b;
        this.attackBoard = new TableroA(t);
        this.deffenseBoard = new TableroD(t);
    }

    

}
