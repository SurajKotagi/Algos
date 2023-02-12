import java.util.*;
import java.io.*;

public class l67_print_decreasing {
    public static void rec(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        rec(n - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        rec(n);
    }
}