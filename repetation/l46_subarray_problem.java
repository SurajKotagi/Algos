import java.util.*;
import java.io.*;

public class l46_subarray_problem {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + "\t");
                    if (k == j) {
                        System.out.println();
                    }
                }

            }
        }
    }
}