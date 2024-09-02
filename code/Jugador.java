public class Jugador {
    public String nombre;
    public int cantBarcos;
    public TableroA attackBoard;
    public TableroD deffenseBoard;
    
    public Jugador(String n, Juego j){
        this.nombre = n;
        this.attackBoard = new TableroA();
        this.deffenseBoard = new TableroD();
        this.cantBarcos = j.cantBarcos;
    }

    

}
