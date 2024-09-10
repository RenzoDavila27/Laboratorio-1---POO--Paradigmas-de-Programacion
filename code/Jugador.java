public class Jugador {
    private String nombre;
    private int cantBarcos;
    public TableroA attackBoard;
    public TableroD deffenseBoard;
    
    public Jugador(String n, int t, int b){
        this.nombre = n;
        this.cantBarcos = b;
        this.attackBoard = new TableroA(t);
        this.deffenseBoard = new TableroD(t);
    }

    public String getName() {
        return this.nombre;
    }

    public int getCantBarcos() {
        return this.cantBarcos;
    }
}
