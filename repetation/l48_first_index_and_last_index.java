import java.util.*;
import java.io.*;

public class l48_first_index_and_last_index {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        // method 1

        // for (int i = 0; i < n; i++) {
        // if (arr[i] == tar) {
        // System.out.println(i);
        // break;
        // }
        // }
        // for (int i = n - 1; i >= 0; i--) {
        // if (arr[i] == tar) {
        // System.out.println(i);
        // return;
        // }
        // }
        // System.out.println(-1);
        // System.out.println(-1);

        // method 2 (binary search)

        int s = 0;
        int e = n - 1;
        int ans = 0;
        int flag = 0;
        while (s <= e) {
            int m = (s + e) / 2;
            if (tar == arr[m]) {
                ans = m;
                flag = 1;
                break;
            } else if (tar > arr[m]) {
                s = m + 1;
            } else if (tar < arr[m]) {
                e = m - 1;
            }
        }
        if (flag != 1) {
            System.out.println(-1);
            System.out.println(-1);
            return;
        }

        int l = ans;
        int r = ans;

        while (l != 0 && arr[l - 1] == arr[l]) {
            l--;
        }
        System.out.println(l);

        while (r != n - 1 && arr[r + 1] == arr[r]) {
            r++;
        }
        System.out.println(r);
    }
}