/** 
 * Clase dedicada a ser superclase de los tableros, en donde aplicaremos atributos y metodos en comun
*/
public abstract class Tablero {

    /** 
    * Atributo del tamanio del tablero
    */
    protected int tamanio;
    /** 
    * Constructor, donde se inicializa el tamanio
    *@param t Tamanio del tablero
    */
    public Tablero(int t){
        this.tamanio = t;
    }
    /** 
    * Metodo para devoler el tamanio
    * @return El tamanio
    */
    public int getTamanio(){
        return this.tamanio;
    }

    public abstract void mostrarTablero();

}
