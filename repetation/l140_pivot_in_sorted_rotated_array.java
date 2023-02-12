import java.io.*;
import java.util.*;

public class l140_pivot_in_sorted_rotated_array {

    public static int findPivot(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (arr[h] < arr[m]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return arr[l];
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(findPivot(arr));
    }
}