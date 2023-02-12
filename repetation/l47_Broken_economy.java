import java.util.*;
import java.io.*;

public class l47_Broken_economy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();

        // method 1

        // for (int i = 0; i < n; i++) {
        // if (arr[i] == d) {
        // System.out.println(arr[i]);
        // return;
        // } else if (arr[i] > d) {
        // System.out.println(arr[i]);
        // System.out.println(arr[i - 1]);
        // return;
        // }
        // }

        // method 2 (binary search)

        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (d == arr[m]) {
                System.out.println(d);
                return;
            } else if (d < arr[m]) {
                e = m - 1;
            } else if (d > arr[m]) {
                s = m + 1;
            }
        }
        System.out.println(arr[s]);
        System.out.println(arr[e]);
    }
}