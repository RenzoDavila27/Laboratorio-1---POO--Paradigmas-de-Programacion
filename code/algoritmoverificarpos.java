
import java.util.Scanner;
public static Boolean verificarMapa(Coordenadas position, Jugador jug1,Fichas pieza){
    int option;
    int t = jug1.deffenserboard.tamaño;
    int h = pieza.tamaño;
    boolean verificado = true;
    if (pieza.identificador=='M'){
      for(int i=position.x-1;i<=position.x+1;i++){
        for(int j=position.y-1;i<=position.y+1;j++){
          if ((i&&j)<t && (i&&j)>0){
            if (jug1.deffenseboard[i][j].identificador!='M'){
              return false;
            }
          }
        }
        
      }
    }
    else{
      Scanner scanner = new Scanner(System.in);
      do {
          System.out.println("Opciones para colacar su barco: /n1. Vertical Hacia Arriba/n2. Vertical Hacia abajo/n3. Hacia la derecha/n4. Hacia la izquierda");
          option = scanner.nextInt();
          switch (option) {
              case 1:
                  if (position.x-h<0){
                    return false;
                  } else{
                    for(int i=position.x-h;i<=position.x+1;i++){
                      for (int j=position.y-1;j<=position.y+1;j++){
                        if ((i&&j)<t && (i&&j)>0){
                          if (jug1.deffenseboard[i][j].identificador!='M'){
                            return false;
                          }
                        }
                      }
                    }
                  }
                  
                  break;
              case 2:
                  if (position.x+h>t){
                    return false;
                  }else{
                    for (int i=position.x-1;i<=position.x+h;i++){
                      for (int j=position.y-1;j<=position.y+1;j++){
                        if ((i&&j)<t && (i&&j)>0){
                          if (jug1.deffenseboard[i][j].identificador!='M'){
                            return false;
                          }
                        }
                      }
                    }
                    
                  }
              
                  break;
              case 3:
                  if (position.y+h>t){
                    return false;
                  }else{
                    for(int i=position.x-1;i<=position.x+1;i++){
                      for(int j=position.y-1;j<=position.y+h;j++){
                        if ((i&&j)<t && (i&&j)>0){
                          if (jug1.deffenseboard[i][j].identificador!='M'){
                            return false;
                          }
                        }
                      }
                    }
                  }
                  break;
              case 4:
                  if (position.y-h<0){
                    return false;
                  }else{
                    for(int i=position.x-1;i<=position.x+1;i++){
                      for(int j=position.y-h;i<=position.y+1;j++){
                        if ((i&&j)<t && (i&&j)>0){
                          if (jug1.deffenseboard[i][j].identificador!='M'){
                            return false;
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
    return verificado;
}