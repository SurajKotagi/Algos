import java.util.*;
import java.io.*;

public class l39_find_an_element_in_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1 (for un-sorted)

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == tar) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

        // method 2 (for sorted)

        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = scn.nextInt();
        // }
        // int tar = scn.nextInt();
        // Arrays.sort(arr);

        // int s = 0;
        // int e = n - 1;
        // while (s <= e) {
        // int mid = (s + e) / 2;
        // if (tar == arr[mid]) {
        // System.out.println(mid);
        // return;
        // } else if (tar > arr[mid]) {
        // s = mid + 1;
        // } else if (tar < arr[mid]) {
        // e = mid - 1;
        // }
        // }
        // System.out.println(-1);
    }
}