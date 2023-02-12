import java.io.*;
import java.util.*;

public class coinchange2 {
    // amtsf - amount so far
    // ramtsf - remaining amount so far

    public static void coinChange(int idx, int[] coins, int amtsf, int ramtsf, int tamt, String asf) {
        // base case
        if (idx == coins.length) {
            if (amtsf == tamt) {
                System.out.println(asf + ".");
            }
            return;
        }

        for (int i = ramtsf / coins[idx]; i >= 1; i--) {
            // System.out.println(asf);
            String a = "";
            for (int j = 0; j < i; j++) {
                a = a + coins[idx] + "-";
            }

            coinChange(idx + 1, coins, amtsf + coins[idx] * i, tamt - (amtsf + coins[idx] * i), tamt,
                    asf + a);

        }
        coinChange(idx + 1, coins, amtsf, ramtsf, tamt, asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());

        coinChange(0, coins, 0, amt, amt, "");
    }
}