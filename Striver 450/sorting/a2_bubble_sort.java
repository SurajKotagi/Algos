import java.util.*;
import java.io.*;

public class a2_bubble_sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        bubble_sort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubble_sort(int[] arr, int n) {
        // push maximum to the last by adjecent swapping
        for (int i = n - 2; i >= 0; i--) {
            // optimization
            boolean swapped = false;
            for (int j = 0; j <= i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                if (swapped == false) {
                    break;
                }
            }
        }

    }
}