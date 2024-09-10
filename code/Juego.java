import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        int metodoDeJuego;
        int tamaño = 0, cantIntentos = 0, cantBarcos = 0;
        Jugador[] players = new Jugador[2];
        HUB start = new HUB();

        start.ingresarHub();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        String name2 = scanner.nextLine();
        System.out.println("Hola jugador " + name1 + " y " + name2);
        System.out.println(
                "Opciones de tablero:\n1. 10x10 - 5 barcos - 70 intentos\n2. 7x7 - 4 barcos - 32 intentos\n3. 5x5 - 3 barcos - 18 ");
        do {
            metodoDeJuego = scanner.nextInt();
            switch (metodoDeJuego) {
                case 1:
                    tamaño = 10;
                    cantBarcos = 5;
                    cantIntentos = 140; // 70 para cada jugador
                    break;
                case 2:
                    tamaño = 7;
                    cantBarcos = 4;
                    cantIntentos = 64; // 32 para cada jugador
                    break;
                case 3:
                    tamaño = 5;
                    cantBarcos = 3;
                    cantIntentos = 36; // 18 para cada jugador
                    break;
            }
        } while (metodoDeJuego > 3 || metodoDeJuego < 1);

        scanner.close();
        players[0] = new Jugador(name1, tamaño, cantBarcos);
        players[1] = new Jugador(name2, tamaño, cantBarcos);

        String[] barcos = seleccionDeBarcos(cantBarcos);
        posicionarBarcos(barcos, tamaño);

    }

    public static String[] seleccionDeBarcos(int cantShips) {
        Scanner scanner = new Scanner(System.in);
        String[] barcos = new String[cantShips];
        int option = 0;
        for (int i = 0; i < cantShips; i++) {

            do {
                System.out.println("Ingrese el barco Nro " + i
                        + " que se va a jugar\n1.Lancha (Tamaño=1)\n2.Crucero (Tamaño 2)\n3.Submarino (Tamaño 3)\n4.Buque (Tamaño 4)\n5.Portaaviones (Tamaño 5)");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        barcos[i] = "Lancha";
                        break;
                    case 2:
                        barcos[i] = "Crucero";
                        break;
                    case 3:
                        barcos[i] = "Submarino";
                        break;
                    case 4:
                        barcos[i] = "Buque";
                        break;
                    case 5:
                        barcos[i] = "Portaaviones";
                        break;
                }
            } while (option < 1 || option > 5);
        }
        scanner.close();
        return barcos;
    }

    public static void posicionarBarcos(String[] barcos,int tamaño, Jugador[] players) {
        Coordenadas positionTry;
        Scanner scanner = new Scanner(System.in);
        int equis, ye, o = 0;

        for (int i=0; i<=1; i++){

            Jugador j = players[i];

            for (String barco: barcos){

                do{

                    j.deffenseBoard.MostrarTablero();

                    System.out.println("-----\nIngrese la posicion x de: " + barco);
                    do {
                        equis = scanner.nextInt();
                    } while (equis < tamaño || equis > 0);
    
                    System.out.println("-----\nIngrese la posicion y de: " + barco);
                    do {
                        ye = scanner.nextInt();
                    } while (ye < tamaño || ye > 0);

                    positionTry = new Coordenadas(equis,ye);
                    Fichas ficha = new Mar();
                    switch (barco) {
                        
                        case "Lancha":
                            ficha = new Lancha();
                            break;
                        case "Crucero":
                            ficha = new Crucero();
                            break;
                        case "Submarino":
                            ficha = new Submarino();
                            break;
                        case "Buque":
                            ficha = new Buque();
                            break;
                        case "Portaaviones":
                            ficha = new Portaaviones();
                    }

                    
                    o = verificarMapa(positionTry, j, ficha);
                    
                    if (o == 0){
                        System.out.println("-----\nPosicion no valida\n-----");
                        continue;
                    } else{
                        System.out.println("-----\nEl barco se coloco correctamente\n-----");
                        ficha.colocar(j, positionTry, o);
                    }
                    
                } while (o == 0);
            }
        }

    }

    public static int verificarMapa(Coordenadas position, Jugador jug1, Fichas pieza) {
        int option = 0;
        int t = jug1.deffenseBoard.getTamaño();
        int h = pieza.getTamaño(), equis = position.getX(), ye = position.getY();
        if (pieza.getId() == 'M') {
            for (int i = equis - 1; i <= equis + 1; i++) {
                for (int j = ye - 1; i <= ye + 1; j++) {
                    if (i < t && j < t && i > 0 && j > 0) {
                        if (jug1.deffenseBoard.board[i][j].getId() != 'M') {
                            return 0;
                        }
                    }
                }

            }
        } else {
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println(
                        "Opciones para colacar su barco: \n1. Vertical Hacia Arriba\n2. Vertical Hacia abajo\n3. Hacia la derecha\n4. Hacia la izquierda");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        if (equis - h < 0) {
                            return 0;
                        } else {
                            for (int i = equis - h; i <= equis + 1; i++) {
                                for (int j = ye - 1; j <= ye + 1; j++) {
                                    if (i < t && j < t && i > 0 && j > 0) {
                                        if (jug1.deffenseBoard.board[i][j].getId() != 'M') {
                                            return 0;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        if (equis + h > t) {
                            return 0;
                        } else {
                            for (int i = equis - 1; i <= equis + h; i++) {
                                for (int j = ye - 1; j <= ye + 1; j++) {
                                    if (i < t && j < t && i > 0 && j > 0) {
                                        if (jug1.deffenseBoard.board[i][j].getId() != 'M') {
                                            return 0;
                                        }
                                    }
                                }
                            }

                        }

                        break;
                    case 3:
                        if (ye + h > t) {
                            return 0;
                        } else {
                            for (int i = equis - 1; i <= equis + 1; i++) {
                                for (int j = ye - 1; j <= ye + h; j++) {
                                    if (i < t && j < t && i > 0 && j > 0) {
                                        if (jug1.deffenseBoard.board[i][j].getId() != 'M') {
                                            return 0;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        if (ye - h < 0) {
                            return 0;
                        } else {
                            for (int i = equis - 1; i <= equis + 1; i++) {
                                for (int j = ye - h; i <= ye + 1; j++) {
                                    if (i < t && j < t && i > 0 && j > 0) {
                                        if (jug1.deffenseBoard.board[i][j].getId() != 'M') {
                                            return 0;
                                        }
                                    }
                                }
                            }

                        }
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } while (option < 1 || option > 4);
        }
        return option;

    }
}
