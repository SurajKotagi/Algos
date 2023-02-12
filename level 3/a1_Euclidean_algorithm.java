import java.util.*;
import java.io.*;

public class a1_Euclidean_algorithm {
    public static int __gcd(int a, int b) {
        if (a == 0)
            return b;
        return __gcd(b % a, a);
    }

    public static void main(String[] args) {
        // gcd of two numbers with recursion
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int res = __gcd(a, b);
        System.out.println(res);
    }
}