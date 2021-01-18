
package gameoflife;

public class GameOfLife {
    
    public static void main(String[] args) {
        //pirmas lygis
        char [][] field = {
            {'.','X','.','X'},
            {'.','.','X','.'},
            {'.','X','X','.'},
            {'.','.','.','.'} 
        };
        
        for (int i = 0;i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println("-------------------");
        //3 lygis trimatis
        char[][][] history = new char[50][field.length][field[0].length];
        //naujos iteracijos kurimas
        for(int c=0; c < 50;c++) {
            //3matis
            history[c] = field;
            //2matis 1 lygis
            char[][] newField = new char[field.length][field[0].length];
            //pereinamas senas laukas ir tikrinamas kiekviena pozicija
            //per visas eilutes
            for(int i = 0; i <newField.length; i++) {
                //per visus stulpelius
                for(int j = 0; j <newField[i].length; j++) {
                    int n = 0;
                    if(i > 0) {
                        //jei true sklausteliuose pridedam 1 jei ne 0 patikrintos pozicijos is virsaus
                        n += (j > 0 && field[i - 1][j - 1] == 'X') ? 1 : 0;
                        n += (field[i - 1][j] == 'X') ? 1 : 0;
                        n += (j < field[i].length - 1 && field[i - 1][j + 1] == 'X') ? 1 : 0; 
                    }
                    //tikrinama is kaires ir is desines
                    n += (j > 0 && field[i][j - 1] == 'X') ? 1 : 0;
                    n += (j < field[i].length - 1 && field[i][j + 1] == 'X') ? 1 : 0;
                    //tikrinamos eilutes apatines, bet salyga pasidarys false kai bus tikrinama paskutine eilute
                    if(i < field.length-1) {
                        n += (j > 0 && field[i + 1][j - 1] == 'X') ? 1 : 0;
                        n += (field[i + 1][j] == 'X') ? 1 : 0;
                        n += (j < field[i].length - 1 && field[i + 1][j + 1] == 'X') ? 1 : 0;
                    }
                    if(field[i][j] == 'X') {
                        if(n == 2 || n == 3) {
                            newField[i][j] = 'X';
                        } else {
                            newField[i][j] = '.';
                        }
                    } else {
                        if(n == 3) {
                            newField[i][j] = 'X';
                        } else {
                            newField[i][j] = '.';
                        }
                    }
                }
            }
            //3matis tikrinimas
            //tikrinama nuo pabaigos
            int h;
            for(h = c; h >=0; h--) {
               char[][]f = history[h];
               boolean match = true;
                for(int i = 0; match && i < f.length; i++) {
                   for(int j = 0; match && j < f[i].length; j++) {
                       if(f[i][j] != newField[i][j]) {
                           match = false;
                       }
                    }
                }
                if(match) {
                 break;   
                }
            }
            //ar laukai sutampa? jei sutampa nutraukiamas ciklas su break // 2 lygis
//            boolean match = true;
//            for(int i = 0; match && i < field.length; i++) {
//               for(int j = 0; match && j < field[i].length; j++) {
//                   if(field[i][j] != newField[i][j]) {
//                       match = false;
//                   }
//               }
//            }
//            if(match) {
//               break;
//            }
            if (h >= 0) {
                System.out.println("Iteration " + (c + 1) + " same as " + h);
                break;
            }
            field = newField;
            for (int i = 0;i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println((c + 1) +"-------------------");
        }
    }
}       
    
