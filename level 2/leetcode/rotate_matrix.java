import java.util.*;
import java.io.*;

public class rotate_matrix {
    public static void main(String[] args) {
        // 1 2 3
        // 4 5 6
        // 7 8 9
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int n = arr.length;
        for (int g = 0; g < n; g++) {
            for (int i = g, j = 0; i >= 0; i--, j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][n - 1 - i];
                arr[n - 1 - j][n - 1 - i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}