import java.util.*;
import java.io.*;

public class l11_GCD_and_LCM {
    public static int __gcd(int a, int b) {
        if (a == 0)
            return b;
        return __gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        System.out.println(__gcd(n1, n2));
        System.out.println(n1 * n2 / __gcd(n1, n2));
    }
}