import java.util.*;
import java.io.*;

public class l10_rotate_number {
    public static long dec_giver(long n) {
        long res = 1;
        while (n != 0) {
            res *= 10;
            n--;
        }
        return res;
    }

    public static int n_digits(long n) {
        int c = 0;
        while (n > 0) {
            n /= 10;
            c++;
        }
        return c;
    }

    public static long mul(long n) {
        long x = 1;
        while (n > 0) {
            n /= 10;
            x *= 10;
        }
        return x / 10;
    }

    public static long soln2(long n, long mn) {
        long d = n % 10;
        n /= 10;

        long res = 0;
        res += d * mn;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long num = scn.nextInt();
        long k = scn.nextInt();

        // method 1

        // long temp = num;

        // long mul = 1;
        // long c = 0;
        // while (temp > 0) {
        // temp /= 10;
        // c++;
        // mul *= 10;
        // }
        // mul /= 10;

        // // System.out.println(c);
        // k = (k < 0) ? c + k % c : k % c; // because java gives wrong answer for mod
        // of negetive number
        // // System.out.println(-160451990 % c);

        // long res = num % dec_giver(k) * dec_giver(c - k);
        // res += num / dec_giver(k);
        // System.out.println(res);

        // 72076559
        // -160451990
        // method 2

        int n_dig = n_digits(num);
        k = (k < 0) ? n_dig + k % n_dig : k % n_dig; // because java gives wrong answer for mod of negetive number
        // System.out.println(Math.floorMod(k,n_dig)); we can use built in function for
        // that

        long m = mul(num);
        while (k != 0) {
            num = soln2(num, m);
            k--;
        }
        System.out.println(num);
    }
}