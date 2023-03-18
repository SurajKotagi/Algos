import java.util.*;
import java.io.*;

public class a5_quick_sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivot_index = giv_piv(arr, l, h);
            quickSort(arr, l, pivot_index - 1);
            quickSort(arr, pivot_index + 1, h);
        }
    }

    public static int giv_piv(int[] arr, int l, int h) {
        int i = l;
        int j = h;
        int pivot = arr[l];
        while (i < j) {
            while (i <= h && arr[i] <= pivot) {
                i++;
            }
            while (j >= 0 && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        return j;
    }
}