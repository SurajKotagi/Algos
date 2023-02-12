import java.io.*;
import java.util.*;

public class allrepxptone {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        // xoring all the elements, remaining element iis no repeted
        int ans = 0;
        for (int val : arr) {
            ans ^= val;
        }
        System.out.println(ans);
    }
}