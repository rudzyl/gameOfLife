
package gameoflife;


public class GameOfLife {
    
    public static void main(String[] args) {
        //pirmas lygis
        char [][] field = new char[50][50];
        for (int i=0;i<field.length;i++) {
            for(int j =0; j<field[i].length; j++) {
                if(Math.random() > 0.22) {
                    field[i][j] = 'X';
                }else {
                    field[i][j]='O';
                }
            }
        }
    }
    
}
