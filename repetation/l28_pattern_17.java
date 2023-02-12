import java.util.*;
import java.io.*;

public class l28_pattern_17 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int s = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n / 2; j++) {
                if (i == n / 2 + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }

            }
            for (int k = 1; k <= s; k++) {
                System.out.print("*\t");
            }

            if (i <= n / 2) {
                s++;
            } else {
                s--;
            }
            System.out.println();
        }
    }
}