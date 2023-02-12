import java.util.*;
import java.io.*;

public class sqrt {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long x = 2147395599;

        // if (x == 0 || x == 1)
        // return x;

        long s = 0;
        long e = x;

        while (s <= e) {
            long m = (s + e) / 2;
            if (m * m == x) {
                System.out.println(m);
                return;
            } else if (m * m < x) {
                s = m + 1;
            } else if (m * m > x) {
                e = m - 1;
            }
        }
        System.out.println(s - 1);
    }
}