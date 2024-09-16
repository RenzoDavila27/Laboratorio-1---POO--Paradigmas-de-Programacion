import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int cantBarcos, aciertos;
    private ArrayList<String> barcosRestantes, barcosEliminados;
    public TableroA attackBoard;
    public TableroD deffenseBoard;
    
    public Jugador(String n, int t, int b){
        this.nombre = n;
        this.aciertos = 0;
        this.cantBarcos = b;
        this.attackBoard = new TableroA(t);
        this.deffenseBoard = new TableroD(t);
        this.barcosEliminados = new ArrayList<>();
        this.barcosRestantes = new ArrayList<>();
    }

    public String getName() {
        return this.nombre;
    }

    public int getCantBarcos() {
        return this.cantBarcos;
    }

    public void disminuirCantBarcos() {
        this.cantBarcos--;
    }

    public int getAciertos(){
        return this.aciertos;
    }

    public void aumentarAciertos() {
        aciertos++;
    }

    public void inicializarBarcos(String[] barcos){
        
        for (String barco: barcos){
            this.barcosRestantes.add(barco);
        }

    }

    public void mostrarBarcosRestantes() {
        System.out.println(this.barcosRestantes);
    }

    public void mostrarBarcosEliminados() {
        System.out.println(this.barcosEliminados);
    }

    public void eliminarBarco(String barco){

        this.barcosRestantes.remove(barco);
        this.barcosEliminados.add(barco);

    }
}
