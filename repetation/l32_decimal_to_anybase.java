import java.util.*;
import java.io.*;

public class l32_decimal_to_anybase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();

        // method 1

        // String s = "";
        // while (n > 0) {
        // int r = n % b;
        // s = r + s;
        // n /= b;
        // }
        // System.out.print(s);

        // method 2

        int res = 0;
        int mul = 1;
        while (n > 0) {
            int d = n % b;
            res += d * mul;

            n /= b;
            mul *= 10;
        }
        System.out.print(res);
    }
}