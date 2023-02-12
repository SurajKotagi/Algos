import java.util.*;
import java.io.*;

public class l36_anybase_substraction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n2 = scn.nextInt();
        int n1 = scn.nextInt();

        int res = 0;
        int mul = 1;
        int c = 0;
        while (n1 > 0 && n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            int diff = 0;
            if (d1 >= d2 + c) {
                diff = d1 - d2 - c;
                c = 0;
            } else {
                diff = d1 + b - d2 - c;
                c = 1;
            }

            res += diff * mul;

            n1 /= 10;
            n2 /= 10;
            mul *= 10;
        }
        while (n1 > 0) {
            int d = n1 % 10;

            int diff = 0;
            if (d >= c) {
                diff = d - c;
                c = 0;
            } else {
                diff = d + b - c;
                c = 1;
            }

            res += diff * mul;
            n1 /= 10;
            mul *= 10;
        }
        while (n2 > 0) {
            int d = n2 % 10;

            int diff = 0;
            if (d >= c) {
                diff = d - c;
                c = 0;
            } else {
                diff = d + b - c;
                c = 1;
            }

            res += diff * mul;
            n2 /= 10;
            mul *= 10;
        }
        if (c > 0) {
            res += c * mul;
        }
        System.out.println(res);
    }
}