import java.util.ArrayList;
/**
 * La clase Jugador guarda toda la informacion del propio jugador en el juego, como su nombre
 * cantidad de barcos y acierto, su tablero atancate y defensor.
 */

public class Jugador {
    private String nombre;
    private int cantBarcos, aciertos;
    private ArrayList<String> barcosRestantes, barcosEliminados;
    public TableroA attackBoard;
    public TableroD deffenseBoard;
    /**
     * Constructor que crea Jugador, con un nombre, un tamaño de tablero, cantidad de aciertos, cantidad de barcos
     * , tablero atacante y defensor, sus barcos eliminados y barcos restantes.
     * @param n Nombre del Jugador
     * @param t Tamaño del Tablero
     * @param b Cantidad de Barcos elegidos para jugar
     * @see TableroA
     * @see TableroD
     */
    
    public Jugador(String n, int t, int b){
        this.nombre = n;
        this.aciertos = 0;
        this.cantBarcos = b;
        this.attackBoard = new TableroA(t);
        this.deffenseBoard = new TableroD(t);
        this.barcosEliminados = new ArrayList<>();
        this.barcosRestantes = new ArrayList<>();
    }
    /**
     * Obtiene el nombre del Jugador
     * @return El nombre del Jugador
     */
    public String getName() {
        return this.nombre;
    }
    /**
     * Obtiene la cantidad de barcos del jugador
     * @return La cantidad de barcos del jugador
     */
    public int getCantBarcos() {
        return this.cantBarcos;
    }
    /**
     * Disminuye el tamaño de cantidad de barcos en 1
     * @return La cantidad de barcos disminuido en 1
     */
    public void disminuirCantBarcos() {
        this.cantBarcos--;
    }
    /**
     * Obtiene los aciertos del Jugador
     * @return Los acierdos del Jugador
     */
    public int getAciertos(){
        return this.aciertos;
    }
    /**
     * Aumenta los Aciertos en 1
     * 
     */
    public void aumentarAciertos() {
        aciertos++;
    }
    /**
     * Agrega los barcos seleccionados para jugar en el Array de barcos restantes del Jugador
     * @param barcos Array de barcos elegidos para jugar
     */
    public void inicializarBarcos(String[] barcos){
        
        for (String barco: barcos){
            this.barcosRestantes.add(barco);
        }

    }
    /**
     * Muestra el array de barcos restantes del jugador
     */

    public void mostrarBarcosRestantes() {
        System.out.println(this.barcosRestantes);
    }
    /**     
    * Muestra el array de barcos elimandos del jugador
    */
    public void mostrarBarcosEliminados() {
        System.out.println(this.barcosEliminados);
    }
    /**
     * Elimina un barco del array de barcos restantes y lo agrega en el array de barcos eliminados
     * @param barco Barco que se quiere eliminar
     */

    public void eliminarBarco(String barco){

        this.barcosRestantes.remove(barco);
        this.barcosEliminados.add(barco);

    }
}
