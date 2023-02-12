import java.io.*;
import java.util.*;

public class l135_radix_sort {

    public static void radixSort(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        int exp = 1;
        while (exp < max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here
        int[] f = new int[10];
        for (int i = 0; i < arr.length; i++) {
            f[arr[i] / exp % 10]++;
        }
        f[0] -= 1;
        for (int i = 1; i < 10; i++) {
            f[i] += f[i - 1];
        }

        int[] na = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            na[f[arr[i] / exp % 10]] = arr[i];
            f[arr[i] / exp % 10]--;
        }
        for (int i = 0; i < na.length; i++) {
            arr[i] = na[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}