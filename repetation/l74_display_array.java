import java.util.*;
import java.io.*;

public class l74_display_array {
    public static void rec(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }

        System.out.println(arr[i]);
        rec(arr, i + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        rec(arr, 0);
    }
}