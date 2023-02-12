import java.util.*;
import java.io.*;

public class membersintoteams {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long res = solution2(n, k);
        System.out.println(res);
    }

    // recursive method
    public static long solution(long n, long k) {
        // base cases
        if (n < k) // players are less teams are more(2 teams using 1 member)
            return 0;
        if (k == 1) // one team is to be made (all in one team)
            return 1;
        if (n == k) // each member making his own team
            return 1;
        // it,s told that compulsorily a person should be in a team

        // there are two options for each member
        // (1) He can choose to make his own team
        // (2) He can decide to join any team

        // call that a member decides to make his team
        long own = solution(n - 1, k - 1);

        // call that a member decides to join any team
        long join = solution(n - 1, k);
        // if k are formed by n-1 members then there are k teams which nth member can
        // decide to go
        join = join * k;

        long total = own + join;
        return total;
    }

    // Tabulation method
    public static long solution2(int n, int k) {

        long[][] dp = new long[n + 1][k + 1];

        for (int members = 1; members < dp.length; members++) {
            for (int teams = 1; teams < dp[0].length; teams++) {
                int i = members, j = teams;
                if (members < teams) {
                    dp[i][j] = 0;
                } else if (teams == 1) {
                    dp[i][j] = 1;
                } else if (members == teams) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] * j + dp[i - 1][j - 1];
                }
            }
        }
        // for (int members = 0; members < dp.length; members++) {
        // for (int teams = 0; teams < dp[0].length; teams++) {
        // System.out.print(dp[members][teams] + " ");
        // }
        // System.out.println();
        // }
        return dp[n][k];
    }
}