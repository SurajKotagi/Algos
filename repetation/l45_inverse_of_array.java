import java.util.*;
import java.io.*;

public class l45_inverse_of_array {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // input
        // 0 1 2 3 4 -- > idx
        // 4 0 2 3 1

        // output
        // 0 1 2 3 4
        // 1 4 2 3 0

        int[] narr = new int[n];
        for (int i = 0; i < n; i++) {
            narr[arr[i]] = i;
        }
        for (int val : narr) {
            System.out.println(val);
        }
    }
}