public class Lancha extends Fichas implements Barco{

    public Lancha(){
        super(1, 'L');

    }

    public void colocarBarco(Jugador j, Coordenadas position){
        if (j.deffenseBoard[position.x][position.y].identificador == 'M'){
            j.deffenseBoard[position.x][position.y] = new Lancha(position);
        }
    }
}