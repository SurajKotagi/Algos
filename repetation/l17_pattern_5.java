import java.util.*;
import java.io.*;

public class l17_pattern_5 {
    public static void upper(int n, int lsp, int s, int rsp) {
        if (s < 1) {
            return;
        }
        upper(n - 1, lsp + 1, s - 2, rsp + 1);
        for (int i = 0; i < lsp; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < s; i++) {
            System.out.print("*\t");
        }
        for (int i = 0; i < rsp; i++) {
            System.out.print("\t");
        }
        System.out.println();
    }

    public static void lower(int n, int lsp, int s, int rsp) {
        if (s < 1) {
            return;
        }
        for (int i = 0; i < lsp; i++) {
            System.out.print("\t");
        }
        for (int i = 0; i < s; i++) {
            System.out.print("*\t");
        }
        for (int i = 0; i < rsp; i++) {
            System.out.print("\t");
        }
        System.out.println();
        lower(n - 1, lsp + 1, s - 2, rsp + 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // int lsp = (n - 1) / 2;
        // int rsp = (n - 1) / 2;
        // int star = 1;
        // for (int i = 1; i <= n; i++) {
        // for (int k = 0; k < lsp; k++) {
        // System.out.print("\t");
        // }
        // for (int k = 0; k < star; k++) {
        // System.out.print("*\t");
        // }
        // for (int k = 0; k < rsp; k++) {
        // System.out.print("\t");
        // }

        // if (i <= n / 2) {
        // star += 2;
        // lsp--;
        // rsp--;
        // } else {
        // star -= 2;
        // lsp++;
        // rsp++;
        // }
        // System.out.println();
        // }

        // method 2
        upper(n, 0, n, 0);
        lower(n - 1, 1, n - 2, 1);
    }
}