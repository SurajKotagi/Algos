import java.io.*;
import java.util.*;

public class l136_sort_dates {

    public static void sortDates(String[] arr) {
        // write your code here
        countSort(arr, 1000000, 100, 32);
        countSort(arr, 10000, 100, 13);
        countSort(arr, 1, 10000, 2501);
    }

    public static void countSort(String[] arr, int div, int mod, int range) {
        // write your code here
        int[] f = new int[range];
        for (String x : arr) {
            f[Integer.parseInt(x, 10) / div % mod]++;
        }
        f[0]--;
        for (int i = 1; i < f.length; i++) {
            f[i] += f[i - 1];
        }
        String[] na = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            na[f[Integer.parseInt(arr[i], 10) / div % mod]] = arr[i];
            f[Integer.parseInt(arr[i], 10) / div % mod]--;
        }
        for (int i = 0; i < na.length; i++) {
            arr[i] = na[i];
        }
    }

    public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = scn.next();
            arr[i] = str;
        }
        sortDates(arr);
        print(arr);
    }

}