import java.util.*;
import java.io.*;

public class l79_all_indices_of_array {
    // method 1

    // static int[] res = new int[0];

    // public static int[] rec(int[] arr, int i, int tar, int c) {
    // if (i == arr.length) {
    // res = new int[c];
    // // System.out.println(res.length);
    // return res;
    // }

    // if (arr[i] == tar) {
    // rec(arr, i + 1, tar, c + 1);
    // } else {
    // rec(arr, i + 1, tar, c);
    // }

    // if (arr[i] == tar) {
    // res[c] = i;
    // }

    // return res;
    // }

    // method 2
    public static int[] rec(int[] arr, int i, int tar, int c) {
        if (i == arr.length) {
            int[] res = new int[c];
            return res;
        }

        if (arr[i] == tar) {
            int[] narr = rec(arr, i + 1, tar, c + 1);
            narr[c] = i;
            return narr;
        } else {
            int[] narr = rec(arr, i + 1, tar, c);
            return narr;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        int[] ans = rec(arr, 0, tar, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}