import java.util.*;
import java.io.*;

public class q3_checkIfArrayIsSorted {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(isSorted(arr, n));
    }

    // optimal approach
    public static boolean isSorted(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i])
                return false;
        }
        return true;
    }

}