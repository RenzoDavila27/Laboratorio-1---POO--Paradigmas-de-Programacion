public class Lancha extends Fichas implements Barco{

    public Lancha(Coordenadas position){
        super(position, 'L');

    }

    public void colocarBarco(Jugador j, Coordenadas position){
        if (Jugador.deffenseBoard[position.x][position.y].identificador == 'M'){
            Jugador.deffenseBoard[position.x][position.y] = new Lancha(position);
        }
    }
}