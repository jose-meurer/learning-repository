import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Vetor
        double[] vect = new double[3];

        for (int i = 0; i < vect.length; i++) {
            vect[i] = i + 1;
        }

        for (int i = 0; i < vect.length; i++) {
            System.out.println(vect[i]);
        }

        System.out.println();

        //Matrizes
        int[][] matriz = new int[4][4];
        for (int i =0; i < matriz.length; i++){
            for (int j = 0; j<matriz[i].length; j++) {
                matriz[i][j] = i + j;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //Listas
        List<String> list = new ArrayList<>();
        list.add("José");
        list.add("João");
        list.add("Maria");
        System.out.println(list);
        list.remove("João");
        list.removeIf(name -> name.charAt(0) == 'J');
        System.out.println(list);
    }
}