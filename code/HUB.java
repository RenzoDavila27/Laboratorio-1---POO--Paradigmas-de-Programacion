
import java.util.Scanner;


public class HUB {

    public HUB(){

    }
    
    public void ingresarHub() {

        int option;
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "¡Bienvenidos a Batalla Naval!\nSeleccione una opcion:\n1. Empezar a jugar\n2. Leer reglas\n3. Salir del juego");

        do{
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Inicia el juego");
                    return;
                case 2:
                    leerReglas();
                    System.out.println("¿Quieres comenzar a jugar? (y/n)");
                    String option2 = scanner.next();
                    if (option2.toLowerCase().equals("y")) {
                        System.out.println("Inicia el juego");
                        return;
                    } else {
                        System.exit(0);
                    }
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
            }
        }while (option < 1 || option > 3);
        scanner.close();
        return;
    }

    private static void leerReglas() {
        System.out.println("blabla");
    }
        
        

    }
