import java.util.*;
import java.io.*;

public class l53_State_of_wakanda {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] mat = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < c; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < r; j++) {
                    System.out.println(mat[j][i]);
                }
            } else {
                for (int j = r - 1; j >= 0; j--) {
                    System.out.println(mat[j][i]);
                }
            }

        }
    }
}