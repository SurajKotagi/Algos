import java.util.*;
import java.io.*;

public class l50_inverted_bar_chart {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int max = Integer.MIN_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] > 0) {
                    System.out.print("*\t");
                    arr[j] -= 1;
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}