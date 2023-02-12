import java.io.*;
import java.util.*;

public class climbingstairs {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // making qb array of size n+1
        // the paths posiible from nth step are store in qb[n]
        int[] qb = new int[n + 1];

        // int res = climbStairsRecursive(n, qb);
        int res = climbStairsRecursive2(n);
        System.out.println(res);
    }

    // MEMOIZATION:
    public static int climbStairsRecursive(int n, int[] qb) {

        // base case (as there is only one path at destination spot i.e standing still)
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        // using question bank to block repetative un-necessary calls
        if (qb[n] != 0) {
            return qb[n];
        }

        // as we can move single step or two step, three steps at a time
        // from current spot there are three possiblities

        // paths possible from n-1 th step
        int n1 = climbStairsRecursive(n - 1, qb);
        // paths possible from n-2 th step
        int n2 = climbStairsRecursive(n - 2, qb);
        // paths possible from n-3 th step
        int n3 = climbStairsRecursive(n - 3, qb);

        // as i can move to n-1 , n-2 , n-3 directly from initial step
        // the total paths can be given as
        int total_paths = n1 + n2 + n3;

        // updating question bank(adding ans to qb)
        qb[n] = total_paths;

        return total_paths;
    }

    // TABULATION
    public static int climbStairsRecursive2(int n) {

        // making dp array to store the path from n at dp[n]
        int[] dp = new int[n + 1];

        for (int step = 0; step <= n; step++) {
            if (step == 0) {
                dp[step] = 1;

            } else if (step == 1) {
                dp[step] = dp[step - 1];

            } else if (step == 2) {
                dp[step] = dp[step - 1] + dp[step - 2];

            } else {
                dp[step] = dp[step - 1] + dp[step - 2] + dp[step - 3];

            }
        }
        return dp[n];
    }
}