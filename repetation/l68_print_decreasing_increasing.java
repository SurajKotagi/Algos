import java.util.*;
import java.io.*;

public class l68_print_decreasing_increasing {
    public static void rec(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        rec(n - 1);
    }

    public static void rec2(int st, int n) {
        if (st == n + 1) {
            return;
        }
        System.out.println(st);
        rec2(st + 1, n);
    }

    public static void rec3(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        rec3(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // rec(n);
        // rec2(1, n);
        rec3(n);
    }
}