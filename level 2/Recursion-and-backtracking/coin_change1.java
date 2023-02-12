import java.io.*;
import java.util.*;

public class coin_change1 {

    public static void coinChange(int idx, int prev, int[] coins, int amtsf, int tamt, String asf) {
        // base case
        if (amtsf == tamt) {
            System.out.println(asf + ".");
            return;
        }

        for (int i = prev + 1; i < coins.length; i++) {
            // System.out.println(asf);
            coinChange(idx + 1, i, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");

        }
        // System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());

        coinChange(0, -1, coins, 0, amt, "");
    }
}