import java.util.Scanner;

public class Juego{

    private static void main(String[] args){
        Barco[] barcos;
        int metodoDeJuego;
        int tamaño = 0, cantIntentos = 0, cantBarcos = 0;
        Jugador[] players = new Jugador[2];
        HUB start = new HUB();

        start.ingresarHub();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String name1 = scanner1.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        String name2 = scanner1.nextLine();
        System.out.println("Hola jugador "+ name1 +" y "+ name2);
        System.out.println("Opciones de tablero:\n1. 10x10 - 5 barcos - 70 intentos\n2. 7x7 - 4 barcos - 32 intentos\n3. 5x5 - 3 barcos - 18 ");
        do{
            metodoDeJuego = scanner1.nextInt();
            switch(metodoDeJuego){
                case 1:
                    tamaño = 10;
                    cantBarcos = 5;
                    cantIntentos = 140; //70 para cada jugador
                    break;
                case 2:
                    tamaño = 7;
                    cantBarcos = 4;
                    cantIntentos = 64; //32 para cada jugador
                    break;
                case 3:
                    tamaño = 5;
                    cantBarcos = 3;
                    cantIntentos = 36; //18 para cada jugador
                    break;
            }
        } while(metodoDeJuego>3 || metodoDeJuego<1);

        scanner1.close();
        players[0] = new Jugador(name1, tamaño, cantBarcos);
        players[1] = new Jugador(name2, tamaño, cantBarcos);

    }

    public void seleccionDeBarcos() {
        
    }
    


}
