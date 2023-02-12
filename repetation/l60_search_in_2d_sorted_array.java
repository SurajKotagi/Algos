import java.util.*;
import java.io.*;

public class l60_search_in_2d_sorted_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
        int tar = scn.nextInt();

        // for (int i = 0; i < n; i++) {
        // int x = binarySearch(mat, tar, i);
        // // System.out.println(x);
        // if (x != -1) {
        // System.out.println(i);
        // System.out.println(x);
        // return;
        // }
        // }
        // System.out.println("Not Found");

        // method 2
        int i = 0;
        int j = mat[0].length - 1;
        while (i < mat.length && j >= 0) {
            if (mat[i][j] == tar) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if (tar < mat[i][j]) {
                j--;
            } else if (tar > mat[i][j]) {
                i++;
            }
        }
        System.out.println("Not Found");
    }

    public static int binarySearch(int[][] arr, int tar, int i) {
        int s = 0;
        int e = arr[0].length - 1;

        while (s < e) {
            int m = (s + e) / 2;
            if (arr[i][m] == tar) {
                return m;
            } else if (tar < arr[i][m]) {
                e = m - 1;
            } else if (tar > arr[i][m]) {
                s = m + 1;
            }
        }
        return -1;
    }
}