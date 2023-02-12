import java.util.*;
import java.io.*;

public class friendspairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int res = solution2(n);
        System.out.println(res);
    }

    // Recursive method
    public static int solution(int n) {
        // base case
        if (n <= 2)
            return n;

        // there are two options for a person , he can remain alone or he can pair up
        // with any one of the members

        // call that he chooses to remain alone
        int alone = solution(n - 1);

        // chooses to be paired

        // when to be paired he can be paired in n-1 members after pairing same count of
        // members remains
        int paired = solution(n - 2);
        paired = paired * (n - 1);

        int total_count = alone + paired;

        return total_count;
    }

    // Tabulation method
    public static int solution2(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] * (i - 1);
        }
        return dp[n];
    }
}