import java.util.*;
import java.io.*;

public class mx1tiles {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        // edge case
        if (n < m) {
            System.out.println(1);
            return;
        }

        // int ans = solution1(m, n); // recursive
        int ans = solution2(m, n); // tabulative
        System.out.println(ans);

    }
    // evoulution

    // RECURSIVE CODE
    public static int solution1(int m, int n) {

        // dont think too much (dont go into the depth)

        // base case
        // complete data known for a smallest n value
        if (n == m) { // setting value for smallest n where tile can be placed both horizontally and
                      // vertically
            return 2;
        }
        if (n < m) { // setting values for smallest n's where the tile can be placed only vertivcally
            return 1;
        }

        // there are tow possiblities of placing tile (1)vertically (2)horizontally

        // if you place a tile vertically then total ways will be all possible ways of
        // placing tiles in n-1 length
        int by_vertical = solution1(m, n - 1);
        // if you place a tile horizontally then the total ways will be all possible
        // ways of placing tiles is remaining n-m length
        int by_horizontal = solution1(m, n - m);

        // at current n the total ways will be sum of both options
        int total = by_vertical + by_horizontal;

        return total;
    }

    // TABULATION METHOD
    public static int solution2(int m, int n) {
        int[] dp = new int[n + 1];

        // assigning the base case values of dp array
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }
        dp[m] = 2;

        for (int i = m + 1; i <= n; i++) {
            // ways whithin i length is equal to sum of ways in i-1 length and ways within
            // i-m length
            dp[i] = dp[i - 1] + dp[i - m];
        }

        return dp[n];
    }
}
