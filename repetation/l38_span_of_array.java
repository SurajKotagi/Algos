import java.util.*;
import java.io.*;

public class l38_span_of_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // int val = scn.nextInt();
        // max = Math.max(max, val);
        // min = Math.min(min, val);
        // }
        // System.out.println(max - min);

        // method 2

        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scn.nextInt();
        // }
        // Arrays.sort(arr);
        // System.out.println(arr[n - 1] - arr[0]);

        // method 3

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }
        }
        System.out.println(arr[n - 1] - arr[0]);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}