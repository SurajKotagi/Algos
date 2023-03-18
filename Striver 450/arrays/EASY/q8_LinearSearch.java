import java.util.*;
import java.io.*;

public class q8_LinearSearch {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int K = scn.nextInt();
        System.out.print(Optimal_LS(arr, K));
    }

    public static int Brute_LS(int[] arr, int K) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == K)
                return 1;
        }
        return -1;
    }

    public static int Optimal_LS(int[] arr, int K) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = e + (s - e) / 2;
            if (arr[m] < K) {
                s = m + 1;
            } else if (arr[m] > K) {
                e = m - 1;
            } else {
                return 1;
            }
        }
        return -1;
    }
}