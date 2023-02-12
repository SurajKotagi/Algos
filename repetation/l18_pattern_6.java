import java.util.*;
import java.io.*;

public class l18_pattern_6 {
    public static void upper(int ls, int sp, int rs) {
        if (ls < 1) {
            return;
        }
        for (int i = 0; i < ls; i++) {
            System.out.print("*\t");
        }
        for (int i = 0; i < sp; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < rs; i++) {
            System.out.print("*\t");
        }
        System.out.println();
        upper(ls - 1, sp + 2, rs - 1);
    }

    public static void lower(int ls, int sp, int rs) {
        if (ls == 1) {
            return;
        }
        lower(ls - 1, sp + 2, rs - 1);
        for (int i = 0; i < ls; i++) {
            System.out.print("*\t");
        }
        for (int i = 0; i < sp; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < rs; i++) {
            System.out.print("*\t");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // int ls = (n / 2) + 1;
        // int rs = (n / 2) + 1;
        // int sp = 1;

        // for (int k = 1; k <= n; k++) {
        // for (int i = 0; i < ls; i++) {
        // System.out.print("*\t");
        // }
        // for (int i = 0; i < sp; i++) {
        // System.out.print("\t");
        // }
        // for (int i = 0; i < rs; i++) {
        // System.out.print("*\t");
        // }
        // System.out.println();

        // if (k <= n / 2) {
        // ls -= 1;
        // rs -= 1;
        // sp += 2;
        // } else {
        // sp -= 2;
        // ls += 1;
        // rs += 1;
        // }
        // }

        // method 2

        int ls = (n / 2) + 1;
        int rs = (n / 2) + 1;
        int sp = 1;
        upper(ls, sp, rs);
        lower(ls, sp, rs);
    }
}