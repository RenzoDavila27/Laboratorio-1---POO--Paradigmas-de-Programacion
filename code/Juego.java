

public class Juego {
    public int tamaño, cantIntentos, cantBarcos;
    public Jugador[] players = new Jugador[2];
    
    public Juego(Jugador jug1, Jugador jug2, int t, int i, int b){
        this.players[0] = jug1;
        this.players[1] = jug2;
        this.tamaño = t;
        this.cantIntentos = i;
        this.cantBarcos = b;
    }
    


}
