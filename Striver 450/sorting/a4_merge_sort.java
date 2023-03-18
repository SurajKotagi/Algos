import java.util.*;
import java.io.*;

public class a4_merge_sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // time complexity - O(n log n to the base 2)
        // space complexity - O(n)
        merge_sort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge_sort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        merge_sort(arr, l, mid);
        merge_sort(arr, mid + 1, r);
        merge_two_sorted(arr, l, mid, r);
    }

    public static void merge_two_sorted(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        ArrayList<Integer> arrL = new ArrayList<>();
        while (i < m + 1 && j <= r) {
            if (arr[j] < arr[i]) {
                arrL.add(arr[j++]);
            } else {
                arrL.add(arr[i++]);
            }
        }
        while (i < m + 1) {
            arrL.add(arr[i++]);
        }
        while (j <= r) {
            arrL.add(arr[j++]);
        }
        for (int k = l; k <= r; k++) {
            arr[k] = arrL.get(k - l);
        }
    }
}