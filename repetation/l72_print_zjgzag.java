import java.util.*;
import java.io.*;

public class l72_print_zjgzag {
    public static void rec(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        rec(n - 1);
        System.out.print(n + " ");
        rec(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        rec(n);
    }
}