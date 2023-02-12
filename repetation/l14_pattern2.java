import java.util.*;
import java.io.*;

public class l14_pattern2 {
    public static void rec(int n) {
        if (n == 0) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print("*\t");
        }
        System.out.println();
        rec(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n; j++) {
        // if (j <= n - i + 1) {
        // System.out.print("*\t");
        // } else {
        // System.out.print("\t");
        // }
        // }
        // System.out.println();
        // }

        // method 2

        rec(n);
    }
}