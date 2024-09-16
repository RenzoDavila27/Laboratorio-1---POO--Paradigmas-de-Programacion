
import java.util.InputMismatchException;
import java.util.Scanner;
    /**
    *La clase HUB maneja el inicio del juego dandole 3 opciones al usuario Salir, Jugar, LeerReglas
    */
public class HUB {
    
    /**
    * Constructor que crea a HUB
    */

    public HUB(){
    }
   
    /**
    * Muestra en pantalla las opciones y le da a elegir. 
    * @throws InputMismatchExcept
    * @return Null
    */
    
    public void ingresarHub() {

       
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenidos a Batalla Naval!\nSeleccione una opcion:\n1. Empezar a jugar\n2. Leer reglas\n3. Salir del juego");

        do{
            try{
                option = scanner.nextInt();
            }catch(InputMismatchException e){
                scanner.next();
            }
            switch (option) {
                case 1:
                    System.out.println("Inicia el juego");
                    return;
                case 2:
                    leerReglas();
                    System.out.println("¿Quieres comenzar a jugar? (y/n)");
                    String option2 = "a";
                    do{
                        try{
                            option2 = scanner.next();
                        }catch(InputMismatchException e){
                            scanner.next();
                        }
                        switch (option2) {
                            case "y":
                                System.out.println("Inicia el juego");
                                return;

                            case "n":
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Opcion invalida vuelva a intentarlo");
                                break;
                        }

                    }while (option2!="a");
                    System.exit(0);

                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opcion invalida");
            }
        }while (option < 1 || option > 3);
        scanner.close();
    }

    /**
    * Muestra en pantalla las Reglas del Juego.
    */

    public static void leerReglas() {
        
        System.out.println("En este pequenio apartado, les enseniaremos como jugar correctamente:");
        System.out.println("1er paso: Ingresaran sus nombres");
        System.out.println("2do paso: Eligiran la opcion de tablero, ademas de la cantidad de barcos, islas e intentos");
        System.out.println("3er paso: Realizaran la seleccion de barcos, donde podran elegir entre 5 barcos a jugar, ¡Recuerden la cantidad de barcos elegida!");
        System.out.println("4to paso: Ya es hora de que cada jugador posiciene sus barcos, se mostrara el tablero por pantalla con sus respectivas referencias ('M' de mar e 'I' de isla, las demas letras seran la inicial de su respectivo barco). debera colocar el barco en un espacio de Mar('M') y no se podra colocar sobre islas, o pegados a otros barcos.");
        System.out.println("5to paso: Empezara el juego, se mostraran dos opciones, mostrar tu tablero, o atacar, si quieres ver tu tablero selecciona la primera opcion, luego de esto atacaras en 5 seg, o puedes saltar directo a la accion con la segunda opcion.");
        System.out.println("6to paso: Cuando haya comenzado el ataque se mostrara el tablero rival por pantalla, deberas seleccionar una posicion en este para realizar un ataque, si has dado un objetivo, se marcara con una 'X' y te tocara otra vez, si fallaste el ataque, se marcara con un 'O', y pasara el turno");
        System.out.println("7to paso: Se repetira el 5to y 6to paso, hasta que uno de los jugadores se quede sin barcos, si el segundo jugador se quedo sin barcos, y al primer jugador le queda unicamente una posicion, este tendra la oportunidad de buscar el empate en un ultimo intento. Si ambos jugadores llegan a la cantidad de intentos asignados, se decidira por el jugador con la mayor cantidad de aciertos.");
        System.out.println("¡Disfruten el juego!");
    }
    
        

    }
