import java.util.*;
import java.io.*;

public class l93_target_sum_subset {

    // sos - sum of subset
    public static void rec(int[] arr, int idx, String psf, int sos, int tar) {

        if (idx == arr.length && sos == tar) {
            System.out.println(psf + ".");
            return;
        } else if (idx == arr.length || sos > tar) {
            return;
        }

        rec(arr, idx + 1, psf + arr[idx] + ", ", sos + arr[idx], tar);
        rec(arr, idx + 1, psf, sos, tar);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        rec(arr, 0, "", 0, tar);
    }
}