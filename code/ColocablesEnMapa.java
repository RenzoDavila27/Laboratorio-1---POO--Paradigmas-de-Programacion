
import java.util.ArrayList;

public abstract class ColocablesEnMapa{
    public ArrayList<Coordenadas> position = new ArrayList<>();
    public char identificador;
    public int tamaño;

    
    public ColocablesEnMapa(Coordenadas position, char id){
        this.position.add(position);
        this.identificador =  id;
    }
}