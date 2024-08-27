
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
                System.out.println("Inicia el juego");
                break;
            case 2:
                leerReglas();
                System.out.println("¿Quieres comenzar a jugar?");
                String option2 = scanner2.nextLine();
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
        
    }
}