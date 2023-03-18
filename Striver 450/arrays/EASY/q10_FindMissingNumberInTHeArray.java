import java.util.*;
import java.io.*;

public class q10_FindMissingNumberInTHeArray {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[] { 1, 2, 3, 4, 6 };
        System.out.println(Brute(arr, n));
        System.out.println(Better(arr, n));
        System.out.println(Optimal(arr, n));
        System.out.println(Optimal2(arr, n));
    }

    // Brute
    // time complexity -> O(n²)
    // space complexity -> O(1)
    public static int Brute(int[] arr, int n) {
        // number range given is 1 to N
        for (int i = 1; i <= n; i++) {
            boolean Ok = false;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] == i) {
                    Ok = true;
                    break;
                }
            }
            if (Ok == false)
                return i;
        }
        return 69;
    }

    // Better
    // time complexity -> O(2n)
    // space complexity -> O(n)
    public static int Better(int[] arr, int n) {
        int[] check = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            check[arr[i]] = 1;
        }
        for (int i = 1; i < check.length; i++) {
            if (check[i] == 0)
                return i;
        }
        return 69;
    }

    // Optimal
    // time complexity -> O(n)
    // space complexity -> O(1)
    public static int Optimal(int[] arr, int n) {
        int sumTN = n * (n + 1) / 2;
        int realSum = 0;
        for (int i = 0; i < n - 1; i++) {
            realSum += arr[i];
        }
        return sumTN - realSum;
    }

    // Optimal xor
    // time complexity -> O(n²)
    // space complexity -> O(1)
    public static int Optimal2(int[] arr, int n) {
        int xorTN = 1;
        int realXOR = arr[0];
        for (int i = 1; i < n - 1; i++) {
            realXOR ^= arr[i];
            xorTN ^= (i + 1);
        }
        return realXOR ^ xorTN ^ n;
    }
}