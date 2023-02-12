import java.util.*;
import java.io.*;

public class l113_paint_house {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dpi = new int[n][3];
        int[][] dpx = new int[n][3];

        dpi[0][0] = 0;
        dpi[0][1] = 1;
        dpi[0][2] = 2;

        dpx[0][0] = arr[0][0];
        dpx[0][1] = arr[0][1];
        dpx[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < 3; j++) {
                int val = Integer.MAX_VALUE;

                for (int k = 0; k < 3; k++) {
                    if (k != dpi[i - 1][j]) {
                        if (arr[i][k] < val) {
                            val = arr[i][k];
                            dpi[i][j] = k;
                            dpx[i][j] = dpx[i - 1][j] + val;
                        }
                    }
                }
            }
        }
        System.out.println(Math.min(dpx[n - 1][0], Math.min(dpx[n - 1][1], dpx[n - 1][2])));
    }
}