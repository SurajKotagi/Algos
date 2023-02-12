import java.util.*;
import java.io.*;

public class l120_buy_and_sell_stocks_one_transactions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = scn.nextInt();
        }
        int[] gtr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, price[i]);
            gtr[i] = max;
        }

        int max_prof = 0;
        for (int i = 0; i < n; i++) {
            int val = gtr[i] - price[i];
            max_prof = Math.max(max_prof, val);
        }

        System.out.println(max_prof);
    }
}