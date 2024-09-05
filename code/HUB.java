
import java.util.Scanner;


public class HUB {

    public HUB(){

    }
    
    public void ingresarHub() {

        int option;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "¡Bienvenidos a Batalla Naval!\nSeleccione una opcion:\n1. Empezar a jugar\n2. Leer reglas\n3. Salir del juego");
        option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Inicia el juego");
                return;
            case 2:
                leerReglas();
                System.out.println("¿Quieres comenzar a jugar?");
                String option2 = scanner.nextLine();
                if (option2.toLowerCase().equals("y")) {
                    return;
                } else {
                    System.exit(0);
                }
            case 3:
                System.exit(0);
        }

        return;
    }

    private static void leerReglas() {
        System.out.println("blabla");
    }
        
        

    }
