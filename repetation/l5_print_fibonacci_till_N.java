import java.util.*;
import java.io.*;

public class l5_print_fibonacci_till_N {
    // recursive
    public static int fib(int n, int[] fib_dp) {
        if (n == 1 || n == 2) {
            return n - 1;
        } else if (fib_dp[n] != 0) {
            return fib_dp[n];
        }
        fib_dp[n] = fib(n - 1, fib_dp) + fib(n - 2, fib_dp);
        return fib_dp[n];
    }

    // dynamic programming
    public static void fib2(int n, int[] fib_dp) {
        if (n == 0)
            return;
        fib_dp[1] = 0;
        if (n == 1)
            return;
        fib_dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib_dp[i] = fib_dp[i - 1] + fib_dp[i - 2];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // recursive call

        // int[] fib_dp = new int[n + 1];
        // for (int i = 1; i <= n; i++) {
        // System.out.print(fib(i, fib_dp) + " ");
        // }

        // dynamic call

        // int[] fib_dp = new int[n + 1];
        // fib2(n, fib_dp);
        // for (int i = 1; i <= n; i++) {
        // System.out.print(fib_dp[i] + " ");
        // }

        // tabulation

        if (n == 1) {
            System.out.println("0 ");
            return;
        }
        if (n == 2) {
            System.out.println("0 1 ");
            return;
        }
        int temp1 = 0;
        System.out.print("0 1 ");
        int temp2 = 1;
        for (int i = 3; i <= n; i++) {
            int ans = temp1 + temp2;
            temp1 = temp2;
            temp2 = ans;
            System.out.print(ans + " ");
        }
    }
}