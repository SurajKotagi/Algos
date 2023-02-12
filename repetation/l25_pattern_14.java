import java.util.*;
import java.io.*;

public class l25_pattern_14 {
    public static void rec(int n, int i) {
        if (i == 0)
            return;

        rec(n, i - 1);
        System.out.println(n + " * " + i + " = " + (n * i));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // for (int i = 1; i <= 10; i++) {
        // System.out.println(n + " * " + i + " = " + (n * i));
        // }

        // method 2

        rec(n, 10);
    }
}