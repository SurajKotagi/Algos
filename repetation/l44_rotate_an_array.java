import java.util.*;
import java.io.*;

public class l44_rotate_an_array {
    public static int[] rotate(int[] arr, int k) {
        int[] narr = new int[arr.length];
        if (k < 0) {
            narr[narr.length - 1] = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                narr[i] = arr[i + 1];
            }
        } else if (k > 0) {
            narr[0] = arr[arr.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                narr[i + 1] = arr[i];
            }
        }
        return narr;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        k %= n;
        while (k != 0) {
            arr = rotate(arr, k);
            if (k > 0) {
                k--;
            } else if (k < 0) {
                k++;
            }
        }
        for (int val : arr) {
            System.out.print(val + " ");
        }

    }
}