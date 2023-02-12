import java.util.*;
import java.io.*;

public class l77_first_index {
    public static void rec(int[] arr, int i, int tar) {
        if (i == arr.length) {
            System.out.println(-1);
            return;
        }
        if (arr[i] == tar) {
            System.out.println(i);
            return;
        } else {
            rec(arr, i + 1, tar);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int tar = scn.nextInt();
        rec(arr, 0, tar);
    }
}