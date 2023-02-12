import java.util.*;
import java.io.*;

public class l59_saddle_point {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        // for (int j = 0; j < n; j++) {
        // for (int i = 1; i < n; i++) {
        // if (mat[i - 1][j] > mat[i][j]) {
        // mat[i][j] = mat[i - 1][j];
        // }
        // }
        // }

        // for (int j = n - 2; j >= 0; j--) {
        // if (mat[n - 1][j + 1] < mat[n - 1][j]) {
        // mat[n - 1][j] = mat[n - 1][j + 1];
        // }
        // }

        // System.out.println(mat[n - 1][0]);

        for (int j = 0; j < n; j++) {

            int[][] temp = mat;
            int maxi = 0;
            for (int i = 1; i < n; i++) {
                if (temp[i][j] > temp[i - 1][j]) {
                    maxi = i;
                } else {
                    temp[i][j] = temp[i - 1][j];
                    maxi = i - 1;
                }
            }

            temp = mat;

            int minj = n - 1;
            for (int k = n - 2; k >= 0; k--) {
                if (temp[maxi][k + 1] < temp[maxi][k]) {
                    minj = k + 1;
                    temp[maxi][k] = temp[maxi][k + 1];
                } else {
                    minj = k;
                }
            }

            if (j == minj) {
                System.out.println(mat[maxi][minj]);
                return;
            }
        }
        System.out.println("Invalid input");

        // 11 12 13 14
        // 21 22 23 24
        // 31 32 33 34
        // 41 42 43 44
    }
}