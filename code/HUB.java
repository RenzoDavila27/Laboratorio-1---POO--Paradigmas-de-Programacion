
import java.util.Scanner;


public class HUB {
    public static void main(String[] args) {

        int option;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println(
                "¡Bienvenidos a Batalla Naval!\nSeleccione una opcion:\n1. Empezar a jugar\n2. Leer reglas\n3. Salir del juego");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                scanner.close();
                System.out.println("Inicia el juego");
                break;
            case 2:

                leerReglas();
                System.out.println("¿Quieres comenzar a jugar?");
                String option2 = scanner.nextLine();
                if (option2.toLowerCase().equals("y")) {
                    System.out.println("Inicia el juego");
                } else {
                    System.exit(0);
                }
            case 3:
                System.exit(0);
        }
        while (option != 1)
            ;
        scanner.close();
        scanner2.close();
    }

    private static void leerReglas() {
        System.out.println("blabla");
    }
     private static void jugar(){
        Juego game;
        int size;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String name1 = scanner1.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        String name2 = scanner1.nextLine();
        Jugador j1 = new Jugador(name1);
        Jugador j2 = new Jugador(name2);
        System.out.println("Hola jugador "+j1.name+" y "+j2.name);
        System.out.println("Opciones de tablero:\n1. 10x10 - 5 barcos - 70 intentos\n2. 7x7 - 4 barcos - 32 intentos\n3. 5x5 - 3 barcos - 18 ");
        do{
            size = scanner1.nextInt();
            switch(size){
                case 1:
                    game = new Juego(j1,j2,10,70,7);
                    j1.cantBarcos = 7;
                    j2.cantBarcos = 7;
                    break;
                case 2:
                    game = new Juego(j1,j2,7,32,5);
                    j1.cantBarcos = 5;
                    j2.cantBarcos = 5;
                    break;
                case 3:
                    game = new Juego(j1,j2,5,18,3);
                    j1.cantBarcos = 3;
                    j2.cantBarcos = 3;
                    break;
            }
        } while(size>3 || size<1);
        game.





        char[][] matriz = new char[3][3];
        for (int i=0;i<=2;i++){
            for (int j=0;j<=2;j++){
                System.out.println()
            }
        }
        
        

    }

   
}