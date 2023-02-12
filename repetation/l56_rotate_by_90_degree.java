import java.util.*;
import java.io.*;

public class l56_rotate_by_90_degree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int k = n;
        for (int i = 0; i < n; i++) {
            for (int j = k - 1; j >= 0; j--) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - j - 1][n - i - 1];
                arr[n - j - 1][n - i - 1] = temp;
            }
            k--;
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - i - 1][j];
                arr[n - i - 1][j] = temp;
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