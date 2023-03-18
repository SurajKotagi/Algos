import java.util.*;
import java.io.*;

public class q13_LongestSubarrayWithGivenSumPositive {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 2, 3, 1, 1 };
        int k = 3;
        System.out.println(Brute(arr, k));
        System.out.println(Better(arr, k));
        System.out.println(Best(arr, k));
    }

    // Brute | TC - O(n³) | SC - O(1)
    public static int Brute(int[] arr, int k) {
        // find all sub arrays
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // every i to j is one subarray
                // calculate subarray sum
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Better | TC - O(n²) | SC - O(1)
    public static int Better(int[] arr, int k) {
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int Best(int[] arr, int k) {
        // only for positive
        int left = 0;
        int i = 0;
        int maxLen = 0;
        int sum = 0;
        int n = arr.length;
        while (i < n) {
            sum += arr[i];
            while (left <= i && sum > k) {
                sum -= arr[left++];
            }
            if (sum == k) {
                maxLen = Math.max(i - left + 1, maxLen);
            }
            i++;
        }
        return maxLen;
    }
}