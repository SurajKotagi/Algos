import java.util.*;
import java.io.*;

public class l40_bar_chart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
        }

        for (int i = max; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == arr[j]) {
                    System.out.print("*\t");
                    arr[j] = arr[j] - 1;
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}