/**
 * La clase Restos reprenseta el disparo acertado a unos de los buques de tu tablero defensor
 */
public class Restos extends Fichas {
    /**
     * Constructor que crea Restos de tamanio 1 y un identificador que puede ser X o O
     * @param identificador
     */
    public Restos(char identificador){
        super(1, identificador);
    }

}
