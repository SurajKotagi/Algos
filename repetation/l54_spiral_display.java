import java.util.*;
import java.io.*;

public class l54_spiral_display {
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

        int i = 0;
        int j = 0;
        boolean[][] visited = new boolean[r][c];
        while (true) {
            boolean b1 = false, b2 = false, b3 = false, b4 = false;

            while (i < r - 1 && visited[i + 1][j] == false) {
                b2 = true;
                visited[i][j] = true;
                System.out.println(mat[i][j]);

                i++;
            }
            // i--;
            while (j < c - 1 && visited[i][j + 1] == false) {
                b1 = true;
                visited[i][j] = true;
                System.out.println(mat[i][j]);

                j++;
            }
            // j--;
            while (i > 0 && visited[i - 1][j] == false) {
                b4 = true;
                visited[i][j] = true;
                System.out.println(mat[i][j]);

                i--;
            }
            // i++;
            while (j > 0 && visited[i][j - 1] == false) {
                b3 = true;
                visited[i][j] = true;
                System.out.println(mat[i][j]);

                j--;
            }
            // j++;
            if (b1 == false && b2 == false && b3 == false && b4 == false) {
                break;
            }
        }
        System.out.println(mat[i][j]);
    }
}