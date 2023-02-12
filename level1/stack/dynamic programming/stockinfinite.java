import java.io.*;
import java.util.*;

public class stockinfinite {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int buy = prices[0];
        int sell = prices[0];

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            if (price >= prices[i - 1]) {
                sell = price;
            } else {
                profit += sell - buy;
                buy = price;
                sell = price;
            }
        }
        profit += sell - buy;
        System.out.println(profit);
    }

    // Reduced
    // public static void main(String[] args) throws Exception {
    // Scanner scn = new Scanner(System.in);
    // int n = scn.nextInt();

    // int[] p = new int[n];
    // for (int i = 0; i < n; i++) {
    // p[i] = scn.nextInt();
    // }

    // int pft = 0, b = p[0], s = p[0];
    // for (int i = 1; i < p.length; i++) {
    // int cp = p[i];
    // if (cp >= p[i - 1])
    // s = cp;
    // else {
    // pft += s - b;
    // b = s = cp;
    // }
    // }
    // pft += s - b;
    // System.out.println(pft);
    // }

}