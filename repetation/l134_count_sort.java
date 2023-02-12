import java.util.*;
import java.io.*;

public class l134_count_sort {
    public static int[] countSort(int[] arr, int min, int max) {
        int[] f = new int[max - min + 1];
        for (int x : arr) {
            f[x - min]++;
        }
        f[0] -= 1;
        for (int i = 1; i < f.length; i++) {
            f[i] += f[i - 1];
        }

        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[f[arr[i] - min]] = arr[i];
            f[arr[i] - min]--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int[] res = countSort(arr, min, max);
        for (int x : res) {
            System.out.println(x);
        }
    }
}