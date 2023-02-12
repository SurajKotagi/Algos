import java.util.*;
import java.io.*;

public class l76_max_of_an_array {
    public static void rec(int[] arr, int max, int i) {
        if (i == arr.length) {
            System.out.println(max);
            return;
        }

        if (arr[i] > max) {
            max = arr[i];
        }

        rec(arr, max, i + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int max = Integer.MIN_VALUE;
        rec(arr, max, 0);
    }
}