import java.util.Scanner;


public abstract class Fichas{
    
    private char identificador;
    private int tamaño;

    
    public Fichas(int t, char id){
        this.tamaño = t;
        this.identificador =  id;
    }

    public int getTamaño(){
        return this.tamaño;
    }

    public char getId(){
        return this.identificador;
    }

    public void disminuirTamaño(){
        this.tamaño--;
    }

    public int verificarMapa(Coordenadas position, Jugador jug1,Fichas pieza){
        int option = 0;
        int t = jug1.deffenseBoard.getTamaño();
        int h = pieza.getTamaño(), equis = position.getX(), ye = position.getY();
        if (pieza.getId()=='M'){
          for(int i=equis-1;i<=equis+1;i++){
            for(int j=ye-1;i<=ye+1;j++){
              if (i<t && j<t && i>0 && j>0){
                if (jug1.deffenseBoard.board[i][j].getId()!='M'){
                  return 0;
                }
              }
            }
            
          }
        }
        else{
          Scanner scanner = new Scanner(System.in);
          
          do {
              System.out.println("Opciones para colacar su barco: \n1. Vertical Hacia Arriba\n2. Vertical Hacia abajo\n3. Hacia la derecha\n4. Hacia la izquierda");
              option = scanner.nextInt();
              switch (option) {
                  case 1:
                      if (equis-h<0){
                        return 0;
                      } else{
                        for(int i=equis-h;i<=equis+1;i++){
                          for (int j=ye-1;j<=ye+1;j++){
                            if (i<t && j<t && i>0 && j>0){
                              if (jug1.deffenseBoard.board[i][j].getId()!='M'){
                                return 0;
                              }
                            }
                          }
                        }
                      }
                      break;
                  case 2:
                      if (equis+h>t){
                        return 0;
                      }else{
                        for (int i=equis-1;i<=equis+h;i++){
                          for (int j=ye-1;j<=ye+1;j++){
                            if (i<t && j<t && i>0 && j>0){
                              if (jug1.deffenseBoard.board[i][j].getId()!='M'){
                                return 0;
                              }
                            }
                          }
                        }
                        
                      }
                  
                      break;
                  case 3:
                      if (ye+h>t){
                        return 0;
                      }else{
                        for(int i=equis-1;i<=equis+1;i++){
                          for(int j=ye-1;j<=ye+h;j++){
                            if (i<t && j<t && i>0 && j>0){
                              if (jug1.deffenseBoard.board[i][j].getId()!='M'){
                                return 0;
                              }
                            }
                          }
                        }
                      }
                      break;
                  case 4:
                      if (ye-h<0){
                        return 0;
                      }else{
                        for(int i=equis-1;i<=equis+1;i++){
                          for(int j=ye-h;i<=ye+1;j++){
                            if (i<t && j<t && i>0 && j>0){
                              if (jug1.deffenseBoard.board[i][j].getId()!='M'){
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
          } while (option< 1 || option > 4);
        }
        return option;

    }

}