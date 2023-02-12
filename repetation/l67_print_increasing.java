import java.util.*;
import java.io.*;

public class l67_print_increasing {
    public static void rec(int n) {
        if (n == 0) {
            return;
        }

        rec(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        rec(n);
    }
}