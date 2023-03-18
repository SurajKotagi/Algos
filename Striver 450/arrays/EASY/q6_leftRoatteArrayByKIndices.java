import java.util.*;
import java.io.*;

public class q6_leftRoatteArrayByKIndices {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        // Brute_reverseK(arr, k);
        // Optimised_reverseK(arr, k);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Brute_reverseK(int[] arr, int k) {
        List<Integer> arrL = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrL.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = arrL.get(i - (arr.length - k));
        }
    }

    public static void Optimised_reverseK(int[] arr, int k) {
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}