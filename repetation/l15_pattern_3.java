import java.util.*;
import java.io.*;

public class l15_pattern_3 {
    public static void rec(int n, int t, int s) {
        if (t == -1) {
            return;
        }

        for (int i = 1; i <= t; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= s; i++) {
            System.out.print("*\t");
        }
        System.out.println();
        rec(n - 1, t - 1, s + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n; j++) {
        // if (j > n - i) {
        // System.out.print("*\t");
        // } else {
        // System.out.print("\t");
        // }
        // }
        // System.out.println();
        // }

        // method 2
        rec(n, n - 1, 1);
    }
}