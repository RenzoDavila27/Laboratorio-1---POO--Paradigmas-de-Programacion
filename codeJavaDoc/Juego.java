import java.util.Scanner;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
/**
* La clase Juego se encargara de llevar el control, es la clase main
* @version 17.0.12 16/09/24
* @author Renzo Davila, Facundo Lella
*/
    
public class Juego {
    /**
     * El main es donde se ira avanzando en el juego
     * @param args
     * @throws InterruptedException
     * @see Jugador
     * @see HUB
     * @see ingresarHub
     * @see inicializarBarcos
     * @see posicionarBarcos
     * @see getCantBarcos
     * @see getAciertos
     * @see getName
     * @see mostrarTablero
     * @see ataque
     * @see verificarGanador
     */
    public static void main(String[] args) throws InterruptedException {
        int tamanio = 0, cantIntentos = 0, cantBarcos = 0, cantIslas = 0, option = 0, numTurno = 1, metodoDeJuego = 0;
        HUB start = new HUB();
        boolean seguirJugando = true;
        start.ingresarHub();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del jugador 1: ");
        String name1 = scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 2: ");
        String name2 = scanner.nextLine();
        System.out.println("Hola jugador " + name1 + " y " + name2);
        System.out.println("Opciones de tablero:\n1. 12x12 - 7 barcos - 5 isla - 100 intentos\n2. 10x10 - 5 barcos - 4 islas - 70 intentos\n3. 7x7 - 3 barcos - 3 islas - 32 intentos");
        do {
            try{
                metodoDeJuego = scanner.nextInt();
            }catch(InputMismatchException e){
                scanner.next();
            }
            switch (metodoDeJuego) {
                case 1:
                    tamanio = 12;
                    cantBarcos = 7;
                    cantIntentos = 140; // 70 para cada jugador
                    cantIslas = 5;
                    break;
                case 2:
                    tamanio = 10;
                    cantBarcos = 5;
                    cantIntentos = 140; // 70 para cada jugador
                    cantIslas = 4;
                    break;
                case 3:
                    tamanio = 7;
                    cantBarcos = 3;
                    cantIntentos = 64; // 32 para cada jugador
                    cantIslas = 3;
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (metodoDeJuego > 3 || metodoDeJuego < 1);

        Jugador jug1 = new Jugador(name1, tamanio, cantBarcos);
        Jugador jug2 = new Jugador(name2, tamanio, cantBarcos);

        generarIslas(jug1, jug2, cantIslas);
        String[] barcos = seleccionDeBarcos(cantBarcos);
        jug1.inicializarBarcos(barcos);
        jug2.inicializarBarcos(barcos);
        posicionarBarcos(barcos, tamanio-1, jug1, jug2);

        Jugador jActual = jug1, jEnemigo = jug2;
        System.out.println("----------\n¡Comienza el juego!");

        while (numTurno <= cantIntentos && seguirJugando){
            
            if (jug1.getCantBarcos() == 0 && jug2.getAciertos()-1 == jug1.getAciertos()){
                System.out.println("-----\nUltima oportunidad de " + jug1.getName());
                seguirJugando = false;
                jActual = jug1;
                jEnemigo = jug2;
            }else if (jug2.getCantBarcos() == 0 && jug1.getAciertos()-1 == jug2.getAciertos()){
                System.out.println("-----\nUltima oportunidad de " + jug2.getName());
                seguirJugando = false;
                jActual = jug2;
                jEnemigo = jug1;
            }else if (jug1.getCantBarcos()==0 || jug2.getCantBarcos()==0){
                break;
            }else{
                System.out.println("----------\nTurno de " + jActual.getName());
            }

            System.out.println("Ingrese la accion a realizar\n1. Quiero ver mi tablero y barcos\n2. Quiero atacar");

            do{
                try{
                    option = scanner.nextInt();
                }catch(InputMismatchException e){
                    scanner.next();
                }

                switch (option) {
                    case 1:
                    System.out.println("Mi tablero");
                        jActual.deffenseBoard.mostrarTablero();
                        System.out.println("Barcos restantes: ");
                        jActual.mostrarBarcosRestantes();
                        System.out.println("Barcos perdidos: ");
                        jActual.mostrarBarcosEliminados();
                        System.out.println("Atacaras en 5 segundos ");
                        Thread.sleep(5000);
                        break;
                    
                    case 2:
                        break;
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } while (option > 2 || option < 1);

            System.out.println("-----\n¡Es hora de atacar!");
            
            numTurno++;

            if (!ataque(jActual, jEnemigo)){
                Jugador transicion = jActual;
                jActual = jEnemigo;
                jEnemigo = transicion;
            }else{
                if (jEnemigo.getCantBarcos()!=0){
                    System.out.println("¡Tiras nuevamente!");
                }
            }

        }

        verificarGanador(jug1, jug2, numTurno, cantIntentos);
        scanner.close();
    }
    /**
     * Verifica que usuario gano y si por aciertos por naves hundidas o si hay empate
     * @param jug1 Jugador 1
     * @param jug2 Jugador 2
     * @param n Cantidad de disparos limite
     * @param i Cantidad de disparos hechos por los usuarios
     * @see Jugador
     * @see mostrarTablero
     * @see getAciertos
     * @see getName
     * @see getCantBarcos
     */
    public static void verificarGanador(Jugador jug1, Jugador jug2, int n, int i) {


        if (n == i+1){
            System.out.println("¡Se han acabado los disparos!");
            if (jug1.getAciertos() > jug2.getAciertos()){
                System.out.println("El jugador " + jug1.getName() + " ha ganado, ¡Felicidades! ");
                System.out.println("Tablero ganador:");
                jug1.deffenseBoard.mostrarTablero();
                System.out.println("Tablero perdedor:");
                jug2.deffenseBoard.mostrarTablero();
            } else if(jug1.getAciertos() < jug2.getAciertos()){
                System.out.println("El jugador " + jug2.getName() + " ha ganado, ¡Felicidades! ");
                System.out.println("Tablero ganador:");
                jug2.deffenseBoard.mostrarTablero();
                System.out.println("Tablero perdedor:");
                jug1.deffenseBoard.mostrarTablero();
            } else{
                System.out.println("¡Ha habido un empate!, Gracias por jugar");
                System.out.println("Tablero de " + jug1.getName());
                jug1.deffenseBoard.mostrarTablero();
                System.out.println("Tablero de " + jug2.getName());
                jug2.deffenseBoard.mostrarTablero();
            }
        } else{
            if (jug1.getCantBarcos() < jug2.getCantBarcos()){
                System.out.println("El jugador " + jug2.getName() + " ha ganado, ¡Felicidades! ");
                System.out.println("Tablero ganador:");
                jug2.deffenseBoard.mostrarTablero();
                System.out.println("Tablero perdedor:");
                jug1.deffenseBoard.mostrarTablero();
            } else if (jug1.getCantBarcos()==jug2.getCantBarcos()) {

                System.out.println("¡Ha habido un empate!, Gracias por jugar");
                System.out.println("Tablero de " + jug1.getName());
                jug1.deffenseBoard.mostrarTablero();
                System.out.println("Tablero de " + jug2.getName());
                jug2.deffenseBoard.mostrarTablero();
                
            }else{
                System.out.println("El jugador " + jug1.getName() + " ha ganado, ¡Felicidades! ");
                System.out.println("Tablero ganador:");
                jug1.deffenseBoard.mostrarTablero();
                System.out.println("Tablero perdedor:");
                jug2.deffenseBoard.mostrarTablero();
            }
        }
    }
    /**
     * Le da la opcion al jugador de donde atacar y le dice si ha dado a un navio, isla o mar.
     * @param jTirador Jugador quien efectua el disparo
     * @param jEnemigo Jugador que esta siendo atacado
     * @see Jugador
     * @see mostrarTablero
     * @see aumentarAciertos
     * @see disminuirTamanio
     * @see getBoard
     * @see getTamanio
     * @see getId
     * @see setId
     * @see disminuirCantBarcos
     * @see eliminarBarco
     * @see InterruptedException
     * @return Si le pego a un barco enemigo devuelve True y False si falla
     */
    public static boolean ataque(Jugador jTirador, Jugador jEnemigo){

        int fila = -1, columna = -1, tamanio = jTirador.deffenseBoard.getTamanio();
        char lugar;
        boolean bool = false;
        
        Scanner scanner1 = new Scanner(System.in);
        

        System.out.println("-----\nTablero enemigo: ");
        jEnemigo.attackBoard.mostrarTablero();

        do{

            do{
                System.out.println("-----\nIngrese la fila donde quiere disparar");
                try{
                    fila = scanner1.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("¡Debe ingresar una posicion del tablero!");
                    scanner1.next();
                }
            } while (fila >= tamanio || fila < 0);

            do{
                System.out.println("-----\nIngrese la columna donde quiere disparar");
                try{
                    columna = scanner1.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("¡Debe ingresar una posicion del tablero!");
                    scanner1.next();
                }
                
            } while (columna >= tamanio || columna < 0);

            lugar = jEnemigo.attackBoard.getBoard()[fila][columna];
            if (lugar == 'X' || lugar == 'O' || lugar == 'I'){
                System.out.println("¡Ya se disparo a este lugar!, intentelo de nuevo");
                continue;
            }else{
                bool = true;
            }

        } while (bool == false);

        Fichas fichaAlcanzada = jEnemigo.deffenseBoard.getBoard()[fila][columna];


        if (fichaAlcanzada.getId() == 'M'){
            jEnemigo.attackBoard.getBoard()[fila][columna] = 'O';
            fichaAlcanzada.setId('O');
            System.out.println("¡Agua!, has fallado :(");
        }else if(fichaAlcanzada.getId() == 'I'){
            jEnemigo.attackBoard.getBoard()[fila][columna] = 'I';
            jEnemigo.deffenseBoard.getBoard()[fila][columna] = new Restos('O');
            System.out.println("¡Fallaste!, diste en una isla");
            //Posible implementacion de alguna mecanica con las islas
        }else{

            if (fichaAlcanzada.getTamanio() > 1){
                fichaAlcanzada.disminuirTamanio();
                jEnemigo.deffenseBoard.getBoard()[fila][columna] = new Restos('X');
                jEnemigo.attackBoard.getBoard()[fila][columna] = 'X';
                System.out.println("¡Diste en un objetivo!");
            }else{
                jEnemigo.attackBoard.getBoard()[fila][columna] = 'X';
                switch (fichaAlcanzada.getId()) {
                    case 'L':
                        jEnemigo.eliminarBarco("Lancha");
                        break;
                    case 'P': 
                        jEnemigo.eliminarBarco("Portaaviones");
                        break;
                    case 'B':
                        jEnemigo.eliminarBarco("Buque");
                        break;                    
                    case 'S':
                        jEnemigo.eliminarBarco("Submarino");
                        break;
                    case 'C':
                        jEnemigo.eliminarBarco("Crucero");
                        break;
                }

                fichaAlcanzada.setId('X');
                jEnemigo.disminuirCantBarcos();
                System.out.println("¡Hundiste una embarcacion!");
                
            }
            jTirador.aumentarAciertos();
            jEnemigo.attackBoard.mostrarTablero();
            return true;

        }

        jEnemigo.attackBoard.mostrarTablero();
        return false;
        
    }
    /**
     * El usuario seleccionara los barcos que va a utilizar en partida Portaaviones, Lancha, Crucero, Submarino, Buque
     * @param cantShips Cantidad de barcos que van a usar
     * @see InterruptedException
     * @return Un array con los barcos a usar en la partida
     */
    public static String[] seleccionDeBarcos(int cantShips) {
        Scanner scanner2 = new Scanner(System.in);
        String[] barcos = new String[cantShips];
        int option = 0;
        System.out.println("----------\n¡Momento de ingresar los barcos a jugar!\n-----");

        for (int i = 0; i < cantShips; i++) {
            
            do {
                System.out.println("Ingrese el barco numero " + (i+1) + " que se va a jugar\n1.Lancha (Tamanio 1)\n2.Crucero (Tamanio 2)\n3.Submarino (Tamanio 3)\n4.Buque (Tamanio 4)\n5.Portaaviones (Tamanio 5)");
                try{
                    option = scanner2.nextInt();
                }catch(InputMismatchException e){
                    scanner2.next();
                }
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
                    default:
                        System.out.println("Opcion invalida");
                }
            } while (option < 1 || option > 5);
            option = 0;
        }

        return barcos;
    }
    /**
     * Permite que el usuario coloque todos los barcos en la posicion que elija tanto el jugador 1 como jugador 2
     * @param barcos Array de los barcos elegidos
     * @param tamanio tamanio del tablero
     * @param j Jugador 1
     * @param j2 Jugador 2
     * @see MostrarTablero
     * @see verificarMapa
     * @see colocar
     * @throws InterruptedException
     * 
     */
    public static void posicionarBarcos(String[] barcos,int tamanio, Jugador j, Jugador j2) throws InterruptedException {
        Posicion positionTry;
        Scanner scanner3 = new Scanner(System.in);
        int fila = -1, columna = -1, o = 0;
        Jugador jActual = j;
        for (int i=0; i<=1; i++){

            System.out.println("Turno de " + jActual.getName());

            for (String barco: barcos){
                
                do{
                    System.out.println("-------------------");
                    jActual.deffenseBoard.mostrarTablero();

                    System.out.println("-----\nIngrese la fila donde desea colocar: " + barco);
                    do {
                        try{
                            fila = scanner3.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("¡Debe ingresar una posicion del tablero!");
                            scanner3.next();
                        }
                    } while (fila > tamanio || fila < 0);
    
                    System.out.println("-----\nIngrese la columna donde desea colocar: " + barco);
                    do {
                        try{
                            columna = scanner3.nextInt();
                        }catch(InputMismatchException e){
                            System.out.println("¡Debe ingresar una posicion del tablero!");
                            scanner3.next();
                        }
                    } while (columna > tamanio || columna < 0);

                    positionTry = new Posicion(fila,columna);
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

                    o = jActual.deffenseBoard.verificarMapa(positionTry, ficha);
                    
                    if (o == 0){
                        System.out.println("-----\nPosicion no valida, intente de nuevo\n-----");
                        Thread.sleep(1500);
                        continue;
                    } else{
                        System.out.println("-----\nEl barco se coloco correctamente\n-----");
                        Thread.sleep(1500);
                        ficha.colocar(jActual, positionTry, o);
                    }
                    
                } while (o == 0);
                fila = -1;
                columna = -1;
                Thread.sleep(1000);
            }

            System.out.println("Tablero resultante:");
            jActual.deffenseBoard.mostrarTablero();
            if (jActual == j){
                System.out.println("Presione Enter para colocar barcos del jugador 2"); 
                try {
                    System.in.read();
                } catch (IOException e) {}
            }

            jActual = j2;
        }

        System.out.println("Presione Enter para empezar el juego"); 
        
        try {
            System.in.read();
        } catch (IOException e) {}
    }
    /**
     * Generara Islas aleatoriamente y las colocara en los tableros de jug1 y jug2
     * @param j1 Jugador 1
     * @param j2 Jugador 2
     * @see Jugador
     * @see Isla1x2
     * @see Isla2x2
     * @see IslaL
     * @see getTamanio
     * @see colocar
     * @see Posicion
     * @throws InterruptedException
     * @param cantIslas Cantidad de islas a generar
     */
    public static void generarIslas(Jugador j1, Jugador j2, int cantIslas){

        Random rnd = new Random(); 
        Posicion position;
        int fila, columna;
        int tamanio = j1.deffenseBoard.getTamanio();
        Jugador jActual = j1;
        for (int j = 0;j<=1;j++){

            for (int i = 1;i<=cantIslas;i++){
            
                int option = rnd.nextInt(3);

                switch (option) {
                    case 0:
                        Isla1x2 isla1 = new Isla1x2();
                        fila = rnd.nextInt(tamanio-1);
                        columna = rnd.nextInt(tamanio-2);
                        position = new Posicion(fila, columna);
                        isla1.colocar(jActual, position);
                        break;
                    case 1:
                        Isla2x2 isla2 = new Isla2x2();
                        fila = rnd.nextInt(tamanio-2);
                        columna = rnd.nextInt(tamanio-2);
                        position = new Posicion(fila, columna);
                        isla2.colocar(jActual, position);
                        break;
                    case 2:
                        IslaL isla3 = new IslaL();
                        fila = rnd.nextInt(tamanio-3);
                        columna = rnd.nextInt(tamanio-2);
                        position = new Posicion(fila, columna);
                        isla3.colocar(jActual, position);
                        break;
                }
            }

            jActual = j2;
        }

    }
}