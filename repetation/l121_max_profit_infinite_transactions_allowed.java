import java.util.*;
import java.io.*;

public class l121_max_profit_infinite_transactions_allowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] price = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            price[i] = scn.nextInt();
        }

        int[] dpbuy = new int[n + 1];
        int[] dpsell = new int[n + 1];
        dpbuy[1] = 1;
        dpsell[1] = 1;

        int final_prof = 0;
        int prof = 0;
        for (int i = 2; i <= n; i++) {
            if (price[i - 1] < price[i]) {
                dpbuy[i] = dpbuy[i - 1];
                dpsell[i] = i;
                prof = price[dpsell[i]] - price[dpbuy[i]];
            } else {
                final_prof += prof;
                // System.out.print(final_prof + " ");
                prof = 0;
                dpbuy[i] = i;
                dpsell[i] = i;
            }
        }
        final_prof += prof;
        System.out.println(final_prof);
    }
}