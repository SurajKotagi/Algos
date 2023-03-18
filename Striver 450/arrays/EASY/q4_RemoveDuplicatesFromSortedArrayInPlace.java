import java.util.*;
import java.io.*;

public class q4_RemoveDuplicatesFromSortedArrayInPlace {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int x = B_removeDuplicates(arr, n);
        for (int i = 0; i < x; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Brute TC -> O(NlogN) + O(n) SC -> O(n)
    public static int B_removeDuplicates(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int i = 0;
        for (int y : set) {
            arr[i++] = y;
        }
        return i;
    }

    // optimal TC -> O(n) SC -> O(1)
    public static int O_removeDuplicates(int[] arr, int n) {
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                arr[++i] = arr[j];
            }
        }
        return i + 1;
    }
}
